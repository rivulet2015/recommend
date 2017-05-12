package com.alfago.weixin.common.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


@Component
public class FreeMarkerWorker {
    
    private static final Integer TEMPLATE_LOADING_FILE = 1;
    private static final Integer TEMPLATE_LOADING_PROJECT = 2;
    public static final String module = FreeMarkerWorker.class.getName();
    //protected static BeansWrapper defaultAlfagoWrapper = BeansWrapper.getDefaultInstance();
    //protected static Configuration defaultAlfagoConfig = makeConfiguration(defaultAlfagoWrapper);
    //protected static String templatePath;
    protected static Map<String,Template> cache = new HashMap<String,Template>();
    
    /*
    public static Configuration makeConfiguration(BeansWrapper wrapper) {
        Configuration newConfig = new Configuration();
        newConfig.setObjectWrapper(wrapper);
        //newConfig.setDirectoryForTemplateLoading(new File(templatePath));
        newConfig.setClassForTemplateLoading(FreeMarkerWorker.class, templatePath);
        newConfig.setTemplateExceptionHandler(new FreeMarkerWorker.AlfagoTemplateExceptionHandler());
        return newConfig;
    }
    */
    
    
    @Autowired
    private  FreeMarkerConfigurer freemarkerConfigurer;
    
    
    
/*    static{
        try {
            initConfig(TEMPLATE_LOADING_FILE, "E:/Lunatic/workspaces/FreemarkerDemo/ftl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    *//**
     * 初始化Freemarker参数配置
     * @param type 模板文件夹路径类型，1：文件系统路径；2：项目路径
     * @param dir 模板文件夹路径，当type=1时，文件系统中的绝对路径；当type=2时，项目中相对路径，与src同级开始,以"/开头"
     * @throws Exception 
     *//*
    public static void initConfig(Integer type,String dir) throws Exception{
        *//**
         * 通过Freemaker的Configuration读取相应的ftl,配置Freemarker模板参数信息
         *//*
        freemarkerConfig = new Configuration();
        *//**
         * 设置模板本件夹路径：
         * 1、setDirectoryForTemplateLoading，文件系统绝对路径
         * 2、setClassForTemplateLoading项目相对路径
         *//*
        if(TEMPLATE_LOADING_FILE == type){
            try {
                freemarkerConfig.setDirectoryForTemplateLoading(new File(dir));
            } catch (IOException e) {
                throw new Exception("设置模板文件夹异常",e);
            }            
            
        }
        if(TEMPLATE_LOADING_PROJECT == type){
            freemarkerConfig.setClassForTemplateLoading(FreemarkerUtil.class,dir);
        }
    }*/

    public FreeMarkerConfigurer getFreemarkerConfigurer() {
		return freemarkerConfigurer;
	}

	public void setFreemarkerConfigurer(FreeMarkerConfigurer freemarkerConfigurer) {
		this.freemarkerConfigurer = freemarkerConfigurer;
	}

	/**
     * 获取Freemarker模板文件
     * @param name 文件名
     * @return
     */
    public  Template getTemplate(String name) {
        Template temp = null;
        try {
        	temp = cache.get(name);
        	if(temp == null){
        		temp = freemarkerConfigurer.getConfiguration().getTemplate(name,"UTF-8");
        		cache.put(name, temp);
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
        
    }

	/**
     * 将解析之后的文件内容保存到文件中
     * @param name 模板文件名
     * @param root 数据Map
     * @param outFile 保存文件路径
     */
    public  void printFile(String name,Map<String,Object> root,String outFile) {
        FileWriter out = null;
        try {
            //通过一个文件输出流，就可以写到相应的文件中
            out = new FileWriter(new File(outFile));
            Template temp = this.getTemplate(name);
            //temp.process(root, out);
            renderTemplate(temp,root,out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out!=null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 将解析之后的文件内容返回字符串
     * @param name 模板文件名
     * @param root 数据Map
     * @return
     */
    public  String printString(String name,Map<String,Object> root) {
        StringWriter out = new StringWriter();
        try {
            //通过一个文件输出流，就可以写到相应的文件中
            Template temp = this.getTemplate(name);
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out!=null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }
    
    
    
    
    
    public  void printConsole(String name,Map<String,Object> root) {
        System.out.println(this.printString(name, root));
    }
    
    
    /**
     * Renders a template at the specified location.
     * @param templateLocation Location of the template - file path or URL
     * @param context The context Map
     * @param outWriter The Writer to render to
     */
    public void renderTemplateAtLocation(String templateLocation, Map<String, Object> context, Appendable outWriter) throws MalformedURLException, TemplateException, IOException {
        renderTemplate(templateLocation, context, outWriter);
    }
    
    public  void renderTemplate(String templateLocation, Map<String, Object> context, Appendable outWriter) throws TemplateException, IOException {
        Template template = this.getTemplate(templateLocation);
        renderTemplate(template, context, outWriter);
    }
    
    /**
     * Renders a Template instance.
     * @param template A Template instance
     * @param context The context Map
     * @param outWriter The Writer to render to
     */
    public static Environment renderTemplate(Template template, Map<String, Object> context, Appendable outWriter) throws TemplateException, IOException {
        // make sure there is no "null" string in there as FreeMarker will try to use it
        context.remove("null");
        // Since the template cache keeps a single instance of a Template that is shared among users,
        // and since that Template instance is immutable, we need to create an Environment instance and
        // use it to process the template with the user's settings.
        //
        // FIXME: the casting from Appendable to Writer is a temporary fix that could cause a
        //        run time error if in the future we will pass a different class to the method
        //        (such as a StringBuffer).
        Environment env = template.createProcessingEnvironment(context, (Writer) outWriter);
        env.setClassicCompatible(true);
        applyUserSettings(env, context);
        env.process();
        return env;
    }
    

    /**
     * Apply user settings to an Environment instance.
     * @param env An Environment instance
     * @param context The context Map containing the user settings
     */
    public static void applyUserSettings(Environment env, Map<String, Object> context) throws TemplateException {
        Locale locale = (Locale) context.get("locale");
        if (locale == null) {
            locale = Locale.getDefault();
        }
        env.setLocale(locale);

        TimeZone timeZone = (TimeZone) context.get("timeZone");
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        env.setTimeZone(timeZone);
    }

    
    static class AlfagoTemplateExceptionHandler implements TemplateExceptionHandler {
        public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
            StringWriter tempWriter = new StringWriter();
            PrintWriter pw = new PrintWriter(tempWriter, true);
            te.printStackTrace(pw);
            String stackTrace = tempWriter.toString();


           try {
                out.write(stackTrace);
            } catch (IOException e) {
               // Debug.logError(e, module);
            }
        }
    }
}

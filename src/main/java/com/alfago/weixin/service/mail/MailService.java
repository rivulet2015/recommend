package com.alfago.weixin.service.mail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.alfago.weixin.common.freemarker.FreeMarkerWorker;

@Service("mailService")
public class MailService
{

  @Resource(name="mailSender")
  private JavaMailSender mailSender;
  
  @Resource(name="freeMarkerWorker")
  private FreeMarkerWorker freeMarkerWorker;
  
  private static final String juniorClubNotify = "Estimado %s:\nGracias por formar parte de Chile China Central!\nSi no puedes hacer click en el bot��n, copia y pega el siguiente link en la barra de direcci��n de tu navegador.\n%s\nEn caso de no activar tu cuenta, ser�� eliminada autom��ticamente despu��s de 24 horas.\n";
  private static final String seniorClubNotify = "Estimado %s:\nEnhorabuena por ascender al grado superior. Le hemos abierto todas las funciones de miembro. Pru��belas enseguida.\nSi no puedes hacer click en el bot��n, copia y pega el siguiente link en la barra de direcci��n de tu navegador.\n%s\nEn caso de no activar tu cuenta, ser�� eliminada autom��ticamente despu��s de 24 horas.\n";
  private static String activeUrl;
  private static String loginUrl;
  private static String host;
  private static String juniorClubHtml = "";
  private static String seniorClubHtml = "";

  static
  {
    try
    {
      InputStream inputStream = MailService.class.getClassLoader().getResourceAsStream("service.properties");
      Properties properties = new Properties();
      properties.load(inputStream);
      activeUrl = properties.getProperty("activeUrl");
      loginUrl = properties.getProperty("loginUrl");
      host = properties.getProperty("host");
      juniorClubHtml = readHTMLFile("junior.txt");
      seniorClubHtml = readHTMLFile("senior.txt");
    }
    catch (Exception localException)
    {
    }
  }

  public JavaMailSender getMailSender()
  {
    return this.mailSender;
  }

  
  public void setMailSender(JavaMailSender mailSender) {
	  
    this.mailSender = mailSender;
  }
  
  private static String readHTMLFile(String path) throws IOException
  {
	  
      String str = "";  
      InputStream input = MailService.class.getClassLoader().getResourceAsStream(path);
      try  
      {  
    	  
    	  String encode = "utf-8";
          BufferedReader reader = new BufferedReader(new InputStreamReader(input, encode));  
          StringBuffer sb = new StringBuffer();  
            
          while ((str = reader.readLine()) != null)  
          {  
              sb.append(str).append("\n");  
          }  
          return sb.toString();  
      }  
      catch (UnsupportedEncodingException e1)  
      {  
          e1.printStackTrace();  
      }  
      catch (IOException e)  
      {  
          e.printStackTrace();  
      }  
        
      return str; 
  }

  public void sendHtmlEmail(String from, String to, String subject,String path) throws IOException, MessagingException{
	  
	  //String content = readHTMLFile(path);
	  Map<String,String> userInfo = new HashMap<String,String>();
	  userInfo.put("qq", "601838594");
	  Map<String,Object> root = new HashMap<String,Object>();
	  root.put("userInfo", userInfo);
	  String content = freeMarkerWorker.printString(path, root);
	  sendMail(from,  to,  subject, content);
  }
  
  public void sendMail(String from, String to, String subject, String content)
		    throws MessagingException, UnsupportedEncodingException
		  {
		    MimeMessage mineMsg = this.mailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(mineMsg, true, "UTF-8");
		    String nick = MimeUtility.encodeText("China Chile Central");
		    helper.setTo(to);
		    //helper.setFrom(new InternetAddress(String.format(nick + " <%s>", new Object[] { from })));
		    helper.setFrom(from);
		    helper.setSubject(subject);
		    helper.setText(content, true);
		    this.mailSender.send(mineMsg);
		  }


}
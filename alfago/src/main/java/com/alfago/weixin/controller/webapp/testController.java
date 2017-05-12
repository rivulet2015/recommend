package com.alfago.weixin.controller.webapp;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alfago.weixin.common.utils.FastJsonTools;



@Controller
@RequestMapping("/welcome")
public class testController {

	 
    @RequestMapping(value="/hello.do",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");

        return "hello";

    }
    
	@RequestMapping(value="/showInfos",method = RequestMethod.GET)
	public @ResponseBody Object showUserInfos(){
		//UserEntity userInfos = userInfoService.selectById(Long.valueOf("1221"));
		return null;
	}
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public @ResponseBody Object test(){
		//UserEntity userInfos = userInfoService.selectById(Long.valueOf("1"));
		return null;
	}  	

	@RequestMapping(value="/dataentity/listdataentity",method ={RequestMethod.OPTIONS,RequestMethod.GET})
	public @ResponseBody Object listdataentity() throws IOException{
	      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db1.json");
	      String content = IOUtils.toString(inputStream,"UTF-8");
	      
		return FastJsonTools.getJSONArray(content);
	}  	
	@RequestMapping(value="/datafield/1",method ={RequestMethod.OPTIONS,RequestMethod.GET})
	public @ResponseBody Object datafield() throws IOException{
	      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db3.json");
	      String content = IOUtils.toString(inputStream,"UTF-8");
	      
		return FastJsonTools.getJSONArray(content);
	}  		

	@RequestMapping(value="/tablelineage/1",method ={RequestMethod.OPTIONS,RequestMethod.GET})
	public @ResponseBody Object tablelineage() throws IOException{
	      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db2.json");
	      String content = IOUtils.toString(inputStream,"UTF-8");
		return FastJsonTools.getJSONArray(content);
	}  		
}

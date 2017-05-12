package com.alfago.weixin.controller.webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alfago.weixin.common.entitys.PageElementEntity;
import com.alfago.weixin.common.utils.FastJsonTools;
import com.alfago.weixin.common.vo.ElementVo;
import com.alfago.weixin.service.persistence.PageElementService;

@Controller
@RequestMapping("/element")
public class ElementController {
	
	@Resource(name="pageElementService")
	private PageElementService pageElementService;
	
	@RequestMapping(value="/show.do",method ={RequestMethod.GET})
	public  Object show() throws IOException{
		
		return "element";
	}

	@RequestMapping(value="/list.do",method ={RequestMethod.GET})
	@ResponseBody
	public  Object listModule(@RequestParam("pageId") int pageId,@RequestParam("moduleId") int moduleId,ModelMap model) throws IOException{

		PageElementEntity entity = new PageElementEntity();
		entity.setPageId(pageId);
		entity.setModuleId(moduleId);
		List<PageElementEntity> list = pageElementService.selectList(entity);
		List<ElementVo> listVo = new ArrayList<ElementVo>();
		for(PageElementEntity e: list){
			ElementVo vo = new ElementVo(e);
			listVo.add(vo);
		}	
		return listVo;
	}  		
	
	@RequestMapping(value="/add.do",method ={RequestMethod.POST})
	@ResponseBody
	public  Object addModule(@RequestParam("pageId") int pageId,@RequestParam("moduleId") int moduleId,@RequestParam("keyname") String keyname,@RequestParam("value") String value,ModelMap model) throws IOException{
		PageElementEntity entity = new PageElementEntity();
		entity.setKeyname(keyname);
		entity.setModuleId(moduleId);
		entity.setValue(value);
		entity.setSystime(new Date());
		pageElementService.insert(entity);
		ElementVo vo = new ElementVo(entity);
		return vo;
	}  	

	@RequestMapping(value="/update.do",method ={RequestMethod.POST})
	@ResponseBody
	public  Object updatePage(@RequestParam("id") int id,@RequestParam("pageId") int pageId,@RequestParam("moduleId") int moduleId,@RequestParam("keyname") String keyname,@RequestParam("value") String value,ModelMap model) throws IOException{
		PageElementEntity entity = new PageElementEntity();
		entity.setId(id);
		entity.setKeyname(keyname);
		entity.setModuleId(moduleId);
		entity.setValue(value);
		entity.setSystime(new Date());
		pageElementService.update(entity);
		ElementVo vo = new ElementVo(entity);
		return vo;
	} 
	
	@RequestMapping(value="/delete.do",method ={RequestMethod.GET})
	@ResponseBody
	public  Object deletePage(@RequestParam("id") int id,ModelMap model) throws IOException{
		pageElementService.delete(id);
		return new PageElementEntity();
	} 			
	
}

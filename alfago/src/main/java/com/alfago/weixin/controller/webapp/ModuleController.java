package com.alfago.weixin.controller.webapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alfago.weixin.common.entitys.ModuleEntity;
import com.alfago.weixin.common.entitys.PageElementEntity;
import com.alfago.weixin.common.entitys.PageEntity;
import com.alfago.weixin.common.utils.FastJsonTools;
import com.alfago.weixin.common.vo.ElementVo;
import com.alfago.weixin.common.vo.ModuleVo;
import com.alfago.weixin.common.vo.PageVo;
import com.alfago.weixin.service.persistence.ModuleService;
import com.alfago.weixin.service.persistence.PageElementService;
import com.alfago.weixin.service.persistence.PageService;

@Controller
@RequestMapping("/module")
public class ModuleController {
	
	@Resource(name="moduleService")
	private ModuleService moduleService;
	
	@RequestMapping(value="/show.do",method ={RequestMethod.GET})
	public  Object show() throws IOException{
		
		return "module";
	}

	@RequestMapping(value="/list.do",method ={RequestMethod.GET})
	@ResponseBody
	public  Object listModule(@RequestParam("pageId") int pageId,ModelMap model) throws IOException{
		ModuleEntity moduleEntity = new ModuleEntity();
		moduleEntity.setPageId(pageId);
		List<ModuleEntity> list = moduleService.selectList(moduleEntity);
		List<ModuleVo> listVo = new ArrayList<ModuleVo>();
		for(ModuleEntity e: list){
			ModuleVo vo = new ModuleVo(e);
			listVo.add(vo);
		}	
		return listVo;
	}  		
	
	@RequestMapping(value="/add.do",method ={RequestMethod.POST})
	@ResponseBody
	public  Object addModule(@RequestParam("pageId") int pageId,@RequestParam("name") String name,ModelMap model) throws IOException{
		ModuleEntity entity = new ModuleEntity();
		entity.setName(name);
		entity.setPageId(pageId);
		entity.setSystime(new Date());
		moduleService.insert(entity);
		ModuleVo moduleVo = new ModuleVo(entity);
		return moduleVo;
	}  	

	@RequestMapping(value="/update.do",method ={RequestMethod.POST})
	@ResponseBody
	public  Object updatePage(@RequestParam("id") int id,@RequestParam("pageId") int pageId,@RequestParam("name") String name,ModelMap model) throws IOException{
		ModuleEntity entity = new ModuleEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setPageId(pageId);
		entity.setSystime(new Date());
		moduleService.update(entity);
		ModuleVo moduleVo = new ModuleVo(entity);
		return moduleVo;
	} 
	
	@RequestMapping(value="/delete.do",method ={RequestMethod.GET})
	@ResponseBody
	public  Object deletePage(@RequestParam("id") int id,ModelMap model) throws IOException{
		moduleService.delete(id);
		return new ModuleEntity();
	} 		
}

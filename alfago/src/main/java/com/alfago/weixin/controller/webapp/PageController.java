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

import com.alfago.weixin.common.entitys.PageEntity;
import com.alfago.weixin.common.utils.FastJsonTools;
import com.alfago.weixin.common.vo.PageVo;
import com.alfago.weixin.service.persistence.PageElementService;
import com.alfago.weixin.service.persistence.PageService;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@Resource(name="pageService")
	private PageService pageService;
	
	@RequestMapping(value="/show.do",method ={RequestMethod.GET})
	public  Object show() throws IOException{
		
		return "page";
	}

	@RequestMapping(value="/list.do",method ={RequestMethod.GET})
	@ResponseBody
	public  Object listPage(ModelMap model) throws IOException{
		
		List<PageEntity> list = pageService.selectList(new PageEntity());
		List<PageVo> listVo = new ArrayList<PageVo>();
		for(PageEntity e: list){
			PageVo vo = new PageVo(e);
			listVo.add(vo);
		}
		return FastJsonTools.toJSONString(listVo);
	}  		
	
	@RequestMapping(value="/add.do",method ={RequestMethod.POST})
	@ResponseBody
	public  Object addPage(@RequestParam ("name") String name,ModelMap model) throws IOException{
		PageEntity pageEntity = new PageEntity();
		pageEntity.setName(name);
		pageEntity.setSystime(new Date());
		pageService.insert(pageEntity);
		PageVo pageVo = new PageVo(pageEntity);
		return pageVo;
	}  	

	@RequestMapping(value="/update.do",method ={RequestMethod.POST})
	@ResponseBody
	public  Object updatePage(@RequestParam ("id") int id,@RequestParam ("name") String name,ModelMap model) throws IOException{
		PageEntity pageEntity = new PageEntity();
		pageEntity.setId(id);
		pageEntity.setName(name);
		pageEntity.setSystime(new Date());
		pageService.update(pageEntity);
		PageVo pageVo = new PageVo(pageEntity);
		return pageVo;
	} 
	
	@RequestMapping(value="/delete.do",method ={RequestMethod.GET})
	@ResponseBody
	public  Object deletePage(@RequestParam("id") int id,ModelMap model) throws IOException{
		pageService.delete(id);
		return new PageEntity();
	} 		
}

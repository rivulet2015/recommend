package com.alfago.weixin.controller.webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alfago.weixin.common.beans.UserEntity;
import com.alfago.weixin.service.persistence.IUserInfoService;

@Controller
@RequestMapping("/")
public class uploadController {
	
/*	@Resource(name="userEntityService")
	private IUserInfoService userEntityService;*/
	
	@RequestMapping("/upload")
	public ModelAndView uploadExcel(@RequestParam("file") MultipartFile file){
		List<UserEntity> list = new ArrayList<UserEntity>();
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		UserEntity info = null;
		try {
			wb = new HSSFWorkbook(file.getInputStream());
			sheet = wb.getSheetAt(0);
			for( int i = 1; i <= sheet.getLastRowNum(); i++ ){
				row = sheet.getRow(i);
				info = new UserEntity();
				info.setQq(row.getCell(0).getStringCellValue());
				info.setState(0);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("content");
		mav.addObject("content",list.toString());
		return mav;
	}	
}

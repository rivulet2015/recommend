package com.alfago.weixin.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

public class FastJsonTools {
	
	public static <T> T getJavaBean(String jsonString,Class<T> cls)
	{
		T t = null;
		t = JSON.parseObject(jsonString, cls);
		return t;
	}
	
	public static JSONObject getJsonObject(String jsonString)
	{
		JSONObject t = null;
		t = JSON.parseObject(jsonString);
		return t;
	}
	
	public static <T> List<T> getJavaBeans(String jsonString,Class<T> cls)
	{
		List<T> list = new ArrayList<T>();
		list = JSON.parseArray(jsonString, cls);
		return list;
	}
	
	public static JSONArray getJSONArray(String jsonString)
	{
		JSONArray list = null;
		list = JSON.parseArray(jsonString);
		return list;
	}

	public static List<Map<String, Object>> getListMap(String jsonString)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
		list = JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {});
		return list;
	}
	
	public static String toJSONString(Object o)
	{ 
		String json = null;
		json = JSON.toJSONString(o);
		return json;
	}
}

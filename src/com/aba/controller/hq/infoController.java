package com.aba.controller.hq;

import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aba.datasource.Simulater;

import dao.Messagedao;
import dao.sectiondao;


@Controller
@RequestMapping(value = "/JSPS",method = RequestMethod.GET)
public class infoController {
	@RequestMapping(value = "/service")
	public String choseSection(ModelMap map,@RequestParam String section){
		map.addAttribute("section",section);
		return "/choseService";
	}
	
	@RequestMapping(value = "/information")
	public String getMessage(ModelMap map,
			@RequestParam int section,
			@RequestParam int service)
	{
		sectiondao sd = new sectiondao();
		Messagedao md = new Messagedao();
		map.addAttribute("section",section);
		map.addAttribute("service",service);
		System.out.println("diqu:"+section+"  "+"fuwu: "+service);
		map.addAttribute("info", "暂无");
		map.addAttribute("message", sd.getSection(section).getMsg());
		map.addAttribute("description", sd.getSection(section).getDescription());
		//map.addAttribute("weather", md.getMessage(4).getWeather());
		map.addAttribute("weather", md.getMessageByID(section).get(0).getWeather());
		
		return "/information";	
	}
	//模拟数据
	@RequestMapping(value = "/datasimulate")
	public String getMessage(@RequestParam int[] num,
			                 @RequestParam String[] propotion,
			                 @RequestParam String time){
		//模拟输入
		Simulater simulater = new Simulater();
		simulater.getParm(num, propotion, time);
		return "/dataOK";
	}

}

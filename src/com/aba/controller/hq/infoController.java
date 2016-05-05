package com.aba.controller.hq;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aba.datasource.Simulater;

import dao.Messagedao;
import dao.sectiondao;


@Controller
@RequestMapping(value = "/JSPS")
public class infoController {
	@RequestMapping(value = "/service")
	public String choseSection(ModelMap map,@RequestParam String section){
		map.addAttribute("section",section);
		return "/choseService";
	}
	
	@RequestMapping(value = "/information")
	public String getMessage(ModelMap map,
			@RequestParam int section)
	{
		sectiondao sd = new sectiondao();
		Messagedao md = new Messagedao();
		Message m = md.getMessageByID(section).get(0);
		map.addAttribute("section",section);
		map.addAttribute("info", "����");
		map.addAttribute("message", sd.getSection(section).getMsg());
		map.addAttribute("description", sd.getSection(section).getDescription());
		map.addAttribute("weather", m.getWeather());
		map.addAttribute("tration", m.getTration());
		map.addAttribute("emerg", m.getEmergency());
		return "/information";	
	}
	@RequestMapping(value="/msgpush")
	public String setMessage(@RequestParam String weather, 
			                 @RequestParam String tration,
			                 @RequestParam String emergency,
			                 @RequestParam int sectionid)
	{
		System.out.println("controller>>>>>>>>>>>>>>>>"+emergency);
		Messagedao md = new Messagedao();
		Date time_data = new Date();
		md.saveMessage(weather, time_data, tration, emergency, sectionid);
		
		return "/setmsg";
	}
	
	@RequestMapping(value="/setsection")
	public String setSection(@RequestParam int sectionid, 
                             @RequestParam String msg,
                             @RequestParam String descrption)
	{
		sectiondao sd = new sectiondao();
		sd.saveSection(sectionid, msg, descrption);
		return "/setmsg";
	}
	//ģ�����
	@RequestMapping(value = "/datasimulate")
	public String getMessage(@RequestParam int[] num,
			                 @RequestParam String[] propotion,
			                 @RequestParam String time){
		//ģ������
		Simulater simulater = new Simulater();
		simulater.getParm(num, propotion, time);
		return "/dataOK";
	}

}

package com.aba.controller.hq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/JSPS",method = RequestMethod.GET)
public class infoController {
	
	@RequestMapping(value = "/service")
	public String choseSection(ModelMap map,@RequestParam String section){
		map.addAttribute("section",section);
		return "/choseService";
	}
	
	@RequestMapping(value = "/information")
	
	public String getMessage(ModelMap map,@RequestParam String service){
		map.addAttribute("section","null");
		map.addAttribute("service",service);
		map.addAttribute("info", "null");
		return "/information";
		
	}
	//模拟数据
	@RequestMapping(value = "/datasimulate")
	public String getMessage(@RequestParam int[] num,
			                 @RequestParam String[] propotion,
			                 @RequestParam String time){
		//模拟输入
		
		return "/dataOK";
		
	}

}

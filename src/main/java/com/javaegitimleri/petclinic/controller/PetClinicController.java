package com.javaegitimleri.petclinic.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javaegitimleri.petclinic.service.PetClinicService;

@Controller
public class PetClinicController {

	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(value={"/login.html"})
	public String login(ModelMap modelMap){
		

		return "login";
	}
	
	
	
	
	@RequestMapping(value={"/","/index.html"})
	public ModelAndView index(){
		
		ModelAndView mav =new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	
	
	@RequestMapping("/owners")
	public ModelAndView getOwners(){
		
		ModelAndView mvc=new ModelAndView();
		mvc.addObject("owners", petClinicService.findOwners());
		
		mvc.setViewName("ownerspage");
		
		return mvc;
	}
	
	@RequestMapping("/pcs")
	@ResponseBody
	public String welcome(){
		
		return "Spring Dünyasına Hoşgeldiniz!!!";
		
	}
	
}

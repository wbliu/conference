package com.lwb.conference.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lwb.conference.entity.JPATest;
import com.lwb.conference.service.HelloService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/index")
	public String helloMvc() {
		
		return "index";
	}
	
	@RequestMapping(value="/home/{rid}",method=RequestMethod.GET)
	public ModelAndView home(@PathVariable("rid") Integer rid,Model model){
		ModelAndView mav = new ModelAndView("home");
		System.out.println(rid);
		model.addAttribute(rid);
		return mav;
	}
	
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ModelAndView getById(@RequestParam long id,Model model){
		ModelAndView mav = new ModelAndView("index");
		JPATest obj = helloService.getById(JPATest.class, id);
		logger.info(obj.getName());
		model.addAttribute(obj.getName());
		return mav;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public ModelAndView save(@RequestParam String name ,RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("home");
		JPATest entity = new JPATest();
		entity.setName(name);
		helloService.save(entity);
		redirectAttributes.addFlashAttribute("message", "操作成功");
		return mav;
	}

}

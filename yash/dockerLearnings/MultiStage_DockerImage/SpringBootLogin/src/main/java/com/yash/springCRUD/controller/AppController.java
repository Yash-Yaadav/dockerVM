package com.yash.springCRUD.controller;

import java.util.List;

import com.yash.springCRUD.model.Student;
import com.yash.springCRUD.services.StudentServices;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private StudentServices service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStu = service.listAll();
		model.addAttribute("listStudent",listStu);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newStudentPage(Model model) {
		Student stu = new Student();
		model.addAttribute("student",stu);
		return "new_student";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST )
	public String saveStudent(@ModelAttribute("student") Student stu) {
		service.save(stu);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{sid}")
	public ModelAndView showEditStudentpage(@PathVariable (name="sid") int id) {
		ModelAndView mav=new ModelAndView("edit_student");
		Student stu=service.get(id); 
		mav.addObject("student",stu);
		return mav;
	}
	
	@RequestMapping("/delete/{sid}")
	public String deleteStudentpage(@PathVariable (name="sid") int id) {
		service.delete(id);
		return "redirect:/";
	}

	@RequestMapping("login")
	public String showLoginPage() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/";
	}
}

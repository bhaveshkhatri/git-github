	package org.cb.practice.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy***mm**dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
	
	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		
		String exceptionOccured = "Arithmatci_Exception";
		
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null pointer Exception");
		}
		else {
			if(exceptionOccured.equalsIgnoreCase("Arithmatci_Exception")) {
				throw new ArithmeticException("Arithmatic Exception!!!!!");
			}
		}
		
		ModelAndView mv = new ModelAndView("AdmissionForm");
		return mv;
	}
	
	
	@ModelAttribute
	public void addCommonModelObject(Model model) {
		
		model.addAttribute("msg", "HEllo World..!");
	}                              
	
	
	@RequestMapping(value="/submitAdmissionnForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student, BindingResult result) {
	
		if(result.hasErrors()) {
		ModelAndView mv = new ModelAndView("AdmissionForm");
				
		return mv;
		}
		
		ModelAndView mv = new ModelAndView("AdmissionSuccess");
		
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public ArrayList<Student> getStudentList() {
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		Student student1 = new Student();
		student1.setStudentName("chinna");
		
		Student student2 = new Student();
		student2.setStudentName("venkey");
		
		Student student3 = new Student();
		student3.setStudentName("padma");
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		return students;
	}
	
	

}

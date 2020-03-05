package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.bean.Employee;
import com.employee.dao.EmployeeDaoImpl;

@RestController

public class EmployeeSaveController {
	
	  @Autowired   
	  EmployeeDaoImpl dao;
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Employee  emp){    
        dao.save(emp);    
        return "Employee data  will be saved in Employee table";//will redirect to viewemp request mapping    
    }
		
	 @RequestMapping("/viewemp")    
	    public String viewemp(Model m){    
	        List<Employee > list=dao.getEmployees();    
	        m.addAttribute("list",list);  
	        return "list of employee"+list;    
	    }
	@RequestMapping(value = "/getEmployeeByID", method = RequestMethod.GET)
    public ModelAndView getEmployeeById(String empid, BindingResult result) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employees", dao.getEmployeeById(empid));
        return new ModelAndView("getEmployeebyID", model);
    }

}

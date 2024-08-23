package com.TaskMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TaskMaster.service.MyTasksListService;

@Controller
public class MyTasksListController {
	
	@Autowired
	private MyTasksListService service;
	
	@RequestMapping("/deleteMyTask/{id}")
	public String deleteMyTask(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_Tasks";
	}
}

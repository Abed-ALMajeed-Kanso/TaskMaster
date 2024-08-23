package com.TaskMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.TaskMaster.entity.Task;
import com.TaskMaster.entity.MyTasksList;
import com.TaskMaster.entity.Category;
import com.TaskMaster.service.TaskService;
import com.TaskMaster.service.CategoryService;
import com.TaskMaster.service.MyTasksListService; 

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
@Controller
public class TasksController {
	
	@Autowired
	private TaskService service;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MyTasksListService myTasksService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/Task_register")
	public String TaskRegister(Model model) {
	    List<Category> categories = categoryService.getAllCategories();
	    List<String> categoryNames = categories.stream().map(Category::getName).collect(Collectors.toList());
	    model.addAttribute("categoryNames", categoryNames);
	    return "TaskRegister";
	}

	@GetMapping("/available_Tasks")
	public ModelAndView getAllBook() {
		List<Task>list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("TaskList");
//		m.addObject("Task",list);
		return new ModelAndView("TasksList","Task",list);
	}
	
	@PostMapping("/save")
	public String addTask(@ModelAttribute Task t) {
		service.save(t);
		return "redirect:/available_Tasks";
	}
	@GetMapping("/my_Tasks")
	public String getMyBooks(Model model)
	{
		List<MyTasksList>list=myTasksService.getAllMyTasks();
		model.addAttribute("Task",list);
		return "myTasks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Task b=service.getTaskById(id);
		MyTasksList mb = new MyTasksList(b.getId(), b.getName(), b.getDescription(), b.getStartDate(), b.getEndDate(), b.getCategory());
		myTasksService.saveMyTasks(mb);
		return "redirect:/my_Tasks";
	}
	
	@RequestMapping("/editTask/{id}")
	public String editTask(@PathVariable("id") int id,Model model) {
		Task t=service.getTaskById(id);
		model.addAttribute("Task",t);
		List<Category> categories = categoryService.getAllCategories();
	    List<String> categoryNames = categories.stream().map(Category::getName).collect(Collectors.toList());
	    model.addAttribute("categoryNames", categoryNames);
		return "TaskEdit";
	}
	
	@RequestMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_Tasks";
	}
	
}

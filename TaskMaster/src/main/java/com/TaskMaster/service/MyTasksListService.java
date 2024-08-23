package com.TaskMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskMaster.entity.MyTasksList;
import com.TaskMaster.repository.MyTasksRepository;

@Service
public class MyTasksListService {
	
	@Autowired
	private MyTasksRepository myTask;
	
	public void saveMyTasks(MyTasksList Task) {
		myTask.save(Task);
	}
	
	public List<MyTasksList> getAllMyTasks(){
		return myTask.findAll();
	}
	
	public void deleteById(int id) {
		myTask.deleteById(id);
	}
}

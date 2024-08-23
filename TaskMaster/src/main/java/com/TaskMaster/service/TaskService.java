package com.TaskMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskMaster.entity.Task;
import com.TaskMaster.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository TRepo;
	
	public void save(Task b) {
		TRepo.save(b);
	}
	
	public List<Task> getAllBook(){
		return TRepo.findAll();
	}
	
	public Task getTaskById(int id) {
		return TRepo.findById(id).get();
	}
	public void deleteById(int id) {
		TRepo.deleteById(id);
	}
}


 
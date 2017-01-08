package com.app.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacodegeeks.examples.realtimeapp.part1.services.RequestMapping;
import com.javacodegeeks.examples.realtimeapp.part1.services.RestController;
import com.javacodegeeks.examples.realtimeapp.part1.services.TaskService;

@ManagedBean(name = "taskController", eager=true)
@RequestScoped
@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.GET)
	@RequestMapping("/task")
	public  List<String> gettask(){
		taskService.getTasks();
	}
	public void startTasks(ActionEvent event) throws InterruptedException {
		this.taskService.startIdleTasks();
	}
	
}

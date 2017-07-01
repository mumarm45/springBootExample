package com.tasks.controllers;

import com.tasks.datalayer.TaskRepository;
import com.tasks.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by mumarm45 on 29/06/2017.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Task> getAllTasks(){
        return  taskRepository.findAll();
    }

    @RequestMapping()
    public Task save(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<Task> getById(@PathVariable("id") String id){

        Task task = taskRepository.findOne(id);
        return  (task == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :  new ResponseEntity<Task>(taskRepository.findOne(id),HttpStatus.OK);

    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id){

         taskRepository.delete(id);

            return new ResponseEntity(HttpStatus.OK);

    }
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody Task task){
        taskRepository.updateTitle(id,task);
        return new ResponseEntity(HttpStatus.OK);
    }
}

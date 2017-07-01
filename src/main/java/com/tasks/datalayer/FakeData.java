package com.tasks.datalayer;

import com.tasks.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mumarm45 on 29/06/2017.
 */
@Repository
public class FakeData {


    private static Map<Integer,Task> tasks;

    static  {
        tasks = new  HashMap<Integer,Task>(){
            {
                put(1,new Task("1","New",false));
                put(2,new Task("2","New2",false));
                put(3,new Task("3","New1",false));
            }
        };
    }


    public Collection<Task> getAllTasks(){
      return  this.tasks.values();
    }
    public Task getById(int id){
        return  this.tasks.get(id);
    }
}

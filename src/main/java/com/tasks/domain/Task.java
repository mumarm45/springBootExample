package com.tasks.domain;

/**
 * Created by mumarm45 on 29/06/2017.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "task")
public class Task {

   /*
    @Indexed(unique = true)
    @NotNull
    */
   private  String title;
    private boolean isDone;

    @Id private  String _id ;



    public  Task (){

    }

    public Task(String id, String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
        this._id = id;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + _id + '\'' +
                "title='" + title + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}

package com.tasks.datalayer;

import com.mongodb.WriteResult;
import com.tasks.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by mumarm45 on 01/07/2017.
 */
public class TaskRepositoryImpl implements TaskRepositoryCustom {

    @Autowired
   private MongoTemplate mongoTemplate;
    @Override

    public int updateTitle(String id,Task task) {
        Query  query = new Query(Criteria.where("_id").is(task.get_id()));
        Update update = new Update();
        update.set("title",task.getTitle()) ;
        update.set("isDone",task.getIsDone()) ;
        WriteResult result = mongoTemplate.updateFirst(query,update,Task.class);

        if(result!=null)
            return result.getN();
        else
            return 0;
    }
}

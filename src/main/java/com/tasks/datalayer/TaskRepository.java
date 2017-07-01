package com.tasks.datalayer;

import com.tasks.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Created by mumarm45 on 30/06/2017.
 */

public interface TaskRepository extends MongoRepository<Task, String>,TaskRepositoryCustom {
   // Page<Task> findAll(Pageable pageable);



}


package com.swacorp.crew.microservices.css.service;

import com.swacorp.crew.microservices.css.domain.ChangeLog;

import java.util.List;

/**
 * Created by POD Norris on 5/11/16.
 */
public interface ChangeLogService {
   
    ChangeLog create(ChangeLog changeLog);

    List<ChangeLog> findAll();

    ChangeLog findById(long l);

    ChangeLog update(ChangeLog changeLogToUpdate);

    void delete(ChangeLog changeLogToDelete);
}

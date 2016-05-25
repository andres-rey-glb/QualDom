package com.swacorp.crew.microservices.css.service;

import com.swacorp.crew.microservices.css.domain.ChangeLog;
import com.swacorp.crew.microservices.css.repository.ChangeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorge.juarez on 5/11/16.
 */
@Service
public class ChangeLogServiceImpl implements ChangeLogService{
    @Autowired
    ChangeLogRepository repository;

    /**
     * Create a changeLog entry into GenFire region
     * @param ChangeLog
     * @return ChangeLog Object
     */
    @Override
    public ChangeLog create(ChangeLog ChangeLog) {
        return repository.save(ChangeLog);
    }

    /**
     * Return a list of all changeLogs
     * @return List of all ChangeLog entries
     */
    @Override
    public List<ChangeLog> findAll() {
        return (List)repository.findAll();
    }

    /**
     * Finds an specific changeLog based on ID
     * @param ChangeLogId
     * @return ChangeLog Object
     */
    @Override
    public ChangeLog findById(long ChangeLogId){
        ChangeLog find=  repository.findOne(ChangeLogId);
        return find;
    }

    /**
     * Updates a ChangeLog entry based on a 
     * ChangeLog input Object    
     * @param ChangeLogToUpdate
     * @return updated ChangeLog Object
     */
    @Override
    public ChangeLog update(ChangeLog ChangeLogToUpdate) {
        return repository.save(ChangeLogToUpdate);
    }

    /**
     * Removes an specific changeLog entry based on 
     * a changeLog Object
     * @param ChangeLogToDelete 
     */
    @Override
    public void delete(ChangeLog ChangeLogToDelete) {
        repository.delete(ChangeLogToDelete);
    }
}

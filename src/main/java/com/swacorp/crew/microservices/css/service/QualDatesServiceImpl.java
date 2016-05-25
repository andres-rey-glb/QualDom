package com.swacorp.crew.microservices.css.service;

import com.swacorp.crew.microservices.css.domain.QualDates;
import com.swacorp.crew.microservices.css.repository.QualDatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorge.juarez on 5/11/16.
 */
@Service
public class QualDatesServiceImpl implements QualDatesService{
    @Autowired
    QualDatesRepository repository;

    /**
     * Create a changeLog entry into GenFire region
     * @param ChangeLog
     * @return ChangeLog Object
     */
    @Override
    public QualDates create(QualDates qualDate) {
        return repository.save(qualDate);
    }

    /**
     * Return a list of all changeLogs
     * @return List of all ChangeLog entries
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public List<QualDates> findAll() {
        return (List)repository.findAll();
    }

    /**
     * Finds an specific changeLog based on ID
     * @param ChangeLogId
     * @return ChangeLog Object
     */
    @Override
    public QualDates findById(int qualDateId){
    	QualDates find=  repository.findOne(qualDateId);
        return find;
    }

    /**
     * Updates a ChangeLog entry based on a 
     * ChangeLog input Object    
     * @param ChangeLogToUpdate
     * @return updated ChangeLog Object
     */
    @Override
    public QualDates update(QualDates qualDateToUpdate) {
        return repository.save(qualDateToUpdate);
    }

    /**
     * Removes an specific changeLog entry based on 
     * a changeLog Object
     * @param ChangeLogToDelete 
     */
    @Override
    public void delete(QualDates qualDateToDelete) {
        repository.delete(qualDateToDelete);
    }
}

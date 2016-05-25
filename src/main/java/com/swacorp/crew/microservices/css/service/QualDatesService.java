package com.swacorp.crew.microservices.css.service;

import com.swacorp.crew.microservices.css.domain.QualDates;

import java.util.List;

/**
 * Created by POD Norris on 5/11/16.
 */
public interface QualDatesService {
   
	QualDates create(QualDates qualDate);

    List<QualDates> findAll();

    QualDates findById(int l);

    QualDates update(QualDates qualDateToUpdate);

    void delete(QualDates qualDateToDelete);
}

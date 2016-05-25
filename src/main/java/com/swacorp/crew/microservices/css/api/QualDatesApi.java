package com.swacorp.crew.microservices.css.api;

import com.swacorp.crew.microservices.css.domain.QualDates;
import com.swacorp.crew.microservices.css.exception.BadRequestException;
import com.swacorp.crew.microservices.css.exception.NotFoundException;
import com.swacorp.crew.microservices.css.service.QualDatesService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by POD Norris on 5/9/16.
 */
@RestController
@RequestMapping("/qualification")
public class QualDatesApi {

    @Autowired
    QualDatesService service;

    /**
     *
     * @return @throws com.swacorp.crew.microservices.css.exception.NotFoundException
     */
    @RequestMapping(value = "/qualdates", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<QualDates> getQualDates() throws NotFoundException {
        List<QualDates> qualDates = service.findAll();
        if (!qualDates.isEmpty()) {
            return qualDates;
        } else {
            throw new NotFoundException();
        }
    }

    /**
     *
     * @param changeLogId
     * @return
     * @throws com.swacorp.crew.microservices.css.exception.BadRequestException
     * @throws com.swacorp.crew.microservices.css.exception.NotFoundException
     */
    @RequestMapping(value = "/qualdates/{qualDatesId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public QualDates getQualDate(@PathVariable Integer qualDatesId) throws BadRequestException, NotFoundException {
    	QualDates qualDate = null;

        try {
            qualDate = service.findById(qualDatesId);
        } catch (NumberFormatException e) {
            throw new BadRequestException();
        }

        if (qualDate != null) {
            return qualDate;
        } else {
            throw new NotFoundException();
        }
    }

    /**
     *
     * @param inputQualDate
     * @return
     */
    @RequestMapping(value = "/qualdates",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public QualDates save(@RequestBody QualDates inputQualDate) {

    	QualDates createdQualDate = null;
        createdQualDate = service.create(inputQualDate);
        return createdQualDate;

    }

    /**
     *
     * @param qualDateId
     * @throws com.swacorp.crew.microservices.css.exception.NotFoundException
     * @throws com.swacorp.crew.microservices.css.exception.BadRequestException
     */
    @RequestMapping(value = "/qualdates/{qualDateId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer qualDateId) throws NotFoundException, BadRequestException {

        QualDates qualDate = null;
        try {
            qualDate = service.findById(qualDateId);
        } catch (NumberFormatException e) {
            throw new BadRequestException();
        } 
        
        if (qualDate != null) {
            service.delete(qualDate);
        } else {
            throw new NotFoundException();
        }
    }

    /**
     *
     * @param qualDateId
     * @param inQualDate
     * @return
     * @throws com.swacorp.crew.microservices.css.exception.NotFoundException
     * @throws com.swacorp.crew.microservices.css.exception.BadRequestException
     */
    @RequestMapping(value = "/qualdates/{qualDateId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public QualDates update(@PathVariable Integer qualDateId, @RequestBody QualDates inQualDate) throws NotFoundException, BadRequestException {

    	QualDates qualDate = null;
        try {
            qualDate = service.findById(qualDateId);
        } catch (NumberFormatException e) {
            throw new NotFoundException();
        } 

        if (qualDate != null && Objects.equals(qualDate.getQualDateId(), inQualDate.getQualDateId())) {
            qualDate = service.update(inQualDate);
        } else {
            throw new BadRequestException();
        }
        return qualDate;
    }

}

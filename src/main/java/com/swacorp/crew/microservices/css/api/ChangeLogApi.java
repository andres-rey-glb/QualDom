package com.swacorp.crew.microservices.css.api;

import com.swacorp.crew.microservices.css.domain.ChangeLog;
import com.swacorp.crew.microservices.css.exception.BadRequestException;
import com.swacorp.crew.microservices.css.exception.NotFoundException;
import com.swacorp.crew.microservices.css.service.ChangeLogService;
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
@RequestMapping("/changelog")
public class ChangeLogApi {

    @Autowired
    ChangeLogService service;

    /**
     *
     * @return @throws com.swacorp.crew.microservices.css.exception.NotFoundException
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ChangeLog> getChangeLogs() throws NotFoundException {
        List<ChangeLog> chageLogs = service.findAll();
        if (!chageLogs.isEmpty()) {
            return chageLogs;
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
    @RequestMapping(value = "/{changeLogId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ChangeLog getChangeLog(@PathVariable Long changeLogId) throws BadRequestException, NotFoundException {
        ChangeLog chageLog = null;

        try {
            chageLog = service.findById(changeLogId);
        } catch (NumberFormatException e) {
            throw new BadRequestException();
        }

        if (chageLog != null) {
            return chageLog;
        } else {
            throw new NotFoundException();
        }
    }

    /**
     *
     * @param inputchangeLog
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ChangeLog save(@RequestBody ChangeLog inputchangeLog) {

        ChangeLog createdChageLog = null;
        createdChageLog = service.create(inputchangeLog);
        return createdChageLog;

    }

    /**
     *
     * @param changeLogId
     * @throws com.swacorp.crew.microservices.css.exception.NotFoundException
     * @throws com.swacorp.crew.microservices.css.exception.BadRequestException
     */
    @RequestMapping(value = "/{changeLogId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long changeLogId) throws NotFoundException, BadRequestException {

        ChangeLog changeLog = null;
        try {
            changeLog = service.findById(changeLogId);
        } catch (NumberFormatException e) {
            throw new BadRequestException();
        } 
        
        if (changeLog != null) {
            service.delete(changeLog);
        } else {
            throw new NotFoundException();
        }
    }

    /**
     *
     * @param changeLogId
     * @param inChangeLog
     * @return
     * @throws com.swacorp.crew.microservices.css.exception.NotFoundException
     * @throws com.swacorp.crew.microservices.css.exception.BadRequestException
     */
    @RequestMapping(value = "/{changeLogId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ChangeLog update(@PathVariable Long changeLogId, @RequestBody ChangeLog inChangeLog) throws NotFoundException, BadRequestException {

        ChangeLog changeLog = null;
        try {
            changeLog = service.findById(changeLogId);
        } catch (NumberFormatException e) {
            throw new NotFoundException();
        } 

        if (changeLog != null && Objects.equals(changeLog.getChangeLogID(), inChangeLog.getChangeLogID())) {
            changeLog = service.update(inChangeLog);
        } else {
            throw new BadRequestException();
        }
        return changeLog;
    }

}

package com.swacorp.crew.microservices.css.repository;

import com.swacorp.crew.microservices.css.domain.ChangeLog;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface to expose CrudRepository methods
 * Created by POD Norris on 5/9/16.
 */
public interface ChangeLogRepository extends CrudRepository<ChangeLog, Long>{

}

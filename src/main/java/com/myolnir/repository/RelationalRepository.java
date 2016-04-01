package com.myolnir.repository;

import com.myolnir.model.RelationalObject;
import org.springframework.data.repository.CrudRepository;

public interface RelationalRepository extends CrudRepository<RelationalObject, Long> {
}

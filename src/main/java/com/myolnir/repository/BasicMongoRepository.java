package com.myolnir.repository;

import com.myolnir.model.ObjectToSave;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Basic mongo repository, extends to spring mongo repository that provides it all of basic methods. For any
 * other more complex method you must implement here and create an implementation for this repository.
 */
@Repository
public interface BasicMongoRepository extends MongoRepository<ObjectToSave, String> {
}

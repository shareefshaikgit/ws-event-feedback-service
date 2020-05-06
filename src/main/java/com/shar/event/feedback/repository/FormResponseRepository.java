package com.shar.event.feedback.repository;

import com.shar.event.feedback.entity.FormResponse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormResponseRepository extends ReactiveMongoRepository<FormResponse, String> {
}

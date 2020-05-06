package com.shar.event.feedback.repository;

import com.shar.event.feedback.entity.Form;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends ReactiveMongoRepository<Form, String> {}

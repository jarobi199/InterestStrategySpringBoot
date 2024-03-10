package io.interest.repository;

import io.interest.model.Interest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends MongoRepository<Interest, String> {
    public Interest findByType(String type);
}
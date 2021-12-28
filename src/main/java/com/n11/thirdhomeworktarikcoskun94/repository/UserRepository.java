package com.n11.thirdhomeworktarikcoskun94.repository;

import com.n11.thirdhomeworktarikcoskun94.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

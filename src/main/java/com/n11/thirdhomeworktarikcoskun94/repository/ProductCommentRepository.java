package com.n11.thirdhomeworktarikcoskun94.repository;

import com.n11.thirdhomeworktarikcoskun94.entity.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends MongoRepository<ProductComment, String> {

    void deleteByUserId(String userId);
}

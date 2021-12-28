package com.n11.thirdhomeworktarikcoskun94.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "product_comments")
public class ProductComment {

    @Id
    private String id;
    private String text;
    private Date creationDate;
    private String productId;
    private String userId;
}

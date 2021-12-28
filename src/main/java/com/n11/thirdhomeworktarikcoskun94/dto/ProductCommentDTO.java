package com.n11.thirdhomeworktarikcoskun94.dto;

import com.n11.thirdhomeworktarikcoskun94.entity.ProductComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCommentDTO {

    private String commentId;
    private String commentText;
    private Date commentCreationDate;
    private String productId;
    private String userId;

    public static ProductCommentDTO convertProductCommentToProductCommentDTO(ProductComment productComment) {

        return ProductCommentDTO.builder()
                .commentId(productComment.getId())
                .commentText(productComment.getText())
                .commentCreationDate(productComment.getCreationDate())
                .productId(productComment.getProductId())
                .userId(productComment.getUserId())
                .build();
    }

    public static ProductComment convertProductCommentDTOToProductComment(ProductCommentDTO productCommentDTO) {

        return ProductComment.builder()
                .text(productCommentDTO.getCommentText())
                .creationDate(Calendar.getInstance().getTime())
                .productId(productCommentDTO.getProductId())
                .userId(productCommentDTO.getUserId())
                .build();
    }
}

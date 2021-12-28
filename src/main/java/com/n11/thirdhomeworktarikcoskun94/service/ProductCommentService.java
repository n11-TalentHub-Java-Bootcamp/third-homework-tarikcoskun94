package com.n11.thirdhomeworktarikcoskun94.service;

import com.n11.thirdhomeworktarikcoskun94.dto.ProductCommentDTO;
import com.n11.thirdhomeworktarikcoskun94.entity.ProductComment;
import com.n11.thirdhomeworktarikcoskun94.exception.ProductCommentNotFoundException;
import com.n11.thirdhomeworktarikcoskun94.exception.UserNotFoundException;
import com.n11.thirdhomeworktarikcoskun94.repository.ProductCommentRepository;
import com.n11.thirdhomeworktarikcoskun94.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductCommentService {

    private final ProductCommentRepository productCommentRepository;
    private final UserRepository userRepository;

    public List<ProductCommentDTO> findAllProductComments() {

        // This DTO list is for response.
        List<ProductCommentDTO> productCommentDTOList = new ArrayList<>();
        List<ProductComment> productCommentList = productCommentRepository.findAll();

        for (ProductComment productComment : productCommentList) {
            productCommentDTOList.add(ProductCommentDTO.convertProductCommentToProductCommentDTO(productComment));
        }

        return productCommentDTOList;
    }

    public ProductCommentDTO findProductCommentById(String id) {

        ProductComment productComment = productCommentRepository.findById(id).orElseThrow(() -> new ProductCommentNotFoundException("Product comment is not found by id: " + id));

        return ProductCommentDTO.convertProductCommentToProductCommentDTO(productComment);
    }

    public ProductCommentDTO saveProductComment(ProductCommentDTO productCommentDTO) {

        if (!userRepository.existsById(productCommentDTO.getUserId())) {
            throw new UserNotFoundException("User is not found by id: " + productCommentDTO.getUserId());
        }

        ProductComment requestProductComment = ProductCommentDTO.convertProductCommentDTOToProductComment(productCommentDTO);
        ProductComment responseProductComment = productCommentRepository.save(requestProductComment);

        return ProductCommentDTO.convertProductCommentToProductCommentDTO(responseProductComment);
    }

    public void deleteProductCommentById(String id) {

        if (!productCommentRepository.existsById(id)) {
            throw new ProductCommentNotFoundException("Product comment is not found by id: " + id);
        }

        productCommentRepository.deleteById(id);
    }

    public void deleteProductCommentByUserId(String userId) {

        productCommentRepository.deleteByUserId(userId);
    }

    public void saveProductComments(List<ProductComment> productComments) {

        productCommentRepository.saveAll(productComments);
    }

    public void deleteAllProductComments() {

        productCommentRepository.deleteAll();
    }
}

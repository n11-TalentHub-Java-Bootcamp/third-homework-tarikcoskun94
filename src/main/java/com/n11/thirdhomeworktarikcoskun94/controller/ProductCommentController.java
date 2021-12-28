package com.n11.thirdhomeworktarikcoskun94.controller;

import com.n11.thirdhomeworktarikcoskun94.dto.ProductCommentDTO;
import com.n11.thirdhomeworktarikcoskun94.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "product-comments")
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @GetMapping
    public ResponseEntity<List<ProductCommentDTO>> findAllProductComments() {

        return ResponseEntity.ok(productCommentService.findAllProductComments());
    }

    @GetMapping(value = "/with-id/{id}")
    public ResponseEntity<ProductCommentDTO> findProductCommentById(@PathVariable String id) {

        return ResponseEntity.ok(productCommentService.findProductCommentById(id));
    }

    @PostMapping
    public ResponseEntity<ProductCommentDTO> saveProductComment(@RequestBody ProductCommentDTO productCommentDTO) {

        return new ResponseEntity<>(productCommentService.saveProductComment(productCommentDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/with-id/{id}")
    public ResponseEntity<String> deleteProductCommentById(@PathVariable String id) {

        productCommentService.deleteProductCommentById(id);
        String responseMessage = "Product comment has been deleted by id: " + id;

        return ResponseEntity.ok(responseMessage);
    }
}

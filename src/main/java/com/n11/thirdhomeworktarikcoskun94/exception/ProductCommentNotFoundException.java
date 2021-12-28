package com.n11.thirdhomeworktarikcoskun94.exception;

import java.util.List;

public class ProductCommentNotFoundException extends EntityNotFoundException {

    public ProductCommentNotFoundException() {
    }

    public ProductCommentNotFoundException(String... errorMessages) {
        super(errorMessages);
    }

    public ProductCommentNotFoundException(List<String> errorMessages) {
        super(errorMessages);
    }
}

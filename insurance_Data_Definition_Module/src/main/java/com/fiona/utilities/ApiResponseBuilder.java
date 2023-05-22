package com.fiona.utilities;

import com.fiona.Classes.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ApiResponseBuilder {
    public static <T> ResponseEntity<APIResponse> buildResponseEntity(HttpStatus status, T body, String message, String path) {
        APIResponse<T> responseDTO = APIResponse.<T>builder()
                .body(body)
                .timeStamp(LocalDateTime.now())
                .message(message)
                .path(path)
                .build();
        return new ResponseEntity<>(responseDTO, status);
    }
}

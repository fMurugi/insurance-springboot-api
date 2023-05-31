package com.fiona.utilities;

import com.fiona.Classes.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

//! todo add this file to a folder with the name that states what the utility is supposed to do .
//! todo  Also add the comments on what the class is supposed to do and what is its output.
/**
 * Utility class for building API response entities.
 */

public class ApiResponseBuilder {
    /**
     * Builds a ResponseEntity containing the API response.
     *
     * @param status  the HTTP status code of the response
     * @param body    the body of the response
     * @param path    the path of the API endpoint that generated the response
     * @param <T>     the type of the response body
     * @return the ResponseEntity containing the API response
     */
    public static <T> ResponseEntity<APIResponse> buildResponseEntity(HttpStatus status, T body,  String path) {
        APIResponse<T> responseDTO= APIResponse.<T>builder()
                .body(body)
                .timeStamp(LocalDateTime.now())
                .path(path)
                .build();
        return new ResponseEntity<>(responseDTO, status);
    }
}

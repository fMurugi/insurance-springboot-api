package com.fiona.ServiceProviders.Controller;

import com.fiona.Classes.APIResponse;
import com.fiona.ServiceProviders.DTO.ServiceProviderDTO;
import com.fiona.ServiceProviders.Service.ServiceProviderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ServiceProviders")
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderController {
    private String SUCCESS ="success";
    @Autowired
    private ServiceProviderService serviceProviderService;
    private <T> ResponseEntity<APIResponse> buildResponseEntity(HttpStatus status, T body) {
        APIResponse<T> responseDTO = APIResponse.<T>builder()
//                .status(SUCCESS)
                .body(body)
                .build();
        return new ResponseEntity<>(responseDTO, status);
    }


    @PostMapping("/create")
    public ResponseEntity<APIResponse> createNewServiceProvider(@RequestBody @Valid ServiceProviderDTO serviceProviderDTORequest){
        ServiceProviderDTO serviceProviderDTO = serviceProviderService.createNewServiceProvider(serviceProviderDTORequest);
        return buildResponseEntity(HttpStatus.CREATED,serviceProviderDTO);
    }
}

package com.fiona.HospitalLevels.controller;

import com.fiona.Classes.APIResponse;
import com.fiona.HospitalLevels.payload.HospitalLevelDTO;
import com.fiona.HospitalLevels.service.HospitalLevelService;
import com.fiona.ServiceProviders.Payload.ServiceProviderDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fiona.utilities.ApiResponseBuilder.buildResponseEntity;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hospital_levels")
public class HospitalLevelController {
    private final HospitalLevelService hospitalLevelService;

    @PostMapping("/create_hospital_level")
    public ResponseEntity<APIResponse> createNewHospitalLevel(@RequestBody HospitalLevelDTO payload, HttpServletRequest request){
        List<HospitalLevelDTO> hospitalLevelDTO = hospitalLevelService.createNewHospitalLevel(payload);
        return buildResponseEntity(HttpStatus.CREATED,hospitalLevelDTO,request.getRequestURI());
    }

    @GetMapping("/get_all_Hospital_levels")
    public ResponseEntity<APIResponse> getAllHospitalLevels(HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,hospitalLevelService.getAllHospitalLevels(),request.getRequestURI());
    }

    @PostMapping("/update_single_Hospital_level")
    public ResponseEntity<APIResponse> updateHospitalLevel(@RequestBody HospitalLevelDTO payload,HttpServletRequest request){
        List<HospitalLevelDTO> hospitalLevelDTO= hospitalLevelService.updateHospitalLevels(payload);
        return  buildResponseEntity(HttpStatus.ACCEPTED,hospitalLevelDTO,request.getRequestURI());
    }
    @PostMapping("/delete_single_hospital_level")
    public ResponseEntity<APIResponse> deleteHospitalLevel(@RequestBody HospitalLevelDTO payload,HttpServletRequest request){
        return  buildResponseEntity(HttpStatus.OK,hospitalLevelService.deleteHospitalLevel(payload),request.getRequestURI());
    }


}

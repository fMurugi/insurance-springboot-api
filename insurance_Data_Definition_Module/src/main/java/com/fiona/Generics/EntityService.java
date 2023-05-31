package com.fiona.Generics;

import com.fiona.Exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;
@AllArgsConstructor

public class EntityService <T>{
    private final JpaRepository<T, UUID> repository;


    public T findEntityById(UUID id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Resource Not found"));

    }

}

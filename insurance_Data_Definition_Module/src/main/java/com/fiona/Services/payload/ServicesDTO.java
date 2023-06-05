package com.fiona.Services.payload;

import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDTO {
    private UUID serviceId;
    private String name;
    private UUID serviceProviderId;
}

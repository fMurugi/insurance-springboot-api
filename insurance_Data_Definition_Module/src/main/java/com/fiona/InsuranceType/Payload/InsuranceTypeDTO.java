package com.fiona.InsuranceType.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//        ! todo  unused imports.-done
//! todo  Create a folder called payloads, then add variables and different constructors to them, so as to improve the flexibility of the class. -dont understand this? should it not be the DTO
//! todo  WHY do we need @NoArgsConstructor ??? - done
import java.util.UUID;

@Data
@AllArgsConstructor
public class InsuranceTypeDTO {
    private UUID insuranceTypeId;
    private String name;
    private String description;
    private int offset;
    private int pageSize;
}

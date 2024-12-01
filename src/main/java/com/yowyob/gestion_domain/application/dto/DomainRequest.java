package com.yowyob.gestion_domain.application.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DomainRequest {
    private String name;
    private String idOwner;
}

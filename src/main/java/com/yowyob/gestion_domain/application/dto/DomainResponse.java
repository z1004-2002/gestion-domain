package com.yowyob.gestion_domain.application.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DomainResponse {
    private String id;
    private String name;
    private String apiKey;
    private String idOwner;
}

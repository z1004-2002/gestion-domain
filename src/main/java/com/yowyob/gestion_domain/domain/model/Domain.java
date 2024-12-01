package com.yowyob.gestion_domain.domain.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("domains")
@Builder
public class Domain {
    @PrimaryKey
    private String id;
    private String name;
    private String apiKey;
    private String idOwner;
}

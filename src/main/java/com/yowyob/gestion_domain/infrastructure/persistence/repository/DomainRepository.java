package com.yowyob.gestion_domain.infrastructure.persistence.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.yowyob.gestion_domain.domain.model.Domain;

public interface DomainRepository extends CassandraRepository<Domain,String>{
    
}

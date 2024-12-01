package com.yowyob.gestion_domain.application.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yowyob.gestion_domain.application.dto.DomainRequest;
import com.yowyob.gestion_domain.application.dto.DomainResponse;
import com.yowyob.gestion_domain.domain.model.Domain;
import com.yowyob.gestion_domain.infrastructure.persistence.repository.DomainRepository;

@Service
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    public DomainResponse createDomain(DomainRequest request) {
        Domain domain = Domain.builder()
        .id(UUID.randomUUID().toString())
        .name(request.getName())
        .idOwner(request.getIdOwner())
        .apiKey(this.generateDomainKey())
        .build();
        return domainToDto(domainRepository.save(domain));
    }
    public List<DomainResponse> getAllDomain(){
        return domainRepository.findAll().stream().map(this::domainToDto).toList();
    }
    public DomainResponse getDomainById(UUID id){
        return domainRepository.findById(id.toString()).map(this::domainToDto).orElse(null);
    }

    public DomainResponse updateDomain(UUID id, DomainRequest request){
        Domain domain = domainRepository.findById(id.toString()).orElse(null);
        if(domain!= null){
            domain.setName(request.getName());
            domain.setIdOwner(request.getIdOwner());
            return domainToDto(domainRepository.save(domain));
        }
        return null;
    }

    public void deleteDomain(UUID id){
        domainRepository.deleteById(id.toString());
    }

    private DomainResponse domainToDto(Domain domain){
        return DomainResponse.builder()
        .name(domain.getName())
        .idOwner(domain.getIdOwner())
        .apiKey(domain.getApiKey())
        .id(domain.getId())
        .build();
    }

    private String generateDomainKey(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz"
                + "0123456789"
                + "!@#$%&*()_+{}|:<>?=";

        StringBuilder s = new StringBuilder(50);
        for (int i = 0; i < 16; i++) {
            int index = (int) (str.length() * Math.random());
            s.append(str.charAt(index));
        }
        String privateKey = String.valueOf(s);
        return privateKey;
    }
}

package com.yowyob.gestion_domain.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yowyob.gestion_domain.application.dto.DomainRequest;
import com.yowyob.gestion_domain.application.dto.DomainResponse;
import com.yowyob.gestion_domain.application.services.DomainService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1/domain")
// @Tag(name = "Ressource", description = "Endpoints de gestiond des ressources")
@CrossOrigin("*")
@Tag(name = "domain")
public class DomainController {
    @Autowired
    private DomainService domainService;

    @Operation(summary = "Créer un domain", description = "Ce endpoint permet de créer un domain")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public DomainResponse postMethodName(@RequestBody DomainRequest request) {
        return domainService.createDomain(request);
    }

    @Operation(summary = "Lister tous les domainnes", description = "")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<DomainResponse> getAllDomain() {
        return domainService.getAllDomain();
    }

    @Operation(summary = "Obtenir un domain", description = "")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public DomainResponse getDomainById(@PathVariable UUID id) {
        return domainService.getDomainById(id);
    }

    @Operation(summary = "Mettre à jour un domain", description = "")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    public DomainResponse updateDomain(@PathVariable UUID id, @RequestBody DomainRequest request) {
        return domainService.updateDomain(id, request);
    }

    @Operation(summary = "Supprimer un domain", description = "")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete/{id}")
    public void deleteDomain(@PathVariable UUID id) {
        domainService.deleteDomain(id);
    }
}

package com.BookMyPooja.PoojaServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "provider_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderService {

    @EmbeddedId
    private ProviderServiceId id;

    @ManyToOne
    @MapsId("providerId")
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Service service;

    private Boolean deleted = false;
}

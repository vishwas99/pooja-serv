package com.BookMyPooja.PoojaServices.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderServiceId implements Serializable {

    private Long providerId;
    private Long serviceId;
}

package com.BookMyPooja.PoojaServices.service;

import com.BookMyPooja.PoojaServices.dto.ProviderDto;
import com.BookMyPooja.PoojaServices.entity.Provider;
import com.BookMyPooja.PoojaServices.inf.SearchResult;
import com.BookMyPooja.PoojaServices.repository.FullTextSearchRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SearchService {
    @Autowired
    private FullTextSearchRepository fullTextSearchRepository;

    @Transactional(readOnly = true)
    public List<SearchResult> searchByKey(String key) {
        /**
         * when user queries for service name, the list of service providers for the given service is returned
         * sequence
         * 1. fetch all matching services by key or description
         * 2. fetch all providers from provider_service mapping
         */
        List<com.BookMyPooja.PoojaServices.entity.Service> searchResults = this.fullTextSearchRepository.searchByKey(key);
        List<SearchResult> results = new ArrayList<>();
        Set<Provider> matchedProviders = new HashSet<>();
        for (var result : searchResults) {
            matchedProviders.addAll(result.getProviders());
        }
        for (var provider : matchedProviders) {
            results.add(new ProviderDto("Name: " + provider.getUser().getUsername() + ", Services: " + provider.getServices()));
        }
        return results;
    }
}

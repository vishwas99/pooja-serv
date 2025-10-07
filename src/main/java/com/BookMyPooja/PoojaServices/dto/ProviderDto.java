package com.BookMyPooja.PoojaServices.dto;

import com.BookMyPooja.PoojaServices.inf.SearchResult;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class ProviderDto implements SearchResult  {
    private String providerInfo;

    @Override
    public String getSearchValue() {
        return this.providerInfo;
    }
}

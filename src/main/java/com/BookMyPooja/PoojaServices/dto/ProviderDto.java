package com.BookMyPooja.PoojaServices.dto;

import com.BookMyPooja.PoojaServices.inf.SearchResult;
import lombok.Setter;

@Setter
public class ProviderDto implements SearchResult  {
    private String providerName;

    @Override
    public String getSearchValue() {
        return this.providerName;
    }
}

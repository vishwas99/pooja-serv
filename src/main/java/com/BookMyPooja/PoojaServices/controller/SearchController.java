package com.BookMyPooja.PoojaServices.controller;

import com.BookMyPooja.PoojaServices.inf.SearchResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    public List<SearchResult> getSearchResults(String searchKey) {
       return null;
    }
}

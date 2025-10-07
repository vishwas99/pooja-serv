package com.BookMyPooja.PoojaServices.controller;

import com.BookMyPooja.PoojaServices.inf.SearchResult;
import com.BookMyPooja.PoojaServices.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping
    public List<SearchResult> getSearchResults(@RequestParam String key) {
       return this.searchService.searchByKey(key).stream().peek(System.out::println).toList();
    }
}

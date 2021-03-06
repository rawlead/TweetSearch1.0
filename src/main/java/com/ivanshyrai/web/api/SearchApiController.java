package com.ivanshyrai.web.api;

import com.ivanshyrai.search.ParallelSearchService;
import com.ivanshyrai.web.LightTweet;
import com.ivanshyrai.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test.search")     //  test
public class SearchApiController /*implements TwitterSearch*/ {

//    private SearchService searchService;

//    async profile
    private ParallelSearchService searchService;

    @Autowired
    public SearchApiController(ParallelSearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/{searchType}", method = RequestMethod.GET)
    public List<LightTweet> search(@PathVariable String searchType,
                                   @MatrixVariable List<String> keywords) {
        return searchService.search(searchType,keywords);
    }
}

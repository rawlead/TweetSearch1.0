package com.ivanshyrai.web.controller;

import com.ivanshyrai.search.ParallelSearchService;
import com.ivanshyrai.web.LightTweet;
import com.ivanshyrai.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller                        // test
public class SearchController /*implements TwitterSearch*/ {

//    private SearchService searchService;

//    async
    private ParallelSearchService searchService;

    @Autowired
    public SearchController(ParallelSearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping("/test.search/{searchType}")
    public ModelAndView search(@PathVariable String searchType,
                               @MatrixVariable List<String> keywords){
        List<LightTweet> tweets = searchService.search(searchType, keywords);
        ModelAndView modelAndView = new ModelAndView("resultPage");
        modelAndView.addObject("tweets",tweets);
        modelAndView.addObject("object",String.join(",",keywords));
        return modelAndView;
    }



    // test
//    @RequestMapping("/test.search/{searchType}")
//    public List<LightTweet> test.search(@PathVariable String searchType,
//                               @MatrixVariable List<String> keywords){
//        List<LightTweet> tweets = searchService.test.search(searchType, keywords);
//        ModelAndView modelAndView = new ModelAndView("resultPage");
//        modelAndView.addObject("tweets",tweets);
//        modelAndView.addObject("object",String.join(",",keywords));
//        return tweets;
//    }


}

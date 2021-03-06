package com.ivanshyrai.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class TweetController {

    @Autowired
    private Twitter twitter;


    @RequestMapping("/")
    public String home() {
        return "searchPage";
    }

    @RequestMapping("/result")
    public String hello(@RequestParam(defaultValue = "NASA") String search, Model model) {
        SearchResults searchResults = twitter.searchOperations().search(search);
        List<Tweet> tweets = searchResults.getTweets();
        model.addAttribute("tweets",tweets);
        model.addAttribute("test.search",search);
        return "resultPage";
    }

    @RequestMapping(value = "/postSearch",method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String search = request.getParameter("test.search");
        if (search.toLowerCase().contains("junk")) {
            redirectAttributes.addFlashAttribute("error", "Try another word!");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("test.search", search);
        return "redirect:/result";
    }
}

package com.ivanshyrai.search;

import com.ivanshyrai.search.cache.SearchCache;
import com.ivanshyrai.web.LightTweet;
import com.ivanshyrai.web.TwitterSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchParameters.ResultType;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("!async") // SearchService will be created if profile async is not active
public class SearchService implements TwitterSearch
{
    private SearchCache searchCache;

    @Autowired
    public SearchService(SearchCache searchCache) {
        this.searchCache = searchCache;
    }

    @Override
    public List<LightTweet> search(String searchType, List<String> keywords) {
        return keywords.stream()
                .flatMap(keyword -> searchCache.fetch(searchType,keyword).stream())
                .collect(Collectors.toList());
    }

    //    without cache
//    private Twitter twitter;
//
//    @Autowired
//    public SearchService(Twitter twitter) {
//        this.twitter = twitter;
//    }
//
//    public List<LightTweet> search(String searchType, List<String> keywords) {
//        List<SearchParameters> searches = keywords.stream()
//                .map(taste -> createSearchParam(searchType, taste))
//                .collect(Collectors.toList());
//        List<LightTweet> results = searches.stream()
//                .map(params -> twitter.searchOperations()
//                        .search(params))
//                .flatMap(searchResults -> searchResults.getTweets()
//                        .stream())
//                .map(LightTweet::ofTweet)
//                .collect(Collectors.toList());
//        return results;
//    }
//
//    private ResultType getResultType(String searchType) {
//        for (ResultType knowType : ResultType.values()) {
//            if (knowType.name().equalsIgnoreCase(searchType))
//                return knowType;
//        }
//        return ResultType.RECENT;
//    }
//
//    private SearchParameters createSearchParam(String searchType, String taste) {
//        ResultType resultType = getResultType(searchType);
//        SearchParameters searchParameters = new SearchParameters(taste);
//        searchParameters.resultType(resultType);
//        searchParameters.count(3);
//        return searchParameters;
//    }
}

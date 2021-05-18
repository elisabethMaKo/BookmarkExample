package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Bookmark {

    public boolean validate(String stringForUrl) throws MalformedURLException {
        URL urlToTest = new URL(stringForUrl);
        return true;
    }

    public void addURLToList(URL urlForList, List<URL> urlList1) throws MalformedURLException {
        urlList1.add(urlForList);
    }

    public void addTagToUrl(HashMap<String, URL> hashMap, URL urlForHashMap, String tag) {
        hashMap.put(tag, urlForHashMap);
    }

    public URL findingATaggedURL(HashMap<String, URL> hashMap, String tag) {
        URL urlFound = null;
        urlFound = (URL) hashMap.get(tag);
        return urlFound;
    }

    public void addRatingToUrl(HashMap<URL, Integer> ratingHash, URL url, Integer rating) {
        ratingHash.put(url, rating);
    }

    public void increaseRating(HashMap<URL, Integer> ratingHash, URL url) {
        Integer increaseRating =  ratingHash.get(url);
        ratingHash.remove(url);
        increaseRating++;
        ratingHash.put(url, increaseRating);
    }

    public URL findingDuplicateUrl(HashMap<String, URL> urlHashMap, URL url) {
        URL urlFound = null;

        for (Iterator<Map.Entry<String, URL>> iterator = urlHashMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String, URL> pair = iterator.next();
            if (url == pair.getValue()) {
                urlFound = pair.getValue();
                return urlFound;
            }
        }
        return urlFound;
    }


    /**
    public void addHashToHash(HashMap<String, HashMap<URL, Integer>> urlHash, String tag, HashMap<URL, Integer> ratingHash, URL url, Integer rating ){

        ratingHash.put(url, rating);
        urlHash.put(tag, ratingHash);
    } **/

    /**
    public String urlAlreadyExists(HashMap<String, HashMap<URL, Integer>> urlHash, HashMap<URL, Integer> ratingHash, URL url) {

        if (ratingHash.containsKey(url)) {

            return tag;
        }
        return null;


    }**/

    /** public Integer increaseRating(HashMap<String, HashMap<URL, Integer>> urlHash, HashMap<URL, Integer> ratingHash) {

     ratingHash.

     return Integer;
     } **/

}

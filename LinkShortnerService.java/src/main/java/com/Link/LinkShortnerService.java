package com.Link;

import java.util.HashMap;
import java.util.Map;

public class LinkShortnerService {

    private static final String BASE_URL = "http://short.ly/";
    private static final int SHORT_URL_LENGTH = 6;

    private Map<String, String> urlMap = new HashMap<>();
    private Map<String, String> reverseUrlMap = new HashMap<>();

    public String shortenURL(String longUrl) {
        if (reverseUrlMap.containsKey(longUrl)) {
            return reverseUrlMap.get(longUrl);
        }

        String shortUrl = generateShortUrl();
        while (urlMap.containsKey(shortUrl)) {
            shortUrl = generateShortUrl();
        }

        urlMap.put(shortUrl, longUrl);
        reverseUrlMap.put(longUrl, shortUrl);
        return BASE_URL + shortUrl;
    }

    public String expandURL(String shortUrl) {
        String key = shortUrl.replace(BASE_URL, "");
        return urlMap.get(key);
    }

    private String generateShortUrl() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrl = new StringBuilder(SHORT_URL_LENGTH);
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = (int) (Math.random() * characters.length());
            shortUrl.append(characters.charAt(index));
        }
        return shortUrl.toString();
    }
}


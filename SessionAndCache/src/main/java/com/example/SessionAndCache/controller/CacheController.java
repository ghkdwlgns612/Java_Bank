package com.example.SessionAndCache.controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class CacheController {
    private int size;
    private static LinkedHashMap<String, String> cache = new LinkedHashMap<>();

    public CacheController(int size) {
        this.size = size;
    }

    public void put(String value) {
        String find = cache.get(value);
        if (find != null)
            cache.remove(find);
        cache.put(value, value);
        if (cache.size() > size)
            cache.remove(cache.get(size));
    }

    public String get(String value) {
        return cache.get(value);
    }

    public String getAll() {
        return cache.toString();
    }
}

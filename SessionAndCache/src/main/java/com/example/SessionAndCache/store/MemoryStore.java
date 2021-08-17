package com.example.SessionAndCache.store;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class MemoryStore<K,V> {

    private final Function<K, V> initialValue;
    private final ConcurrentHashMap<K, V> cache;

    public MemoryStore(Function<K, V> initialValue) {
        this.initialValue = initialValue;
        cache = new ConcurrentHashMap<>();
    }

    public V get(K key) {
        return cache.computeIfAbsent(key, initialValue);
    }
}

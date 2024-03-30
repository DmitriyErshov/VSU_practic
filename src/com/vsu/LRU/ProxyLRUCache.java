package com.vsu.LRU;

import java.util.*;

public class ProxyLRUCache<K, V> implements LruCache<K, V> {

    MyLruCache<K, V> cache;

    //очередь для восстановления хронологической последовательности ключей
    int numLastQueries = 10;
    ArrayDeque<K> cacheQueries = new ArrayDeque<K>();

    public ProxyLRUCache(int maxSize) {
        cache = new MyLruCache(maxSize);
    }

    @Override
    public V get(K key) throws InterruptedException {
        Date begin = new Date();

        V foundElem = cache.get(key);

        if (cacheQueries.size() > 0) {
            System.out.print("History: ");

            for (K keyQuer: cacheQueries) {
                System.out.print(keyQuer.toString() + " ");
            }
        }

        if (cacheQueries.size() > numLastQueries) {
            cacheQueries.pollFirst();
        }

        cacheQueries.addLast(key);

        Date end = new Date();
        System.out.println("Element is found. Execution time: "+ (end.getTime() - begin.getTime()));

        return foundElem;
    }

    @Override
    public V set(K key, V value) throws InterruptedException {
        Date begin = new Date();

        V deletedElem  = cache.set(key, value);

        if (deletedElem != null) {
            System.out.print(deletedElem.toString() +  " was deleted. ");
        }

        Date end = new Date();
        System.out.println("New element was set. Execution time: "+(end.getTime() - begin.getTime()));

        return deletedElem;
    }

    @Override
    public int getSize() {
        return cache.getSize();
    }

    @Override
    public int getLimit() {
        return cache.getLimit();
    }
}

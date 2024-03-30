package com.vsu;

import com.vsu.LRU.CacheTypes;
import com.vsu.LRU.MyLruCache;
import com.vsu.LRU.ProxyLRUCache;
import com.vsu.LRU.ProxyLRUFactory;

import java.util.Date;

/*
Ершов Дмитрий 14 гр
Разработать LRU cache для хранения фильмов
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ProxyLRUFactory factory = new ProxyLRUFactory();

        ProxyLRUCache lruCache = factory.createCache(4);


        if (lruCache != null) {
            lruCache.set(3, "Film1");
            lruCache.set(5, "Film2");
            lruCache.set(8, "Film3");
            lruCache.set(13, "Film4");
            lruCache.get(3); //поднимем рейтинг первого фильма
            lruCache.set(21, "Film5"); //вместо Film1 удалится Film2

            lruCache.get(5);
            lruCache.get(21);
            //lruCache.set(34, "Film6");
        }
    }
}

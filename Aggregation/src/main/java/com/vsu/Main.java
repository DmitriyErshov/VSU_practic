package com.vsu;

import com.vsu.HashCollection.Pair;
import com.vsu.LRU.*;
import com.vsu.UserInputer;

/*
Ершов Дмитрий 14 гр
Разработать LRU cache для хранения фильмов
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ProxyLRUFactory factory = new ProxyLRUFactory();

        ProxyLRUCache lruCache = factory.createCache(4);
        UserInputer userInputer = new UserInputer();
        Pair<Integer, String> p = userInputer.inputFilm();
        System.out.println(p.key + " " + p.value);
        lruCache.set(p.key, p.value);


//        if (lruCache != null) {
//            lruCache.set(3, "Film1");
//            lruCache.set(5, "Film2");
//            lruCache.set(8, "Film3");
//            lruCache.set(13, "Film4");
//            lruCache.get(3); //поднимем рейтинг первого фильма
//            lruCache.set(21, "Film5"); //вместо Film1 удалится Film2
//
//            lruCache.get(5);
//            lruCache.get(21);
//            //lruCache.set(34, "Film6");
//        }
    }
}

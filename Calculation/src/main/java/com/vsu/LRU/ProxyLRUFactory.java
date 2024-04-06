package com.vsu.LRU;

public class ProxyLRUFactory <K, V>{
    public  ProxyLRUCache createCache( int size) {
        return  new ProxyLRUCache<K, V>(size);
    }
}

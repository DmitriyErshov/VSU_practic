package com.vsu.LRU;

import com.vsu.HashCollection.HashTable;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MyLruCache<K, V> implements LruCache<K, V>
{
    int maxSize;
    HashTable<K, V> map;
    //очередь с приоритетом
    PriorityQueue<Pair> queue = new PriorityQueue(timeComparator);

    public MyLruCache(int maxSize){
        this.maxSize = maxSize;
        map = new HashTable(maxSize);
    }

    @Override
    public V get(K key) throws InterruptedException {
        V foundElem = map.search(key);

        if (foundElem != null) {
            queue.removeIf(n -> (n.key == key));
            queue.add(new Pair(key));
        }

        return foundElem;
    }

    @Override
    public V set(K key, V value) throws InterruptedException {
        V deletedElemValue = null;

        if (map.getSize() == maxSize) {
            K deletedElemKey = (K) queue.poll().key;
            deletedElemValue = map.search(deletedElemKey);
            map.delete(deletedElemKey);
        }

        map.Add(key, value);
        queue.add(new Pair(key));

        return deletedElemValue;
    }

    @Override
    public int getSize() {
        return map.getSize();
    }

    @Override
    public int getLimit() {
        return maxSize;
    }

    public static Comparator<Pair> timeComparator = new Comparator<Pair>(){
        @Override
        public int compare(Pair c1, Pair c2) {
            return c1.usageDate.compareTo(c2.usageDate);
        }
    };
}

package com.vsu;

import com.vsu.LRU.MyLruCache;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class LRUTest {
    private MyLruCache<Integer, String> cache;

    @BeforeEach
    void load() throws Exception {
        cache = new MyLruCache<Integer, String>(4);
    }

    @Test
    void add1() throws InterruptedException {
        String s = cache.set(4, "name");

        assertEquals(cache.get(4), "name");
    }

    @Test
    void add5() throws InterruptedException {
        cache.set(4, "nam4e");
        cache.set(5, "name5");
        cache.set(6, "name6");
        cache.set(7, "name7");
        cache.set(8, "name7");
    }

    @Test
    void addInstead() throws InterruptedException {
        cache.set(4, "name4");
        cache.set(5, "name5");
        cache.set(6, "name6");
        cache.set(7, "name7");

        assertEquals(cache.set(4, "name5"), "name4");
    }
}

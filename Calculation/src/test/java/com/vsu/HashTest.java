package com.vsu;

import com.vsu.HashCollection.HashTable;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class HashTest {
    private HashTable<Integer, String> map;

    @BeforeEach
    void load() throws Exception {
        map = new HashTable<Integer, String>(10);
    }

    @Test
    void addElem() {
        map.Add(1, "name");

        assertEquals(map.getSize(), 1);
    }

    @Test
    void addMaxElem() {
        for (int i=0;i<10;i++){
            map.Add(i, "name");
        }
    }
    @Test
    void searchElem() {
        map.Add(1, "name");

        assertEquals(map.search(1), "name");
    }
}

package com.vsu;

import com.vsu.HashCollection.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.vsu.HashCollection.Pair;

public class MainTest {
    private UserInputer userInputer;

    @BeforeEach
    void load() throws Exception {
        userInputer = new UserInputer();
    }

    @Test
    void addElem() {
        //Pair<Integer, String> p = userInputer.inputFilm();

        //assertEquals(map.getSize(), 1);
    }
}

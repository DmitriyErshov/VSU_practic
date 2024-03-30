package com.vsu.LRU;

import com.vsu.HashCollection.ECellState;

import java.sql.Time;
import java.util.Comparator;
import java.util.Date;

public class Pair <k> {
    public k key;
    public Date usageDate;

    public Pair(k key) throws InterruptedException {
        this.key = key;
        usageDate = new Date();
        Thread.sleep(2);
        usageDate.getTime();
    }
}

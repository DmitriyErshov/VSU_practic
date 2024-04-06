package com.vsu.HashCollection;

public class Pair<TK, TV>
{
    public TK key;
    public TV value;
    public ECellState cellState;

    public Pair() {
        key = null;
        value = null;
        cellState = ECellState.csFree;
    }
}

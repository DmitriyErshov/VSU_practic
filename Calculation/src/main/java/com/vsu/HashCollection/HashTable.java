package com.vsu.HashCollection;

public class HashTable<TK, TV> {
    int tableSize = 0;
    int tableMaxSize = 0;
    Pair<TK, TV>[] tableArray;

    public HashTable(int maxSize)
    {
        tableMaxSize = maxSize;

        tableArray = new Pair[maxSize];

        for (int i = 0; i < maxSize; i++)
        {
            tableArray[i] = new Pair<TK, TV>();
        }
    }

    public int getSize()
    {
        return 999;
    }

    public boolean Add(TK key, TV value)
    {
        boolean wasAdded = false; //флаг - успешное добавление

        int insertIndex = key.hashCode() % tableMaxSize;

        int i = insertIndex;

        //проверка на переполнение
        if (tableSize == tableMaxSize)
        {
            return false;
        }

        do
        {
            //проверяем выход за границу таблицы
            if (i == tableMaxSize)
                i = 0;
            //проверяем на дубликат или на заполненную ячейку
            if (key.equals(tableArray[i].key)){
                //найден дубликат
                tableArray[i].value = value;
                return false;
            }
            //если ячейка пустая, записываем данные
            if (tableArray[i].cellState == ECellState.csFree  || tableArray[i].cellState == ECellState.csDel)
            {
                tableArray[i].key = key;
                tableArray[i].value = value;
                tableArray[i].cellState = ECellState.csFull;

                wasAdded = true;
                tableSize++;
            }
            i++;
        } while (!wasAdded);

        return wasAdded;
    }

    public TV search(TK key)
    {
        int insertIndex = key.hashCode() % tableMaxSize;

        //ищем до первой пустой ячейки или до перебора всех значений
        int i = insertIndex;
        int n = 0;
        while (n < tableSize)
        {
            if (i == tableMaxSize)
                i = 0;
            if (tableArray[i].cellState == ECellState.csFree)
                return null;
                //throw new HashExceptionIsNotFound();
            else if (key.equals(tableArray[i].key))
                return tableArray[i].value;
            //return tableArray[i].value;
            i++;
            n++;
        }
        return null;
        //throw new HashExceptionIsNotFound();
    }

    public boolean delete(TK key)
    {
        int insertIndex = key.hashCode() % tableMaxSize;

        //ищем до первой пустой ячейки или до перебора всех значений
        int i = insertIndex;
        int n = 0;
        while (n < tableSize)
        {
            if (i == tableMaxSize)
                i = 0;
            if (tableArray[i].cellState == ECellState.csFree)
                return false;
            else if (key.equals(tableArray[i].key)) {
                tableArray[i].cellState = ECellState.csDel;
                tableSize--;
                return true;
            }
            i++;
            n++;
        }
        return false;
    }
}

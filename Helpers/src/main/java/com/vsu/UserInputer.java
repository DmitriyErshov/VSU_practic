package com.vsu;

import com.vsu.HashCollection.Pair;

import java.util.Scanner;

public class UserInputer {
    public Pair<Integer, String> inputFilm(){
        int a;
        String b;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a film id: ");
        a = scanner.nextInt();

        System.out.print("Enter a film name: ");
        b = scanner.next();

        Pair<Integer, String> p = new Pair<>();
        p.key = a;
        p.value = b;
        return p;
    }
}

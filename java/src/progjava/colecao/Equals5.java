package progjava.colecao;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 21/05/2003
 * Time: 18:05:14
 */
public class Equals5 {
    public static void main(String[] args) {
        String br = "Brasil";
        String mx = "Mexico";

        System.out.println(br == mx ? "iguais" : "diferentes");
        System.out.println("Brasil" == "Brasil" ? "iguais" : "diferentes");
        System.out.println(br == "Brasil" ? "iguais" : "diferentes");

        br = "Brasil";
        System.out.println(br == "Brasil" ? "iguais" : "diferentes");

        mx = "Brasil";
        System.out.println(br == mx ? "iguais" : "diferentes");
    }
}
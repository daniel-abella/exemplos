package progjava.colecao;

public class Equals4 {
    public static void main(String[] args) {
        String br = "Brasil";
        String au = "Australia";
        System.out.println(br == au ? "iguais" : "diferentes");

        br = "Brasil";
        au = "Brasil";
        System.out.println(br == au ? "iguais" : "diferentes");
    }
}
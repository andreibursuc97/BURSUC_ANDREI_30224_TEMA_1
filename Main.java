package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
       /* System.out.println("Dati ecuatia:");
        Scanner scanner=new Scanner(System.in);
        String i=scanner.nextLine();*/
        //System.out.println(i);
        Model n=new Model();
        Polinom polinom=new Polinom("2x^20-1x^2+3x^2-x^5+5-3+2");
        Polinom polinom1=new Polinom("2x^2+3x^6-4x^5+3");
        System.out.println(" ");
        Polinom suma=n.adunare(polinom,polinom1);
        suma.afisarePolinom();

        polinom=new Polinom("x^20-1x^2+3x^2-x^5+5-3+2");
        polinom1=new Polinom("2x^2+3x^6-4x^5+3");

        Polinom diferenta=n.scadere(polinom,polinom1);
        System.out.println(" ");
        diferenta.afisarePolinom();

        polinom=new Polinom("2x^20-1x^2+3x^2-x^5+5-3+2");
        polinom1=new Polinom("2x^2+3x^6-4x^5+3");

        Polinom produs=n.inmultire(polinom,polinom1);
        System.out.println(" ");
        produs.afisarePolinom();
        System.out.println(" ");

        polinom=new Polinom("2x^20-1x^2+3x^2-x^5+5-3+2");
        Polinom derivat=n.derivare(polinom);
        derivat.afisarePolinom();

        View view=new View();

    }
}

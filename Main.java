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
        Polinom polinom=new Polinom("2x^20-3x^2+3x^2-x^5+5-3+2");
        Polinom polinom1=new Polinom("2x^2-4x^5+3");

        Polinom suma=n.adunare(polinom,polinom1);

        suma.afisarePolinom();

    }
}

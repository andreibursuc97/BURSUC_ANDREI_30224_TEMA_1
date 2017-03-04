package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
       /* System.out.println("Dati ecuatia:");
        Scanner scanner=new Scanner(System.in);
        String i=scanner.nextLine();*/
        //System.out.println(i);

        Polinom polinom=new Polinom("-2x^20-5x^2+3x^5+5");
        polinom.getListaMonoame();


    }
}

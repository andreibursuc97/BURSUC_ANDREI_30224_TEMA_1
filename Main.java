package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        View view=new View();
        Model model=new Model();
        Controller controller=new Controller(view,model);


       /* System.out.println("Dati ecuatia:");
        Scanner scanner=new Scanner(System.in);
        String i=scanner.nextLine();*/
        //System.out.println(i);
        /*Model n=new Model();
        Polinom polinom=new Polinom("2x^20-1x^2+3x^2-x^5+5-3+2");
        Polinom polinom1=new Polinom("2x^2+3x^6-4x^5+3");
        //System.out.println(" ");
        Polinom suma=n.adunare(polinom,polinom1);
        System.out.println(suma.afisarePolinom());

       polinom=new Polinom("x^20-1x^2+3x^2-x^5+5-3+2");
        polinom1=new Polinom("2x^2+3x^6-4x^5+3");

        Polinom diferenta=n.scadere(polinom,polinom1);
        //System.out.println(" ");
        System.out.println(diferenta.afisarePolinom());

        polinom=new Polinom("2x^20-x^2+3x^2-x^5+5-3+2");
        polinom1=new Polinom("2x^2");

        Polinom produs=n.inmultire(polinom,polinom1);
        //System.out.println(" ");
        System.out.println(produs.afisarePolinom());
        //System.out.println(" ");

        polinom=new Polinom("2x^20+2x^3-x^5+4");
        Polinom derivat=n.derivare(polinom);
        System.out.println(derivat.afisarePolinom());
        polinom=new Polinom("2x^20+2x^2-x^5+4");
        Polinom integrat=n.integrare(polinom);
        //System.out.println();
        System.out.println(integrat.afisarePolinom());
        //View view=new View()*/

        //test impartire
        try {
            Polinom polinom = new Polinom("7x");
            Polinom polinom1 = new Polinom("3");

            ArrayList<Monom> lista = new ArrayList<>();
            Polinom impartire = model.impartire(polinom, polinom1, lista);
            lista = impartire.getListaRest();
            Polinom rest = new Polinom(lista);
            //System.out.println();
            //lista=impartire.getListaMonoame();
            System.out.println(impartire.afisarePolinom());
            System.out.println(rest.afisarePolinom());
            Polinom nou = model.inmultire(impartire, polinom1);
            nou = model.adunare(nou, rest);
            System.out.println(nou.afisarePolinom());
            polinom1 = new Polinom("-x^2+2x+2");
            polinom = new Polinom("-x^2+2x+2");
            System.out.println(polinom.equals(polinom1));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }


    }
}

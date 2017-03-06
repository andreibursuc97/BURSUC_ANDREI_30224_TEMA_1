package com.company;

import javax.swing.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.TreeSet;

/**
 * Created by Andrei on 04.03.2017.
 */

public class Polinom {

    //private Monom monom;
    private ArrayList<Monom> listaMonoame;
    //private String[] parts;

    public Polinom(String text)
    {
        try{
            listaMonoame=new ArrayList<>();
            if(text.contains("^+") || text.contains("^-"))
                throw new InvalidParameterException();
            for(int i=0;i<text.length();i++) {
                if (text.charAt(i) < '0' || text.charAt(i) > '9')
                    if (text.charAt(i) != 'x' && text.charAt(i) != '^' && text.charAt(i) != '+' && text.charAt(i) != '-') {
                        throw new InvalidParameterException();
                    }
            }
            String[] parts = text.split("(?=\\+|\\-)");
            for(int i=0;i<parts.length;i++)
                listaMonoame.add(new Monom(parts[i]));

            this.sort();
            this.merge();
            this.clean();
        }
        catch(InvalidParameterException e)
        {
            System.out.println("Invalid input");
        }
    }

    public Polinom(ArrayList<Monom> listaMonoame){
        this.listaMonoame=listaMonoame;
        this.sort();
    }

    public Polinom(Monom n)
    {
        ArrayList<Monom> lista=new ArrayList<>();
        lista.add(n);
        this.listaMonoame=lista;
    }

    public void merge(){
        this.sort();
        int i=0;
        int j;
        Monom m,n;
        while(i<= this.listaMonoame.size()-2)
        {
            j=i+1;
            m=this.listaMonoame.get(i);
            while(j<this.listaMonoame.size() && m.equals(this.listaMonoame.get(j)) )
            {

                n=this.listaMonoame.get(j);
                m.setCoeficient(m.getCoeficient()+n.getCoeficient());
                this.listaMonoame.remove(j);
            }
            i++;
        }
    }

    public void clean(){
        int i=0;
        Monom m;
        while(i< this.listaMonoame.size())
        {
            m=this.listaMonoame.get(i);
            if(m.getCoeficient()==0) this.listaMonoame.remove(i);
            else i++;
        }
    }

    public void sort()
    {
        this.listaMonoame.sort(new Comparator<Monom>() {
            @Override
            public int compare(Monom o1, Monom o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public ArrayList<Monom> getListaMonoame(){

        ArrayList<Monom> lista=new ArrayList<Monom>(this.listaMonoame);
        return lista;
    }

    public void setListaMonoame(ArrayList<Monom> list){
        this.listaMonoame=list;
    }

    public void afisarePolinom()
    {
        this.clean();
        for(Monom m:this.listaMonoame) {
            if (m.equals(this.listaMonoame.get(0))) {
                if (m.getGrad() > 1)
                    System.out.print(m.getTextCoeficient() + "x^" + m.getGrad());
                else if (m.getGrad() == 1)
                    System.out.print(m.getTextCoeficient() + "x");
                else
                    System.out.print(m.getTextCoeficient());
                continue;
            }

            if (m.getCoeficient() > 0){
                System.out.print("+");
                if (m.getGrad() > 1)
                    System.out.print(m.getTextCoeficient() + "x^" + m.getGrad());
                else if (m.getGrad() == 1)
                    System.out.print(m.getTextCoeficient() + "x");
                else
                    System.out.print(m.getTextCoeficient());
            }
            else
                 if (m.getGrad() > 1)
                    System.out.print(m.getTextCoeficient() + "x^" + m.getGrad());
                 else if (m.getGrad() == 1)
                     System.out.print(m.getTextCoeficient() + "x");
                 else
                     System.out.print(m.getTextCoeficient());


        }

    }

    public void adaugaMonom(Monom m)
    {
        int ok=0;
        for(Monom n:this.listaMonoame)
        {
            if(n.getGrad()==m.getGrad())
            {
                n.setCoeficient(n.getCoeficient()+m.getCoeficient());
                ok=1;
                break;
            }
        }
        if(ok==0) this.listaMonoame.add(m);
    }


}

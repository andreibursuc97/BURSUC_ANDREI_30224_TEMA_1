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

    public void merge(){
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
            i++;
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
                    System.out.print(m.getCoeficient() + "x^" + m.getGrad());
                else if (m.getGrad() == 1)
                    System.out.print(m.getCoeficient() + "x");
                else
                    System.out.print(m.getCoeficient());
                continue;
            }

            if (m.getCoeficient() > 0){
                System.out.print("+");
                if (m.getGrad() > 1)
                    System.out.print(m.getCoeficient() + "x^" + m.getGrad());
                else if (m.getGrad() == 1)
                    System.out.print(m.getCoeficient() + "x");
                else
                    System.out.print(m.getCoeficient());
            }
            else
                 if (m.getGrad() > 1)
                    System.out.print(m.getCoeficient() + "x^" + m.getGrad());
                 else if (m.getGrad() == 1)
                     System.out.print(m.getCoeficient() + "x");
                 else
                     System.out.print(m.getCoeficient());


        }

    }

}

/*if(text.lastIndexOf('+')==-1 && text.lastIndexOf('-')!=0)
                monom=new Monom(text,0);
            else if(text.lastIndexOf('+')==-1 && text.lastIndexOf('-')==0)
                monom=new Monom(text,1);
                    else{
                        parts=text.split(delimiter1);
                        for(int i=0;i<parts.length;i++) {
                            if (parts[i].lastIndexOf('-') == -1)
                                monom = new Monom(parts[i], 0);
                            else {
                                int ok=0;
                                if(parts[i].charAt(0)=='-') {
                                    ok=1;
                                    parts[i]=parts[i].substring(1);
                                }
                                parts2 = parts[i].split(delimiter2);
                                if(ok==1) monom=new Monom(parts2[0],1);
                                    else monom=new Monom(parts2[0],0);
                                for (int j = 1; j < parts2.length; j++)
                                    monom=new Monom(parts2[j],1);
                            }
                        }*/
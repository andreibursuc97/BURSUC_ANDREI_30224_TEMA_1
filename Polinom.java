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
    private ArrayList<Monom> listaRest;
    //private int eroare=0;
    //private String[] parts;

    public Polinom(String text) throws InvalidParameterException
    {
            listaMonoame=new ArrayList<>();
            if(text.charAt(text.length()-1)=='+' || text.charAt(text.length()-1)=='-' && text.charAt(text.length()-1)=='.' )
                throw new InvalidParameterException("Unul din polinoame a fost introdus in formatul gresit!");
            if(text.contains("^+") || text.contains("^-") || text.contains("-+") || text.contains("+-") || text.contains("--") || text.contains("++") || text.contains("^x") || text.contains("xx"))
                throw new InvalidParameterException("Unul din polinoame a fost introdus in formatul gresit!");
            if(text.contains(".x") || text.contains("x.") || text.contains(".^") || text.contains("^."))
                throw new InvalidParameterException("Unul din polinoame a fost introdus in formatul gresit!");
            if((text.contains(".")|| text.contains("^") ) && text.length()==1 )
                throw new InvalidParameterException("Unul din polinoame a fost introdus in formatul gresit!");

        for(int i=0;i<text.length();i++) {
                if (text.charAt(i) < '0' || text.charAt(i) > '9')
                    if (text.charAt(i) != 'x' && text.charAt(i) != '^' && text.charAt(i) != '+' && text.charAt(i) != '-' && text.charAt(i) != '.') {
                        throw new InvalidParameterException("Unul din polinoame a fost introdus in formatul gresit!");
                    }
            }
            String[] parts = text.split("(?=\\+|\\-)");
            for(int i=0;i<parts.length;i++)
                listaMonoame.add(new Monom(parts[i]));

            this.sort();
            this.merge();
            this.clean();


    }

    public Polinom(ArrayList<Monom> listaMonoame){
        this.listaMonoame=listaMonoame;
        this.sort();
        this.clean();
        this.merge();
    }

    public Polinom(Monom n)
    {
        ArrayList<Monom> lista=new ArrayList<>();
        lista.add(n);
        this.listaMonoame=lista;
    }

    public Polinom(ArrayList<Monom> lista, ArrayList<Monom> listaRest)
    {
        this.listaMonoame=lista;
        this.listaRest=listaRest;
        this.sort();
        this.clean();
        this.merge();

    }
    public Polinom()
    {}

    @Override
    public boolean equals(Object obj) {
        Polinom poli=new Polinom();
        if(obj instanceof Polinom)
            poli=(Polinom) obj;
        else return false;
        if(this.listaMonoame.size()!=poli.getListaMonoame().size())
            return false;

        for(Monom m:poli.getListaMonoame())
            if(!this.listaMonoame.contains(m)) return false;
        return true;
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
            while(j<this.listaMonoame.size() && m.getGrad()==this.listaMonoame.get(j).getGrad() )
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
            //if(this.listaMonoame.size()==1) break;
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

    public String afisarePolinom()
    {
        this.clean();
        StringBuilder s=new StringBuilder();
        if(this.listaMonoame.isEmpty())
        {
            String a=new String("0");
            return a;
        }
        for(Monom m:this.listaMonoame) {
            if (m.equals(this.listaMonoame.get(0))) {
                if (m.getGrad() > 1)
                    s.append(m.getTextCoeficient() + "x^" + m.getGrad());
                else if (m.getGrad() == 1)
                    s.append(m.getTextCoeficient() + "x");
                else
                    s.append(m.getTextCoeficient());
                continue;
            }

            if (m.getCoeficient() > 0){
                s.append("+");
                if (m.getGrad() > 1)
                    s.append(m.getTextCoeficient() + "x^" + m.getGrad());
                else if (m.getGrad() == 1)
                    s.append(m.getTextCoeficient() + "x");
                else
                    s.append(m.getTextCoeficient());
            }
            else
                 if (m.getGrad() > 1)
                     s.append(m.getTextCoeficient() + "x^" + m.getGrad());
                 else if (m.getGrad() == 1)
                     s.append(m.getTextCoeficient() + "x");
                 else
                     s.append(m.getTextCoeficient());


        }
        String rez=s.toString();

        return rez;
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

    public ArrayList<Monom> getListaRest()
    {
        return this.listaRest;
    }

}

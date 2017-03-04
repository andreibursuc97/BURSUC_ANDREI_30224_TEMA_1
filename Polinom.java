package com.company;

import javax.swing.*;
import java.security.InvalidParameterException;
import java.util.TreeSet;

/**
 * Created by Andrei on 04.03.2017.
 */

public class Polinom {

    private Monom monom;
    private TreeSet<Monom> listaMonoame;
    private String[] parts;

    public Polinom(String text)
    {
        try{
            listaMonoame=new TreeSet<Monom>();
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
        }
        catch(InvalidParameterException e)
        {
            System.out.println("Invalid input");
        }
    }

    public void getListaMonoame(){
        for (Monom m:this.listaMonoame) {
            System.out.println(m.getCoeficient()+" "+m.getGrad());
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
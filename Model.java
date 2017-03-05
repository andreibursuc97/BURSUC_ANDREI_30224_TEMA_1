package com.company;

import java.util.ArrayList;

/**
 * Created by Andrei on 04.03.2017.
 */
public class Model {
    public Polinom adunare(Polinom poli1,Polinom poli2){
        ArrayList<Monom> listaAdunare,lista1,lista2;
        listaAdunare=new ArrayList<Monom>();
        lista1=poli1.getListaMonoame();
        lista2=poli2.getListaMonoame();
        Monom suma;
        int coef,ok,i=0;
        boolean[] marcat=new boolean[lista2.size()];
        for(Monom m:lista1) {
            ok=0;
            i=0;
            for (Monom n : lista2)
            {
                if (m.equals(n)) {
                    coef = m.getCoeficient() + n.getCoeficient();
                    suma = new Monom(coef, m.getGrad());
                    listaAdunare.add(suma);
                    marcat[i]=true;
                    ok=1;
                    break;
                }
                i++;
            }
            if(ok==0)
                listaAdunare.add(m);
        }

        for(i=0;i<lista2.size();i++)
            if (!marcat[i])
                listaAdunare.add(lista2.get(i));

        Polinom sum=new Polinom(listaAdunare);
        sum.sort();
        return sum;
    }
}

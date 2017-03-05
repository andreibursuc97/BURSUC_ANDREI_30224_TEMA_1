package com.company;

import java.util.ArrayList;

/**
 * Created by Andrei on 04.03.2017.
 */
public class Model {

    public Polinom adunare(Polinom poli1, Polinom poli2) {
        ArrayList<Monom> listaAdunare = new ArrayList<Monom>(poli1.getListaMonoame());
        ArrayList<Monom> lista2 = poli2.getListaMonoame();
        Polinom suma=new Polinom(listaAdunare);
        for(Monom m:lista2)
            suma.adaugaMonom(m);
        suma.sort();
        return suma;
    }

    public Polinom scadere(Polinom poli1, Polinom poli2) {
        ArrayList<Monom> listaDiferente = new ArrayList<Monom>(poli1.getListaMonoame());
        ArrayList<Monom> lista2 = poli2.getListaMonoame();
        Polinom diferenta=new Polinom(listaDiferente);
        for(Monom m:lista2)
        {
            m.setInversCoeficient();
            diferenta.adaugaMonom(m);
        }
        diferenta.sort();
        return diferenta;
    }


    public Polinom inmultire(Polinom polinom1,Polinom polinom2)
    {
        ArrayList<Monom> listaProdus = new ArrayList<Monom>();
        ArrayList<Monom> lista1 = polinom1.getListaMonoame();
        ArrayList<Monom> lista2 = polinom2.getListaMonoame();
        Monom produs;
        int coef,grad;
        for(Monom m:lista1)
            for(Monom n:lista2) {
                coef = m.getCoeficient() * n.getCoeficient();
                grad=m.getGrad()+n.getGrad();
                produs=new Monom(coef,grad);
                listaProdus.add(produs);
            }
        Polinom produsul=new Polinom(listaProdus);
        produsul.merge();
        return produsul;
    }

    public Polinom impartire(Polinom polinom1,Polinom polinom2) {
        ArrayList<Monom> listaCat = new ArrayList<Monom>();
        ArrayList<Monom> lista1 = polinom1.getListaMonoame();
        ArrayList<Monom> lista2 = polinom2.getListaMonoame();
        Monom cat;

        return null;
    }

    public Polinom derivare(Polinom polinom)
    {
        ArrayList<Monom> listaDerivate = new ArrayList<Monom>();
        ArrayList<Monom> lista1 = polinom.getListaMonoame();
        Monom n;
        for(Monom m:lista1)
        {
            n=new Monom();
            n.setCoeficient(m.getCoeficient()*m.getGrad());
            n.setGrad(m.getGrad()-1);
            listaDerivate.add(n);
        }
        Polinom derivat=new Polinom(listaDerivate);
        return derivat;
    }

}

/*public Polinom scadere(Polinom polinom1, Polinom polinom2) {
        ArrayList<Monom> listaDiferenta = new ArrayList<Monom>();
        ArrayList<Monom> list1 = polinom1.getListaMonoame();
        ArrayList<Monom> list2 = polinom2.getListaMonoame();
        Monom dif;
        int coef, ok, i = 0;
        boolean[] marcat = new boolean[list2.size()];
        for (Monom m : list1) {
            ok = 0;
            i = 0;
            for (Monom n : list2) {
                if (m.equals(n)) {
                    coef = m.getCoeficient() - n.getCoeficient();
                    dif = new Monom(coef, m.getGrad());
                    listaDiferenta.add(dif);
                    marcat[i] = true;
                    ok = 1;
                    break;
                }
                i++;
            }
            if (ok == 0)
                listaDiferenta.add(m);
        }
        for (i = 0; i < list2.size(); i++)
            if (!marcat[i]) {
                Monom m=list2.get(i);
                m.setInversCoeficient(m.getCoeficient());
                listaDiferenta.add(m);
            }

        Polinom diferenta = new Polinom(listaDiferenta);
        return diferenta;
    }*/

    /*public Polinom adunare(Polinom poli1, Polinom poli2) {
        ArrayList<Monom> listaAdunare = new ArrayList<Monom>();
        ArrayList<Monom> lista1 = poli1.getListaMonoame();
        ArrayList<Monom> lista2 = poli2.getListaMonoame();
        Monom suma;
        int coef, ok, i = 0;
        boolean[] marcat = new boolean[lista2.size()];
        for (Monom m : lista1) {
            ok = 0;
            i = 0;
            for (Monom n : lista2) {
                if (m.equals(n)) {
                    coef = m.getCoeficient() + n.getCoeficient();
                    suma = new Monom(coef, m.getGrad());
                    listaAdunare.add(suma);
                    marcat[i] = true;
                    ok = 1;
                    break;
                }
                i++;
            }
            if (ok == 0)
                listaAdunare.add(m);
        }
        for (i = 0; i < lista2.size(); i++)
            if (!marcat[i])
                listaAdunare.add(lista2.get(i));
        Polinom sum = new Polinom(listaAdunare);
        sum.sort();
        return sum;
    }*/
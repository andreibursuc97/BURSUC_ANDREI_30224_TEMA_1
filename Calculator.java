package com.company;

import java.util.ArrayList;

/**
 * Created by Andrei on 04.03.2017.
 */
public class Calculator {

    public Polinom adunare(Polinom poli1, Polinom poli2) {
        ArrayList<Monom> listaAdunare = new ArrayList<Monom>(poli1.getListaMonoame());
        ArrayList<Monom> lista2 = poli2.getListaMonoame();
        Polinom suma=new Polinom(listaAdunare);
        for(Monom m:lista2)
            suma.adaugaMonom(m);
        suma.sort();
        suma.clean();
        suma.merge();
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
        diferenta.clean();
        diferenta.merge();
        return diferenta;
    }


    public Polinom inmultire(Polinom polinom1,Polinom polinom2)
    {
        ArrayList<Monom> listaProdus = new ArrayList<Monom>();
        ArrayList<Monom> lista1 = polinom1.getListaMonoame();
        ArrayList<Monom> lista2 = polinom2.getListaMonoame();
        Monom produs;
        double coef;
        int grad;
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

    public Polinom integrare(Polinom polinom)
    {
        ArrayList<Monom> listaIntegrare = new ArrayList<Monom>();
        ArrayList<Monom> lista1 = polinom.getListaMonoame();
        Monom n;

        for(Monom m:lista1)
        {
            n=new Monom();
            n.setGrad(m.getGrad()+1);
            n.setCoeficient(m.getCoeficient()/n.getGrad());
            listaIntegrare.add(n);

        }
        Polinom integrare=new Polinom(listaIntegrare);
        return integrare;
    }

    public Polinom impartire(Polinom polinom1,Polinom polinom2,ArrayList<Monom> lista)
    {
        ArrayList<Monom> listaImpartire = new ArrayList<Monom>(lista);
        ArrayList<Monom> lista1 = polinom1.getListaMonoame();
        ArrayList<Monom> lista2 = polinom2.getListaMonoame();
        /*if((!lista1.isEmpty()) &&lista2.get(0).getGrad()==0 && lista1.get(0).getGrad()==0)
        {
            Polinom rezult=this.impartirePolinoameGrad0(lista1,lista2,listaImpartire);
            return rezult;
        }*/
        if(lista1.isEmpty() || lista2.get(0).getGrad()>lista1.get(0).getGrad() )
        {
            ArrayList<Monom> listaFinala=new ArrayList<Monom>();

            for (Monom m:listaImpartire)
            {
                listaFinala.add(m);
            }
            Polinom rezultat=new Polinom(listaFinala,lista1);
               return rezultat;
        }
        else {

            Monom n = this.impartireMonoame(lista1.get(0), lista2.get(0));
            listaImpartire.add(n);
            Polinom poli = new Polinom(n);
            poli = this.inmultire(poli, polinom2);
            polinom1 = this.scadere(polinom1, poli);
            return impartire(polinom1, polinom2, listaImpartire);
        }
    }

    public Monom impartireMonoame(Monom monom1,Monom monom2)
    {
        double coef;
        int grad;
        coef=monom1.getCoeficient()/monom2.getCoeficient();
        grad=monom1.getGrad()-monom2.getGrad();
        Monom rez=new Monom(coef,grad);
        return rez;
    }

    /*public Polinom impartirePolinoameGrad0(ArrayList<Monom> list1,ArrayList<Monom> list2,ArrayList<Monom> list)
    {
        ArrayList<Monom> listaCat=new ArrayList<Monom>(list);
        ArrayList<Monom> listaRest=new ArrayList<Monom>();
        ArrayList<Monom> lista1 = new ArrayList<Monom>(list1);
        ArrayList<Monom> lista2 = new ArrayList<Monom>(list2);
        double rest=lista1.get(0).getCoeficient()%lista2.get(0).getCoeficient();
        double cat=(lista1.get(0).getCoeficient()-rest)/lista2.get(0).getCoeficient();
        Monom m=new Monom(cat,0);
        listaCat.add(m);
        m=new Monom(rest,0);
        listaRest.add(m);
        Polinom rezultat=new Polinom(listaCat,listaRest);
        return rezultat;
    }*/

}

package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Andrei on 04.03.2017.
 */
public class Controller  {

    View m_view;
    Model m_model;

    public Controller(View view,Model model)
    {
        this.m_model=model;
        this.m_view=view;
        m_view.addActionListenerAdunare(new ButonAdunareListener());
        m_view.addActionListenerScadere(new ButonScadereeListener());
        m_view.addActionListenerInmultire(new ButonInmultireListener());
        m_view.addActionListenerImpartire(new ButonImpartireListener());
        m_view.addActionListenerDerivarePolinom1(new ButonDerivarePolinom1Listener());
        m_view.addActionListenerIntegrarePolinom1(new ButonIntegrarePolinom1Listener());
        m_view.addActionListenerDerivarePolinom2(new ButonDerivarePolinom2Listener());
        m_view.addActionListenerIntegrarePolinom2(new ButonIntegrarePolinom2Listener());
    }


    class ButonAdunareListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom p2=new Polinom(m_view.getTextPolinom2());
                Polinom rezultat=m_model.adunare(p1,p2);
                m_view.setRezultat("Suma: \n"+rezultat.afisarePolinom());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

    class ButonScadereeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom p2=new Polinom(m_view.getTextPolinom2());
                Polinom rezultat=m_model.scadere(p1,p2);
                m_view.setRezultat("Diferenta: \n"+rezultat.afisarePolinom());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

    class ButonInmultireListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom p2=new Polinom(m_view.getTextPolinom2());
                //if(p1.)
                Polinom rezultat=m_model.inmultire(p1,p2);
                m_view.setRezultat("Produsul: \n"+rezultat.afisarePolinom());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

    class ButonImpartireListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom p2=new Polinom(m_view.getTextPolinom2());
                if((p1.getListaMonoame().get(0).getGrad()==0 && p1.getListaMonoame().get(0).getCoeficient()==0) && (p2.getListaMonoame().get(0).getGrad()==0 && p2.getListaMonoame().get(0).getCoeficient()==0))
                    throw new Exception("Nu se pot imparti doua polinoame de valoare 0!");
                else if ( p2.getListaMonoame().get(0).getGrad()==0 && p2.getListaMonoame().get(0).getCoeficient()==0)
                    throw new Exception("Nu se poate imparti un polinom la 0!");

                ArrayList<Monom> lista = new ArrayList<Monom>();
                Monom m = new Monom(0, 0);

                lista.add(m);
                Polinom rezultat = m_model.impartire(p1, p2, lista);
                lista = rezultat.getListaRest();
                Polinom rest = new Polinom(lista);
                String s = new String("Cat: \r\n" + rezultat.afisarePolinom() + "\r\n" + "Rest: \r\n" + rest.afisarePolinom());
                m_view.setRezultat(s);
                    //System.out.println(s);
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

    class ButonDerivarePolinom1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom rezultat=m_model.derivare(p1);
                m_view.setRezultat("Derivata polinomului 1: \n"+rezultat.afisarePolinom());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

    class ButonDerivarePolinom2Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p2=new Polinom(m_view.getTextPolinom2());
                Polinom rezultat=m_model.derivare(p2);
                m_view.setRezultat("Derivata polinomului 2: \n"+rezultat.afisarePolinom());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

    class ButonIntegrarePolinom2Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p2=new Polinom(m_view.getTextPolinom2());
                Polinom rezultat=m_model.integrare(p2);
                m_view.setRezultat("Integrala polinomului 2: \n"+rezultat.afisarePolinom());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

    class ButonIntegrarePolinom1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom rezultat=m_model.integrare(p1);
                m_view.setRezultat("Integrala polinomului 1: \n"+rezultat.afisarePolinom());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,e2.getMessage());
            }
        }
    }

}

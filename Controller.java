package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }


    class ButonAdunareListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom p2=new Polinom(m_view.getTextPolinom2());
                Polinom rezultat=m_model.adunare(p1,p2);
                m_view.setRezultat(rezultat.afisarePolinom());

            } catch (Exception e2) {
                System.err.println(e2.getMessage());
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
                m_view.setRezultat(rezultat.afisarePolinom());

            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
        }
    }

    class ButonInmultireListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {

                Polinom p1=new Polinom(m_view.getTextPolinom1());
                Polinom p2=new Polinom(m_view.getTextPolinom2());
                Polinom rezultat=m_model.inmultire(p1,p2);
                m_view.setRezultat(rezultat.afisarePolinom());

            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
        }
    }
}

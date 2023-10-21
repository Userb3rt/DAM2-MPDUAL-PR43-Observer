package main.java.com.project;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Entregues {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList productes;

    void addProducte(int id, String nom) {
        PR450Producte producte = new PR450Producte();
        producte.setId(id);
        producte.setNom(nom);
        productes.add(producte);
    }

    void removeProducte(int id) {
        for (int i = 0; i < productes.length; i++) {
            if (productes.get(i).getId == id) {
                productes.remove(i);
            }
        }
    }

    public ArrayList getProductes() {
        return productes;
    }

    public void setProductes(ArrayList productes) {
        this.productes = productes;
    }

}
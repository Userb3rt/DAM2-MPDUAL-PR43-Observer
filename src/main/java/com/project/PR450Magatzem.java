package main.java.com.project;

import java.util.ArrayList;

class InnerPR450Magatzem {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList productes;
    private int capacitat = 10;

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

    void removePropertyChangeListener() {
        
    }

    public ArrayList getProductes() {
        return productes;
    }

    public void setProductes(ArrayList productes) {
        this.productes = productes;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }
}
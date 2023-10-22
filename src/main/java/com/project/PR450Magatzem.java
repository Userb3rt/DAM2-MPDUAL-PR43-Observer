package com.project;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

class PR450Magatzem {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();
    private int capacitat = 10;

    void addProducte(PR450Producte producte) {
        capacitat--;
        productes.add(producte);
    }

    void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                capacitat++;
                llistaObservers.firePropertyChange("magatzemRemove", productes.get(i).getId(), capacitat);
                productes.remove(i);
            }
        }

    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    @Override
    public String toString() {
        String txt = "[ ";
        for (int i = 0; i < productes.size(); i++) {
            if (i == productes.size() - 1) {
                txt += productes.get(i).getId() + ": " + productes.get(i).getNom();
            } else {
                txt += productes.get(i).getId() + ": " + productes.get(i).getNom() + ", ";
            }
        }
        txt += " ]";
        return "Productes al magatzem: " + txt;
    }
}
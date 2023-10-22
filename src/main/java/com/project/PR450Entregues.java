package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Entregues {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();

    void addProducte(PR450Producte producte) {
        productes.add(producte);
        llistaObservers.firePropertyChange("entreguesAdd", null, producte.getId());
    }

    void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                llistaObservers.firePropertyChange("entreguesRemove", productes.get(i).getId(), false);
                productes.remove(i);
            }
        }
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }

    public void setProductes(ArrayList<PR450Producte> productes) {
        this.productes = productes;
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
        return "Productes per entregar: " + txt;
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public PropertyChangeSupport getLlistaObservers() {
        return llistaObservers;
    }

}
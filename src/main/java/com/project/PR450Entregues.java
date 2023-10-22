package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Entregues {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();

    void addProducte(PR450Producte producte) {
        productes.add(producte);
        // aqui salta el observador para otorgarnos el mensaje que hemos agragado un
        // producto.
        llistaObservers.firePropertyChange("entreguesAdd", null, producte.getId());
    }

    void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                // aqui salta el observador para otorgarnos el mensaje que hemos borrado un
                // producto.
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
    //Modificamos el toString para que se nos vea como en la práctica.
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
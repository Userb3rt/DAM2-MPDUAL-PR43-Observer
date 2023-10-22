package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PR450Producte {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private int id;
    private String nom;

    public PR450Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        llistaObservers.firePropertyChange("producteId", this.id, id);
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        llistaObservers.firePropertyChange("producteName", this.nom, nom);
        this.nom = nom;
    }

    public PropertyChangeSupport getLlistaObservers() {
        return llistaObservers;
    }

}

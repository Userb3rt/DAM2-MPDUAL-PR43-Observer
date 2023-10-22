package com.project;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {

    public static void main(String[] args) {

        PR450Producte p0 = new PR450Producte(0, "Llibre");
        PR450Producte p1 = new PR450Producte(1, "Llapis");
        /*
         * He cambiado Boli por Llapis ya que es el valor que
         * cambiaremos por Boli, si no, no habría cambio en la linea
         * 45.
         */
        PR450Producte p2 = new PR450Producte(2, "Rotulador");
        PR450Producte p3 = new PR450Producte(3, "Carpeta");
        PR450Producte p4 = new PR450Producte(4, "Motxilla");

        PR450Magatzem magatzem = new PR450Magatzem();
        PR450Entregues entregues = new PR450Entregues();

        // Aquí afegir els property listeners adequats
        PropertyChangeListener producteId = new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Producte ha canviat l'id de '%s' a '%s'\n", evt.getOldValue(), evt.getNewValue());
            }

        };

        PropertyChangeListener producteName = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Producte ha canviat el nom de '%s' a '%s'\n", evt.getOldValue(), evt.getNewValue());

            }
        };

        PropertyChangeListener magatzemAdd = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha afegit el producte amb id '%s' al magatzem, capacitat '%s'\n", evt.getOldValue(),
                        evt.getNewValue());

            }
        };

        PropertyChangeListener magatzemRemove = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha esborrat el producte am id '%s' del magatzem, capacitat '%s'\n",
                        evt.getOldValue(), evt.getNewValue());
                // Ahora en el iterador del for vamos a introducir en el arraylist de entregas
                // todos los productos que vayamos a borrar, porque mienras salto el observador,
                // tenemos la oportunidad para añadir en entregas, ya que dentro de la calse de
                // magatzem no podriamos hacer
                for (int i = 0; i < magatzem.getProductes().size(); i++) {
                    if (magatzem.getProductes().get(i).getId() == (int) evt.getOldValue()) {
                        entregues.addProducte(magatzem.getProductes().get(i));
                    }
                }

            }
        };
        // Con este segundo evento dentro de la llista de observadores de magazem
        // daremos enfasis que hemos movido los archivos
        PropertyChangeListener segundoevento = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha mogut el producte amb id '%s' del magatzem cap a entregues\n",
                        evt.getOldValue());

            }
        };

        PropertyChangeListener entreguesAdd = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha afegit el producte amb id '%s' a la llista d'entregues\n", evt.getNewValue());
            }
        };

        PropertyChangeListener entreguesRemove = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha entregat el producte amb id '%s'\n", evt.getOldValue());
            }
        };

        p0.addPropertyChangeListener("producteId", producteId);
        p0.addPropertyChangeListener("producteName", producteName);
        p1.addPropertyChangeListener("producteName", producteName);
        magatzem.addPropertyChangeListener("magatzemAdd", magatzemAdd);
        magatzem.addPropertyChangeListener("magatzemRemove", magatzemRemove);
        // Pordria haber imprimido el mensaje que me otorga este listener en
        // magatzemRemove pero queria probar lo del segundo evento
        magatzem.addPropertyChangeListener("magatzemRemove", segundoevento);
        entregues.addPropertyChangeListener("entreguesAdd", entreguesAdd);
        entregues.addPropertyChangeListener("entreguesRemove", entreguesRemove);

        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");

        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        entregues.removeProducte(2);
        entregues.removeProducte(3);

        System.out.println(magatzem);
        System.out.println(entregues);
    }
}
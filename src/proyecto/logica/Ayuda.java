/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logica;

/**
 *
 * @author DAM2Alu14
 */

import javax.help.HelpSet;
import javax.help.HelpBroker;
import java.net.URL;
import javax.help.BadIDException;
import javax.help.HelpSetException;

public class Ayuda {

    private HelpBroker helpBroker;

    public Ayuda() {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL hsURL = cl.getResource("help/gymhelp.hs");
            System.out.println("URL helpset: " + hsURL); // borra esta línea cuando funcione
            HelpSet hs = new HelpSet(cl, hsURL);
            helpBroker = hs.createHelpBroker();
        } catch (HelpSetException e) {
            System.out.println("Error cargando la ayuda: " + e.getMessage());
        }
    }

    public void mostrarAyuda(String tema) {
        if (helpBroker != null) {
            try {
                helpBroker.setCurrentID(tema);
            } catch (BadIDException e) {
                // si el tema no existe, muestra la página de inicio igualmente
            }
            helpBroker.setDisplayed(true);
        }
    }

    public void mostrarAyuda() {
        if (helpBroker != null) {
            helpBroker.setDisplayed(true);
        }
    }
}
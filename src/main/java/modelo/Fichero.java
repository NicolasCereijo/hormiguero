package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**@author Nicolás Cereijo Ranchal*/
public class Fichero implements Serializable {
    private File ficheroCrear;
    private static File output;
    private final AtomicInteger numeroMensaje;
    
    /**Constructor sin parametros*/
    public Fichero() {
        ficheroCrear = new File("evolucionColonia.txt");                                 
        output = new File("evolucionColonia.txt");
					
        if (ficheroCrear.exists()) {
            ficheroCrear.delete();

            try {
                ficheroCrear.createNewFile();
            } catch (IOException ex) {
                System.out.format("s", "Error al crear el fichero\n");
            }
        }
        
        numeroMensaje = new AtomicInteger(0);
    }
    
    public synchronized void escribirFichero(String cadena) {
        try {
            FileWriter writer = new FileWriter(output, true);
            writer.write(cadena);
            writer.flush();
            numeroMensaje.addAndGet(1);
        } catch (IOException ex) {
            System.out.format("s", "Error al escribir en el fichero\n");
        }
    }
    
    public void verFichero() {                  
        Desktop desktop = Desktop.getDesktop();
        if(ficheroCrear.exists()) try {
            desktop.open(ficheroCrear);
        } catch (IOException ex) {
            System.out.format("s", "Error al mostrar el fichero\n");
        }
    }
    
    public int getNumeroMensaje() {
        return numeroMensaje.get();
    }
}
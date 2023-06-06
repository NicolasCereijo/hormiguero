package modelo.hormigas;

import control.ControlHormiguero;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import modelo.Fichero;
import modelo.Porcentaje;

/**@author Nicolás Cereijo Ranchal*/
public class Reina extends Thread {
    private Porcentaje porcentaje;
    private Cria princesa;
    private Soldado general;
    
    /**Constructor sin parametros*/
    public Reina() {}
    
    public Porcentaje getPorcentaje() {
        return porcentaje;
    }
    
    public Cria getPrincesa() {
        return princesa;
    }
    
    @Override
    public void run() {
        Random tiempo = new Random();
        Fichero f = new Fichero();
        ControlHormiguero controlHormiguero = new ControlHormiguero(f);
        
        porcentaje = new Porcentaje(controlHormiguero.getVentanaHormiguero());
        porcentaje.start();
        princesa = new Cria(controlHormiguero.getVentanaHormiguero());
        princesa.start();
        general = new Soldado(controlHormiguero.getVentanaHormiguero());
        general.start();
        
        for(int i = 0, j = 0; i < 2000; i++) {
            for(int k = 0; k < 5; k++) {
                switch (k) {
                    case 3 -> {
                        Soldado s = new Soldado("HS", j++, controlHormiguero.getVentanaHormiguero());
                        s.start();
                        
                        controlHormiguero.getVentanaHormiguero().setNumeroSoldados();
                        if(!controlHormiguero.getVentanaHormiguero().getInvasion())
                            controlHormiguero.getVentanaHormiguero().setHormigaPreviaInvasion(j);
                    }
                    case 4 -> {
                        Cria c = new Cria("HC", j++, controlHormiguero.getVentanaHormiguero());
                        c.start();
                    }
                    default -> {
                        Obrera o = new Obrera("HO", j++, controlHormiguero.getVentanaHormiguero());
                        o.start();
                    }
                }
                
                try {
                    TimeUnit.MILLISECONDS.sleep(tiempo.nextInt(800, 3501));
                } catch (InterruptedException ex) {
                    System.out.format("s", "Error en la creación de hormigas, vuelta: " + i + "\n");
                }
            }
        }
    }
}

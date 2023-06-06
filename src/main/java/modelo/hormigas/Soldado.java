package modelo.hormigas;

import java.util.Random;
import vista.VentanaHormiguero;

/**@author Nicolás Cereijo Ranchal*/
public class Soldado extends Hormiga {
    
    /**Construtor para el general
     * @param hormiguero*/
    public Soldado(VentanaHormiguero hormiguero) {
        super(hormiguero);
    }
    
    /**Constructor para los soldados
     * @param tipo
     * @param id
     * @param hormiguero*/
    public Soldado(String tipo, int id, VentanaHormiguero hormiguero) {
        super(tipo, id, hormiguero);
    }
    
    @Override
    public void run() {
        //Camino de ejecución del general
        if(id == -1) {
            int tiempoMaximo = 0;
            
            while(true) {
                esperar(1000);

                if(!hormiguero.getInvasion())
                    hormiguero.despertarInvasion();
                else {
                    if(hormiguero.getSoldadosQuePelean() == hormiguero.getSoldadosPeleando() || tiempoMaximo > 60) {
                        esperar(20000);
                        hormiguero.setInvasion(false);
                        tiempoMaximo = 0;
                        hormiguero.getBtnNewButton_5().setText("Generar bicho");
                    } else
                        tiempoMaximo++;
                }
            }
        //Camino de ejecución de los soldados
        } else {
            Random tiempo = new Random();
            hormiguero.nuevaHormiga(this);

            while(true) {
                for(int i = 0; i < 6; i++) {
                    hormiguero.entrarCuartel(this);
                    esperar((tiempo.nextInt(6) + 2) * 1000);
                    hormiguero.salirCuartel(this);
                    hormiguero.entrarDormitorio(this, true);
                    esperar(2000);
                    hormiguero.salirDormitorio(this);
                }

                hormiguero.entrarComedor(this, true);
                esperar(3000);
                hormiguero.eliminarComidaComedor(this);
                hormiguero.salirComedor(this);
            }
        }
    }
}

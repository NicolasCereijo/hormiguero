package modelo.hormigas;

import java.util.Random;
import vista.VentanaHormiguero;

/**@author Nicolás Cereijo Ranchal*/
public class Cria extends Hormiga {
    
    /**Constructor para la princesa
     * @param hormiguero*/
    public Cria(VentanaHormiguero hormiguero) {
        super(hormiguero);
    }
    
    /**Contructor para las crias
     * @param tipo
     * @param id
     * @param hormiguero*/
    public Cria(String tipo, int id, VentanaHormiguero hormiguero) {
        super(tipo, id, hormiguero);
    }
    
    @Override
    public void run() {
        //Camino de ejecución de la princesa
        if(id == -1) {
            while(true) {
                this.esperar(1000);
                
                if(!hormiguero.getPausa())
                    hormiguero.despertarPausa();
            }
        //Camino de ejecución de las crias
        } else {
            Random tiempo = new Random();
            hormiguero.nuevaHormiga(this);
            hormiguero.comprobarInvasion(this);

            while(true) {
                hormiguero.entrarComedor(this, true);
                esperar((tiempo.nextInt(2) + 3) * 1000);
                hormiguero.eliminarComidaComedor(this);
                hormiguero.salirComedor(this);
                hormiguero.entrarDormitorio(this, true);
                esperar(4000);
                hormiguero.salirDormitorio(this);
            }
        }
    }
}

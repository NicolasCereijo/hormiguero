package modelo.hormigas;

import java.util.Random;
import vista.VentanaHormiguero;

/**@author Nicolás Cereijo Ranchal*/
public class Obrera extends Hormiga {
    private final boolean par;
    
    /**Constructor para las obreras
     * @param tipo
     * @param id
     * @param hormiguero*/
    public Obrera(String tipo, int id, VentanaHormiguero hormiguero) {
        super(tipo, id, hormiguero);
        par = (id%2 == 0);
    }
    
    @Override
    public void run() {
        Random tiempo = new Random();
        hormiguero.nuevaHormiga(this);
        
        while(true) {
            if(par) {
                for(int i = 0; i < 10; i++) {
                    
                    if(hormiguero.visitarAlmacen(this, (tiempo.nextInt(1) + 1) * 1000, false)) {
                        setNota(" (en camino)");
                        hormiguero.entrarComedor(this, false);
                        esperar((tiempo.nextInt(2) + 1) * 1000);
                        hormiguero.salirComedor(this);
                        setNota("");
                        hormiguero.entrarComedor(this, false);
                        esperar((tiempo.nextInt(1) + 1) * 1000);
                        hormiguero.insertarComidaComedor();
                        hormiguero.salirComedor(this);
                    } else {
                        this.esperar(10000);
                    }
                }
            } else {
                for(int i = 0; i < 10; i++) {
                    hormiguero.entrarExterior(this, false);
                    esperar(4000);
                    hormiguero.salirExterior(this);
                    hormiguero.visitarAlmacen(this, (tiempo.nextInt(2) + 2) * 1000, true);
                }
            }
            
            hormiguero.entrarComedor(this, false);
            esperar(3000);
            hormiguero.eliminarComidaComedor(this);
            hormiguero.salirComedor(this);
            hormiguero.entrarDormitorio(this, false);
            esperar(1000);
            hormiguero.salirDormitorio(this);
        }
    }
}

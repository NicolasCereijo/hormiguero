package modelo;

import java.util.concurrent.TimeUnit;
import vista.ListaHormigas;
import vista.VentanaHormiguero;

/**@author Nicolás Cereijo Ranchal*/
public class Porcentaje extends Thread {
    private final VentanaHormiguero hormiguero;
    private int obrerasExterior;
    private int obrerasInterior;
    private int soldadosEntrenando;
    private int soldadosPeleando;
    private int criasComiendo;
    private int criasRefugiadas;
    
    /**Constructor con parametros
     * @param hormiguero*/
    public Porcentaje(VentanaHormiguero hormiguero) {
        this.hormiguero = hormiguero;
    }
    
    public void calcularPorcentaje(ListaHormigas lista, int zona) {
        String[] copia = lista.getElementos();
        int hObreras = 0, hSoldado = 0, hCrias = 0, contarObrerasInt = 0,
                porcentajeObreras = 0, porcentajeSoldado = 0, porcentajeCrias = 0, total;
        
        if(copia != null) {
            for (String elemento : copia) {
                if (elemento != null) {
                    if (elemento.contains("HO")) {
                        hObreras++;
                    } else if (elemento.contains("HS")) {
                        hSoldado++;
                    } else {
                        hCrias++;
                    }
                }
            }
        }
        
        total = hObreras + hSoldado + hCrias;
        if(hObreras != 0)
            porcentajeObreras = (hObreras * 100) / total;
        if(hSoldado != 0)
            porcentajeSoldado = (hSoldado * 100) / total;
        if(hCrias != 0)
            porcentajeCrias = (hCrias * 100) / total;
        
        switch(zona) {
            case 0 -> {
                hormiguero.porcentajeObrerasRefugio(porcentajeObreras);
                hormiguero.porcentajeSoldadoRefugio(porcentajeSoldado);
                hormiguero.porcentajeCriasRefugio(porcentajeCrias);
                
                contarObrerasInt = 0;
                criasRefugiadas = hCrias;
            }
            case 1 -> {
                hormiguero.porcentajeObrerasDormitorio(porcentajeObreras);
                hormiguero.porcentajeSoldadoDormitorio(porcentajeSoldado);
                hormiguero.porcentajeCriasDormitorio(porcentajeCrias);
                
                contarObrerasInt += hObreras;
            }
            case 2 -> {
                hormiguero.porcentajeObrerasComedor(porcentajeObreras);
                hormiguero.porcentajeSoldadoComedor(porcentajeSoldado);
                hormiguero.porcentajeCriasComedor(porcentajeCrias);
                
                contarObrerasInt += hObreras;
                criasComiendo = hCrias;
            }
            case 3 -> {
                hormiguero.porcentajeObrerasCuartel(porcentajeObreras);
                hormiguero.porcentajeSoldadoCuartel(porcentajeSoldado);
                hormiguero.porcentajeCriasCuartel(porcentajeCrias);
                
                soldadosEntrenando = hSoldado;
            }
            case 4 -> {
                hormiguero.porcentajeObrerasAlmacen(porcentajeObreras);
                hormiguero.porcentajeSoldadoAlmacen(porcentajeSoldado);
                hormiguero.porcentajeCriasAlmacen(porcentajeCrias);
                
                contarObrerasInt += hObreras;
                obrerasInterior = contarObrerasInt;
            }
            case 5 -> {
                hormiguero.porcentajeObrerasExterior(porcentajeObreras);
                hormiguero.porcentajeSoldadoExterior(porcentajeSoldado);
                hormiguero.porcentajeCriasExterior(porcentajeCrias);
                
                obrerasExterior = hObreras;
                soldadosPeleando = hSoldado;
            }
        }
    }
    
    public int getObrerasExterior() {
        return obrerasExterior;
    }
    
    public int getObrerasInterior() {
        return obrerasInterior;
    }
    
    public int getSoldadosEntrenando() {
        return soldadosEntrenando;
    }
    
    public int getSoldadosPeleando() {
        return soldadosPeleando;
    }
    
    public int getCriasComiendo() {
        return criasComiendo;
    }
    
    public int getCriasRefugiadas() {
        return criasRefugiadas;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                System.out.format("%s", "Error en la espera de los porcentajes\n");
            }
            
            calcularPorcentaje(hormiguero.getRefugio(), 0);
            calcularPorcentaje(hormiguero.getDormitorio(), 1);
            calcularPorcentaje(hormiguero.getComedor(), 2);
            calcularPorcentaje(hormiguero.getCuartel(), 3);
            calcularPorcentaje(hormiguero.getAlmacen(), 4);
            calcularPorcentaje(hormiguero.getExterior(), 5);
        }
    }
}

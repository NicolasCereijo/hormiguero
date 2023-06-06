package control;

import java.awt.event.ActionEvent;
import modelo.Fichero;
import vista.VentanaHormiguero;

/**@author Nicolás Cereijo Ranchal*/
public class ControlHormiguero {
    private static VentanaHormiguero hormiguero;
    
    /**Constructor con parametros
     * @param f*/
    public ControlHormiguero(Fichero f) {
        hormiguero = new VentanaHormiguero(f);
        hormiguero.getBtnNewButton_1().addActionListener((ActionEvent evento) -> {
            if(hormiguero.getPausa()) {
                hormiguero.setPausa(false);
                hormiguero.getBtnNewButton_1().setText("Pausar");
            } else {
                hormiguero.setPausa(true);
                hormiguero.getBtnNewButton_1().setText("Reanudar");
            }
        });
        hormiguero.getBtnNewButton_2().addActionListener((ActionEvent evento) -> {
            hormiguero.getFichero().verFichero();
        });
        hormiguero.getBtnNewButton_3().addActionListener((ActionEvent evento) -> {
            hormiguero.seguirHormiga();
        });
        hormiguero.getBtnNewButton_5().addActionListener((ActionEvent evento) -> {
            if(!hormiguero.getInvasion()) {
                hormiguero.setInvasion(true);
                hormiguero.getBtnNewButton_5().setText("Invasion en curso");
            }
        });
        hormiguero.setVisible(true);
    }
    
    public VentanaHormiguero getVentanaHormiguero() {
        return hormiguero;
    }
}

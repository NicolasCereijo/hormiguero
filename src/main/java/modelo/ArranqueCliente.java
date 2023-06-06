package modelo;

import control.ControlCliente;

/**@author Nicolás Cereijo Ranchal*/
public class ArranqueCliente {
    public static void main(String[] args) {
        ControlCliente controlCliente = new ControlCliente();
        controlCliente.getCliente().setVisible(true);
        int dato;
        
        while(true) {
            for(int i = 1; i < 7; i++) {
                dato = controlCliente.iniciarConexion(Integer.toString(i));
                
                switch(i) {
                    case 1 -> controlCliente.getCliente().setTextField_1(Integer.toString(dato));
                    case 2 -> controlCliente.getCliente().setTextField_2(Integer.toString(dato));
                    case 3 -> controlCliente.getCliente().setTextField_6(Integer.toString(dato));
                    case 4 -> controlCliente.getCliente().setTextField_3(Integer.toString(dato));
                    case 5 -> controlCliente.getCliente().setTextField_4(Integer.toString(dato));
                    case 6 -> controlCliente.getCliente().setTextField_5(Integer.toString(dato));
                }
            }
            
            if(controlCliente.getEnviarInvasion()) {
                controlCliente.iniciarConexion("atacar");
                controlCliente.setEnviarInvasion(false);
            }
        }
    }
}

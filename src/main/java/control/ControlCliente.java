package control;

import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import vista.VentanaCliente;

/**@author Nicolás Cereijo Ranchal*/
public class ControlCliente {
    private final VentanaCliente cliente;
    private boolean enviarInvasion;
    
    /**Constructor sin parámetros*/
    public ControlCliente() {
        this.cliente = new VentanaCliente();
        
        this.cliente.getBtnNewButton_1().addActionListener((ActionEvent evento) -> {
            enviarInvasion = true;
        });
    }
    
    public int iniciarConexion(String peticion) {
        int datos = 0;
        Socket puertoCliente;
        DataInputStream entrada;
        DataOutputStream salida;
        
        try {
            puertoCliente = new Socket(InetAddress.getLocalHost(), 5000);
            entrada = new DataInputStream(puertoCliente.getInputStream());
            salida = new DataOutputStream(puertoCliente.getOutputStream());
            salida.writeUTF(peticion);
            datos = entrada.readInt();
            
            puertoCliente.close();
        } catch(IOException ex) {
            System.out.format("s", "Error al establecer la conexión\n");
        }
        
        return datos;
    }
    
    public VentanaCliente getCliente() {
        return cliente;
    }
    
    public boolean getEnviarInvasion() {
        return enviarInvasion;
    }
    
    public void setEnviarInvasion(boolean b) {
        enviarInvasion = b;
    }
}
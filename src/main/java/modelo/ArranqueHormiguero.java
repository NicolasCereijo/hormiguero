package modelo;

import com.initech.tps.LoggingExceptionHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import modelo.hormigas.Reina;

/**@author Nicolás Cereijo Ranchal*/
public class ArranqueHormiguero {
    public static void main(String[] args) {
        ServerSocket servidor;
        Socket conexion;
        DataInputStream entrada;
        DataOutputStream salida;
        String peticion;
        int respuesta = 0;
        
        Reina reina = new Reina();
        reina.start();
        
        Thread.setDefaultUncaughtExceptionHandler(new LoggingExceptionHandler());
        System.setProperty("sun.awt.exception.handler", LoggingExceptionHandler.class.getName());
        
        while(true) {
            try {
                servidor = new ServerSocket(5000);
                conexion = servidor.accept();

                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());

                peticion = entrada.readUTF();
                
                switch (peticion) {
                    case "1" -> {
                        respuesta = reina.getPorcentaje().getObrerasExterior();
                    }
                    
                    case "2" -> {
                        respuesta = reina.getPorcentaje().getObrerasInterior();
                    }
                    
                    case "3" -> {
                        respuesta = reina.getPorcentaje().getSoldadosEntrenando();
                    }
                    
                    case "4" -> {
                        respuesta = reina.getPorcentaje().getSoldadosPeleando();
                    }
                    
                    case "5" -> {
                        respuesta = reina.getPorcentaje().getCriasComiendo();
                    }
                    
                    case "6" -> {
                        respuesta = reina.getPorcentaje().getCriasRefugiadas();
                    }
                    
                    case "atacar" -> {
                        if(!reina.getPrincesa().getHormiguero().getInvasion()) {
                            reina.getPrincesa().getHormiguero().setInvasion(true);
                            reina.getPrincesa().getHormiguero().getBtnNewButton_5().setText("Invasion en curso");
                        }
                    }
                }
                salida.writeInt(respuesta);

                conexion.close();
                servidor.close();
            } catch (IOException ex){}
        }
    }
}

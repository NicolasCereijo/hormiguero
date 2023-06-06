package modelo.hormigas;

import vista.VentanaHormiguero;

/**@author Nicolás Cereijo Ranchal*/
public abstract class Hormiga extends Thread {
    protected final String tipo;
    protected final int id;
    protected String extension;
    protected String nota;
    protected int color;
    protected final VentanaHormiguero hormiguero;
    
    /**Constructor con parametros (hormigas especiales)
     * @param hormiguero*/
    public Hormiga(VentanaHormiguero hormiguero) {
        tipo = "";
        id = -1;
        extension = "";
        nota = "";
        color = -1;
        this.hormiguero = hormiguero;
    }
    
    /**Constructor con parametros (hormigas normales)
     * @param tipo
     * @param id
     * @param hormiguero*/
    public Hormiga(String tipo, int id, VentanaHormiguero hormiguero) {
        this.tipo = tipo;
        this.id = id;
        
        if(id < 10)
            extension = "000";
        else if(id < 100)
            extension = "00";
        else
            extension = "0";
        
        nota = "";
        
        elegirColor();
        this.hormiguero = hormiguero;
    }
    
    public void elegirColor() {
        color = switch (tipo) {
            case "HO" -> 0;
            case "HS" -> 1;
            //El 2 reservado para seguir hormigas
            default -> 3;
        };
    }
    
    public void esperar(int tiempo) {
        try {
            //Ni la princesa ni el general se pausan nunca, ellos despiertan al resto
            if(this.getID() != -1) {
                hormiguero.comprobarPausa(this);
                hormiguero.comprobarInvasion(this);
            }
            sleep(tiempo);
        } catch (InterruptedException ex) {
            System.out.format("%s", "Error al poner en espera a la hormiga " + tipo + " " + id + "\n");
        }
    }
    
    public synchronized void dormir() {
        try {
            this.wait();
        } catch (InterruptedException ex) {
            System.out.format("%s", "Error al dormir a la hormiga " + tipo + " " + id + "\n");
        }
    }
    
    public synchronized void despertar() {
        this.notify();
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public int getID() {
        return id;
    }
    
    public String getNombre() {
        return tipo + extension + id + nota;
    }
    
    public int getColor() {
        return color;
    }
    
    public VentanaHormiguero getHormiguero() {
        return hormiguero;
    }
    
    public void setColor(int c) {
        color = c;
    }
    
    public void setNota(String n) {
        nota = n;
    }
    
    @Override
    public abstract void run();
}

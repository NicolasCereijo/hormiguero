package vista;

import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Date;
import modelo.Fichero;
import modelo.hormigas.Hormiga;

/**@author Nicolás Cereijo Ranchal*/
public class ListaHormigas {
    private String[] elementos;
    private final int aforo;
    private final ArrayList<Color> colores;
    private JList<?> lista;

    /**Constructor con parámetros
     * @param aforo*/
    public ListaHormigas(int aforo) {
        elementos = new String[0];
        
        if(aforo != 0)
            this.aforo = aforo;
        else
            this.aforo = 0;
        
        colores = new ArrayList();
        
        actualizarLista();
    }

    private synchronized void actualizarLista() {
        lista = new JList<>(elementos);
        lista.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            return new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                    for (int i = 0; i < colores.size(); i++) {
                        if (index == i) {
                            setForeground(colores.get(i));
                        }
                    }

                    return this;
                }
            }.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        });
    }
    
    public int seleccionarHormiga() {
        return lista.getSelectedIndex();
    }

    public synchronized int buscarElemento(String nombre) {
        if(elementos != null) {
            for(int i = 0; i< elementos.length; i++) {
                if(elementos[i] != null) {
                    if(elementos[i].equalsIgnoreCase(nombre))
                        return i;
                }
            }
        }
        return -1;
    }

    public synchronized void insertarElemento(Hormiga hormiga, Fichero f, String lugar) {
        hormiga.getHormiguero().comprobarPausa(hormiga);
        
        if(!(aforo != 0 && !(elementos.length < aforo))) {
            String[] copia = elementos;
            elementos = new String[elementos.length + 1];
            String accion = " accede a ";

            if(hormiga.getNombre().contains("camino"))
                accion = " se dirige a ";
            String cadena = f.getNumeroMensaje() + " [Tiempo de la máquina: " + (new Date()).getTime() +
                    " milisegundos] La hormiga " + hormiga.getNombre().subSequence(0, 6) + accion + lugar + "\n";

            f.escribirFichero(cadena);
            System.out.format("%s", cadena);

            for(int i = 0; i < copia.length; i++) {
                if(i < elementos.length && i < copia.length)
                    elementos[i] = copia[i];
            }
            elementos[elementos.length - 1] = hormiga.getNombre();

            switch(hormiga.getColor()) {
                case 0 -> colores.add(Color.blue);
                case 1 -> colores.add(Color.red);
                case 2 -> colores.add(Color.magenta);
                default -> colores.add(Color.green);
            }

            actualizarLista();
        }
    }

    public synchronized boolean eliminarElemento(Hormiga h) {
        int posicion = buscarElemento(h.getNombre());
        
        if(posicion != -1 && elementos.length > posicion) {
            String[] copia = elementos;

            copia[posicion] = null;
            elementos = new String[elementos.length - 1];

            for(int i = 0, j = 0; i < elementos.length; i++, j++) {
                if(i < copia.length) {
                    if(copia[i] == null)
                        j++;
                }
                
                if(j < copia.length)
                    elementos[i] = copia[j];
            }

            if(posicion < colores.size())
                colores.remove(posicion);
        }

        actualizarLista();
        return posicion != -1;
    }

    public JList<?> getLista() {
        return lista;
    }
    
    public String[] getElementos() {
        return elementos;
    }
}
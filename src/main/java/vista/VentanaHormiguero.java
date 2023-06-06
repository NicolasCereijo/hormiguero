package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.SwingConstants;
import modelo.Fichero;
import modelo.hormigas.Hormiga;

/**@author Nicolás Cereijo Ranchal*/
public class VentanaHormiguero extends JFrame {
    /**Código para la serialización*/
    private static final long serialVersionUID = 1L;
    /**Contenedor general*/
    private final JPanel contentPane;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_1;
    /**Separador de elementos*/
    private final JSeparator separator_1;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_2;
    /**Lista formateada*/
    private final ListaHormigas refugio;
    /**Coordenadas de la lista*/
    private final int[] coordRefugio = {10, 55, 150, 550};
    /**Barra de progreso*/
    private final JProgressBar progressBar_1;
    /**Barra de progreso*/
    private final JProgressBar progressBar_2;
    /**Barra de progreso*/
    private final JProgressBar progressBar_3;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_3;
    /**Lista formateada*/
    private final ListaHormigas dormitorio;
    /**Coordenadas de la lista*/
    private final int[] coordDormitorio = {170, 55, 150, 550};
    /**Barra de progreso*/
    private final JProgressBar progressBar_4;
    /**Barra de progreso*/
    private final JProgressBar progressBar_5;
    /**Barra de progreso*/
    private final JProgressBar progressBar_6;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_4;
    /**Lista formateada*/
    private final ListaHormigas comedor;
    /**Coordenadas de la lista*/
    private final int[] coordComedor = {330, 55, 150, 550};
    /**Barra de progreso*/
    private final JProgressBar progressBar_7;
    /**Barra de progreso*/
    private final JProgressBar progressBar_8;
    /**Barra de progreso*/
    private final JProgressBar progressBar_9;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_5;
    /**Lista formateada*/
    private final ListaHormigas cuartel;
    /**Coordenadas de la lista*/
    private final int[] coordCuartel = {490, 55, 150, 550};
    /**Barra de progreso*/
    private final JProgressBar progressBar_10;
    /**Barra de progreso*/
    private final JProgressBar progressBar_11;
    /**Barra de progreso*/
    private final JProgressBar progressBar_12;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_6;
    /**Lista formateada*/
    private final ListaHormigas almacen;
    /**Semaforo para controlar el aforo del almacen*/
    private final Semaphore aforoAlmacen;
    /**Coordenadas de la lista*/
    private final int[] coordAlmacen = {650, 55, 150, 200};
    /**Barra de progreso*/
    private final JProgressBar progressBar_13;
    /**Barra de progreso*/
    private final JProgressBar progressBar_14;
    /**Barra de progreso*/
    private final JProgressBar progressBar_15;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_7;
    /**Lista formateada*/
    private final ListaHormigas exterior;
    /**Coordenadas de la lista*/
    private final int[] coordExterior = {810, 55, 150, 550};
    /**Barra de progreso*/
    private final JProgressBar progressBar_16;
    /**Barra de progreso*/
    private final JProgressBar progressBar_17;
    /**Barra de progreso*/
    private final JProgressBar progressBar_18;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_8;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_9;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_10;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_11;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_12;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_13;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_14;
    /**Botón de ejecución*/
    private final JButton btnNewButton_1;
    /**Botón de ejecución*/
    private final JButton btnNewButton_2;
    /**Botón de ejecución*/
    private final JButton btnNewButton_3;
    /**Botón de ejecución*/
    private final JButton btnNewButton_5;
    /**Comida en el almacen*/
    private final AtomicInteger comidaAlmacen;
    /**Lock de acceso a la comida del almacen*/
    private final ReentrantLock accesoComidaAlmacen;
    /**Cola de espera para acceder a la comida del almacen*/
    private final ArrayList<Hormiga> colaAlmacen;
    /**Comida en el comedor*/
    private final AtomicInteger comidaComedor;
    /**Lock de acceso a la comida del comedor*/
    private final ReentrantLock accesoComidaComedor;
    /**Cola de espera para acceder a la comida del comedor*/
    private final ArrayList<Hormiga> colaComedor;
    /**Bandera para la pausa del programa*/
    private boolean pausa;
    /**Monitor para la pausa del programa*/
    private final Object monitorPausa;
    /**Hilo en seguimiento*/
    private Hormiga hormigaSeguida;
    /**Total de hormigas en el sistema*/
    private final ArrayList<Hormiga> totalHormigas;
    /**Bandera para la invasion del insecto*/
    private boolean invasion;
    /**Monitor para la invasion del insecto*/
    private final Object monitorInsecto;
    /**Cantidad de soldados que saldran a pelear*/
    private int soldadosQuePelean;
    /**Cantidad de soldados que estan esperando para pelear*/
    private final AtomicInteger soldadosPeleando;
    /**Ultima hormiga creada antes de la invasion*/
    private int hormigaPreviaInvasion;
    /**Fichero para el log del programa*/
    private final Fichero fichero;
    
    /**Constructor con parámetros
     * @param fichero*/
    public VentanaHormiguero(Fichero fichero) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 985, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel_1 = new JLabel("Hormiguero con sus cinco zonas más el exterior de la colonia");
        lblNewLabel_1.setBounds(10, 10, 950, 13);
        contentPane.add(lblNewLabel_1);
        
        separator_1 = new JSeparator(JSeparator.HORIZONTAL);
        separator_1.setBounds(10, 25, 950, 2);
        contentPane.add(separator_1);
        
        //Inicio de los elementos del refugio
        lblNewLabel_2 = new JLabel("Refugio");
        lblNewLabel_2.setBounds(10, 33, 150, 13);
        contentPane.add(lblNewLabel_2);
		
        refugio = new ListaHormigas(0);
        refugio.getLista().setBounds(coordRefugio[0], coordRefugio[1], coordRefugio[2], coordRefugio[3]);
        contentPane.add(refugio.getLista());

        progressBar_1 = new JProgressBar();
        progressBar_1.setBounds(10, 620, 150, 10);
        progressBar_1.setValue(0);
        progressBar_1.setForeground(Color.blue);
        contentPane.add(progressBar_1);

        progressBar_2 = new JProgressBar();
        progressBar_2.setBounds(10, 640, 150, 10);
        progressBar_2.setValue(0);
        progressBar_2.setForeground(Color.red);
        contentPane.add(progressBar_2);

        progressBar_3 = new JProgressBar();
        progressBar_3.setBounds(10, 660, 150, 10);
        progressBar_3.setValue(0);
        progressBar_3.setForeground(Color.green);
        contentPane.add(progressBar_3);
        //Fin de los elementos del refugio
		
        //Inicio de los elementos del dormitorio
        lblNewLabel_3 = new JLabel("Dormitorio");
        lblNewLabel_3.setBounds(170, 33, 150, 13);
        contentPane.add(lblNewLabel_3);
		
        dormitorio = new ListaHormigas(0);
        dormitorio.getLista().setBounds(coordDormitorio[0], coordDormitorio[1], coordDormitorio[2], coordDormitorio[3]);
        contentPane.add(dormitorio.getLista());

        progressBar_4 = new JProgressBar();
        progressBar_4.setBounds(170, 620, 150, 10);
        progressBar_4.setValue(0);
        progressBar_4.setForeground(Color.blue);
        contentPane.add(progressBar_4);

        progressBar_5 = new JProgressBar();
        progressBar_5.setBounds(170, 640, 150, 10);
        progressBar_5.setValue(0);
        progressBar_5.setForeground(Color.red);
        contentPane.add(progressBar_5);

        progressBar_6 = new JProgressBar();
        progressBar_6.setBounds(170, 660, 150, 10);
        progressBar_6.setValue(0);
        progressBar_6.setForeground(Color.green);
        contentPane.add(progressBar_6);
        //Fin de los elementos del dormitorio

        //Inicio de los elementos del comedor
        lblNewLabel_4 = new JLabel("Comedor");
        lblNewLabel_4.setBounds(330, 33, 150, 13);
        contentPane.add(lblNewLabel_4);
		
        comedor = new ListaHormigas(0);
        comedor.getLista().setBounds(coordComedor[0], coordComedor[1], coordComedor[2], coordComedor[3]);
        contentPane.add(comedor.getLista());

        progressBar_7 = new JProgressBar();
        progressBar_7.setBounds(330, 620, 150, 10);
        progressBar_7.setValue(0);
        progressBar_7.setForeground(Color.blue);
        contentPane.add(progressBar_7);

        progressBar_8 = new JProgressBar();
        progressBar_8.setBounds(330, 640, 150, 10);
        progressBar_8.setValue(0);
        progressBar_8.setForeground(Color.red);
        contentPane.add(progressBar_8);

        progressBar_9 = new JProgressBar();
        progressBar_9.setBounds(330, 660, 150, 10);
        progressBar_9.setValue(0);
        progressBar_9.setForeground(Color.green);
        contentPane.add(progressBar_9);
        //Fin de los elementos del comedor

        //Inicio de los elementos del cuartel
        lblNewLabel_5 = new JLabel("Cuartel");
        lblNewLabel_5.setBounds(490, 33, 150, 13);
        contentPane.add(lblNewLabel_5);
		
        cuartel = new ListaHormigas(0);
        cuartel.getLista().setBounds(coordCuartel[0], coordCuartel[1], coordCuartel[2], coordCuartel[3]);
        contentPane.add(cuartel.getLista());

        progressBar_10 = new JProgressBar();
        progressBar_10.setBounds(490, 620, 150, 10);
        progressBar_10.setValue(0);
        progressBar_10.setForeground(Color.blue);
        contentPane.add(progressBar_10);

        progressBar_11 = new JProgressBar();
        progressBar_11.setBounds(490, 640, 150, 10);
        progressBar_11.setValue(0);
        progressBar_11.setForeground(Color.red);
        contentPane.add(progressBar_11);

        progressBar_12 = new JProgressBar();
        progressBar_12.setBounds(490, 660, 150, 10);
        progressBar_12.setValue(0);
        progressBar_12.setForeground(Color.green);
        contentPane.add(progressBar_12);
        //Fin de los elementos del cuartel

        //Inicio de los elementos del almacen
        lblNewLabel_6 = new JLabel("Almacen");
        lblNewLabel_6.setBounds(650, 33, 150, 13);
        contentPane.add(lblNewLabel_6);
		
        almacen = new ListaHormigas(10);
        almacen.getLista().setBounds(coordAlmacen[0], coordAlmacen[1], coordAlmacen[2], coordAlmacen[3]);
        contentPane.add(almacen.getLista());
        aforoAlmacen = new Semaphore(10, true);

        progressBar_13 = new JProgressBar();
        progressBar_13.setBounds(650, 270, 150, 10);
        progressBar_13.setValue(0);
        progressBar_13.setForeground(Color.blue);
        contentPane.add(progressBar_13);

        progressBar_14 = new JProgressBar();
        progressBar_14.setBounds(650, 290, 150, 10);
        progressBar_14.setValue(0);
        progressBar_14.setForeground(Color.red);
        contentPane.add(progressBar_14);

        progressBar_15 = new JProgressBar();
        progressBar_15.setBounds(650, 310, 150, 10);
        progressBar_15.setValue(0);
        progressBar_15.setForeground(Color.green);
        contentPane.add(progressBar_15);
        
        lblNewLabel_8 = new JLabel("Comida en el almacen:");
        lblNewLabel_8.setBounds(650, 330, 150, 13);
        contentPane.add(lblNewLabel_8);

        lblNewLabel_9 = new JLabel("0");
        lblNewLabel_9.setBounds(650, 353, 150, 13);
        contentPane.add(lblNewLabel_9);

        lblNewLabel_10 = new JLabel("Comida en el comedor:");
        lblNewLabel_10.setBounds(650, 376, 150, 13);
        contentPane.add(lblNewLabel_10);

        lblNewLabel_11 = new JLabel("0");
        lblNewLabel_11.setBounds(650, 399, 150, 13);
        contentPane.add(lblNewLabel_11);
        
        lblNewLabel_12 = new JLabel("""
                                    <html><p>Para seguir a una hormiga pause el programa y seleccionela,
                                    a continuacion pulse seguir. El color de la hormiga cambiara cuando
                                    esta cambie de zona.</p></html>""");
        lblNewLabel_12.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_12.setForeground(Color.blue);
        lblNewLabel_12.setBounds(650, 412, 150, 150);
        contentPane.add(lblNewLabel_12);
        
        lblNewLabel_13 = new JLabel("""
                                    <html><p>Cuando se inicie una invasion el texto del boton generar bicho
                                    cambiara para notificarlo.</p></html>""");
        lblNewLabel_13.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_13.setForeground(Color.red);
        lblNewLabel_13.setBounds(650, 525, 150, 200);
        contentPane.add(lblNewLabel_13);
        
        lblNewLabel_14 = new JLabel("""
                                    <html><p>Las barras de color indican el porcentaje de cada tipo de hormiga 
                                    existente en cada zona, del 0% al 100%.</p></html>""");
        lblNewLabel_14.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_14.setForeground(Color.green);
        lblNewLabel_14.setBounds(650, 593, 150, 200);
        contentPane.add(lblNewLabel_14);
        //Fin de los elementos del almacen

        //Inicio de los elementos del exterior
        lblNewLabel_7 = new JLabel("Exterior");
        lblNewLabel_7.setBounds(810, 33, 150, 13);
        contentPane.add(lblNewLabel_7);
		
        exterior = new ListaHormigas(0);
        exterior.getLista().setBounds(coordExterior[0], coordExterior[1], coordExterior[2], coordExterior[3]);
        contentPane.add(exterior.getLista());

        progressBar_16 = new JProgressBar();
        progressBar_16.setBounds(810, 620, 150, 10);
        progressBar_16.setValue(0);
        progressBar_16.setForeground(Color.blue);
        contentPane.add(progressBar_16);

        progressBar_17 = new JProgressBar();
        progressBar_17.setBounds(810, 640, 150, 10);
        progressBar_17.setValue(0);
        progressBar_17.setForeground(Color.red);
        contentPane.add(progressBar_17);

        progressBar_18 = new JProgressBar();
        progressBar_18.setBounds(810, 660, 150, 10);
        progressBar_18.setValue(0);
        progressBar_18.setForeground(Color.green);
        contentPane.add(progressBar_18);
        //Fin de los elementos del exterior
		
        //Botones
        btnNewButton_1 = new JButton("Pausar");
        btnNewButton_1.setActionCommand("Boton_1");
        btnNewButton_1.setBounds(10, 682, 150, 21);
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("Ver historial");
        btnNewButton_2.setActionCommand("Boton_2");
        btnNewButton_2.setBounds(170, 682, 150, 21);
        contentPane.add(btnNewButton_2);

        btnNewButton_3 = new JButton("Seguir hormiga");
        btnNewButton_3.setActionCommand("Boton_3");
        btnNewButton_3.setBounds(330, 682, 310, 21);
        contentPane.add(btnNewButton_3);

        btnNewButton_5 = new JButton("Generar bicho");
        btnNewButton_5.setActionCommand("Boton_5");
        btnNewButton_5.setBounds(650, 682, 310, 21);
        contentPane.add(btnNewButton_5);
        
        //Otros
        comidaAlmacen = new AtomicInteger(0);
        comidaComedor = new AtomicInteger(0);
        accesoComidaAlmacen = new ReentrantLock();
        colaAlmacen = new ArrayList();
        accesoComidaComedor = new ReentrantLock();
        colaComedor = new ArrayList();
        pausa = false;
        monitorPausa = new Object();
        hormigaSeguida = null;
        totalHormigas = new ArrayList();
        invasion = false;
        monitorInsecto = new Object();
        soldadosQuePelean = 0;
        soldadosPeleando = new AtomicInteger(0);
        hormigaPreviaInvasion = 0;
        this.fichero = fichero;
    }
    
    public void comprobarEventos(Hormiga h, boolean comprobarInvasion) {
        comprobarPausa(h);
        if(comprobarInvasion)
            comprobarInvasion(h);
    }
    
    public void comprobarPausa(Hormiga h) {
        if(pausa) {
            synchronized(monitorPausa) {
                try {
                    monitorPausa.wait();
                } catch (InterruptedException ex) {
                    System.out.format("%s", "Error en la pausa del programa\n");
                }
            }
        }
    }
    
    public void comprobarInvasion(Hormiga h) {
        if(invasion && !h.getTipo().contains("HO")) {
            salirComedor(h);
            salirDormitorio(h);

            if(h.getTipo().contains("HC")) {
                entrarRefugio(h, false);
                
                synchronized(monitorInsecto) {
                    try {
                        monitorInsecto.wait();
                    } catch (InterruptedException ex) {
                        System.out.format("%s", "Error en la pausa por invasion para las crias\n");
                    }
                    
                    salirRefugio(h);
                }
            } else if(h.getID() < hormigaPreviaInvasion) {
                entrarExterior(h, false);
                salirCuartel(h);
                soldadosPeleando.addAndGet(1);
                synchronized(monitorInsecto) {
                    try {
                        monitorInsecto.wait();
                    } catch (InterruptedException ex) {
                        System.out.format("%s", "Error en la pausa por invasion para las soldado\n");
                    }
                    
                    salirExterior(h);
                }
            }
        }
    }
    
    public void despertarPausa() {
        synchronized(monitorPausa) {
            monitorPausa.notifyAll();
        }
    }
    
    public void despertarInvasion() {
        synchronized(monitorInsecto) {
            monitorInsecto.notifyAll();
        }
    }
    
    public void nuevaHormiga(Hormiga h) {
        totalHormigas.add(h);
    }
    
    public void seguirHormiga() {
        int indiceHormiga;
        String hormiga = "";
        
        if((indiceHormiga = refugio.seleccionarHormiga()) != -1)
            hormiga = refugio.getElementos()[indiceHormiga];
        else if((indiceHormiga = dormitorio.seleccionarHormiga()) != -1)
            hormiga = dormitorio.getElementos()[indiceHormiga];
        else if((indiceHormiga = comedor.seleccionarHormiga()) != -1)
            hormiga = comedor.getElementos()[indiceHormiga];
        else if((indiceHormiga = cuartel.seleccionarHormiga()) != -1)
            hormiga = cuartel.getElementos()[indiceHormiga];
        else if((indiceHormiga = almacen.seleccionarHormiga()) != -1)
            hormiga = almacen.getElementos()[indiceHormiga];
        else if((indiceHormiga = exterior.seleccionarHormiga()) != -1)
            hormiga = exterior.getElementos()[indiceHormiga];
        
        for(int i = 0; i < totalHormigas.size(); i++) {
            if(hormiga.equals(totalHormigas.get(i).getNombre())) {
                if(hormigaSeguida != null)
                    hormigaSeguida.elegirColor();
                
                hormigaSeguida = totalHormigas.get(i);
                hormigaSeguida.setColor(2);
            }
                
        }
    }
    
    public void insertarComidaAlmacen() {
        comidaAlmacen.addAndGet(5);
        lblNewLabel_9.setText(Integer.toString(comidaAlmacen.get()));
        if(!colaAlmacen.isEmpty())
            colaAlmacen.get(0).despertar();
    }
    
    public boolean eliminarComidaAlmacen(Hormiga h) {
        accesoComidaAlmacen.lock();
        colaAlmacen.add(h);
        
        try {
            if(comidaAlmacen.get() < 5)
                return false;
            
            comidaAlmacen.addAndGet(-5);
            lblNewLabel_9.setText(Integer.toString(comidaAlmacen.get()));
        } catch(Exception e) {
            System.out.format("%s", "Error al eliminar comida en el almacen\n");
        } finally {
            colaAlmacen.remove(h);
            accesoComidaAlmacen.unlock();
        }
        return true;
    }
    
    public void insertarComidaComedor() {
        comidaComedor.addAndGet(5);
        lblNewLabel_11.setText(Integer.toString(comidaComedor.get()));
        if(!colaComedor.isEmpty() && colaComedor.get(0) != null)
            colaComedor.get(0).despertar();
    }
    
    public void eliminarComidaComedor(Hormiga h) {
        colaComedor.add(h);
        while(comidaComedor.get() < 1) {
            h.dormir();
        }
        
        accesoComidaComedor.lock();
        
        try {
            comidaComedor.addAndGet(-1);
            lblNewLabel_11.setText(Integer.toString(comidaComedor.get()));
            colaComedor.remove(h);
        } catch(Exception e) {
            System.out.format("%s", "Error al eliminar comida en el almacen\n");
        } finally {
            accesoComidaComedor.unlock();
        }
    }
    
    private void actualizarLista(ListaHormigas lista, int[] coordenadas) {
        synchronized(lista) {
            contentPane.remove(contentPane.getComponentAt(coordenadas[0], coordenadas[1]));
            lista.getLista().setBounds(coordenadas[0], coordenadas[1], coordenadas[2], coordenadas[3]);
            contentPane.add(lista.getLista());
            lista.getLista().update(lista.getLista().getGraphics());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ex) {
                System.out.format("s", "Error en la actualizacion de listas\n");
            }
        }
    }
    
    public boolean visitarAlmacen(Hormiga h, int tiempo, boolean insertarComida) {
        boolean comidaEliminada = false;
        
        try {
            aforoAlmacen.acquire();
            
            almacen.insertarElemento(h, fichero, "almacen");
            actualizarLista(almacen, coordAlmacen);
            
            h.esperar(tiempo);
            if(insertarComida)
                insertarComidaAlmacen();
            else
                comidaEliminada = eliminarComidaAlmacen(h);
            
            almacen.eliminarElemento(h);
            actualizarLista(almacen, coordAlmacen);
        } catch(InterruptedException e) {
            System.out.format("%s", "Error en el almacen al acceder la hormiga " + h.getNombre() + "\n");
        } finally {
            aforoAlmacen.release();
        }
        return comidaEliminada;
    }
    
    public void entrarRefugio(Hormiga h, boolean comprobarInvasion) {
        comprobarEventos(h, comprobarInvasion);
    	refugio.insertarElemento(h, fichero, "refugio");
    	actualizarLista(refugio, coordRefugio);
    }
    
    public void salirRefugio(Hormiga h) {
    	if(refugio.eliminarElemento(h))
            actualizarLista(refugio, coordRefugio);
    }
    
    public void entrarDormitorio(Hormiga h, boolean comprobarInvasion) {
        comprobarEventos(h, comprobarInvasion);
    	dormitorio.insertarElemento(h, fichero, "dormitorio");
    	actualizarLista(dormitorio, coordDormitorio);
    }
    
    public void salirDormitorio(Hormiga h) {
    	if(dormitorio.eliminarElemento(h))
            actualizarLista(dormitorio, coordDormitorio);
    }
    
    public void entrarComedor(Hormiga h, boolean comprobarInvasion) {
        comprobarEventos(h, comprobarInvasion);
    	comedor.insertarElemento(h, fichero, "comedor");
    	actualizarLista(comedor, coordComedor);
    }
    
    public void salirComedor(Hormiga h) {
    	if(comedor.eliminarElemento(h))
            actualizarLista(comedor, coordComedor);
    }
    
    public void entrarCuartel(Hormiga h) {
        comprobarEventos(h, true);
    	cuartel.insertarElemento(h, fichero, "cuartel");
    	actualizarLista(cuartel, coordCuartel);
    }
    
    public void salirCuartel(Hormiga h) {
    	if(cuartel.eliminarElemento(h))
            actualizarLista(cuartel, coordCuartel);
    }
    
    public void entrarExterior(Hormiga h, boolean comprobarInvasion) {
        comprobarEventos(h, comprobarInvasion);
    	exterior.insertarElemento(h, fichero, "exterior");
    	actualizarLista(exterior, coordExterior);
    }
    
    public void salirExterior(Hormiga h) {
    	if(exterior.eliminarElemento(h))
            actualizarLista(exterior, coordExterior);
    }
    
    public void porcentajeObrerasRefugio(int porcentaje) {
    	progressBar_1.setValue(porcentaje);
    }
    
    public void porcentajeSoldadoRefugio(int porcentaje) {
    	progressBar_2.setValue(porcentaje);
    }
    
    public void porcentajeCriasRefugio(int porcentaje) {
    	progressBar_3.setValue(porcentaje);
    }
    
    public void porcentajeObrerasDormitorio(int porcentaje) {
    	progressBar_4.setValue(porcentaje);
    }

    public void porcentajeSoldadoDormitorio(int porcentaje) {
    	progressBar_5.setValue(porcentaje);
    }

    public void porcentajeCriasDormitorio(int porcentaje) {
    	progressBar_6.setValue(porcentaje);
    }
    
    public void porcentajeObrerasComedor(int porcentaje) {
    	progressBar_7.setValue(porcentaje);
    }

    public void porcentajeSoldadoComedor(int porcentaje) {
    	progressBar_8.setValue(porcentaje);
    }

    public void porcentajeCriasComedor(int porcentaje) {
    	progressBar_9.setValue(porcentaje);
    }
    
    public void porcentajeObrerasCuartel(int porcentaje) {
    	progressBar_10.setValue(porcentaje);
    }

    public void porcentajeSoldadoCuartel(int porcentaje) {
    	progressBar_11.setValue(porcentaje);
    }

    public void porcentajeCriasCuartel(int porcentaje) {
    	progressBar_12.setValue(porcentaje);
    }
    
    public void porcentajeObrerasAlmacen(int porcentaje) {
    	progressBar_13.setValue(porcentaje);
    }

    public void porcentajeSoldadoAlmacen(int porcentaje) {
    	progressBar_14.setValue(porcentaje);
    }

    public void porcentajeCriasAlmacen(int porcentaje) {
    	progressBar_15.setValue(porcentaje);
    }
    
    public void porcentajeObrerasExterior(int porcentaje) {
    	progressBar_16.setValue(porcentaje);
    }

    public void porcentajeSoldadoExterior(int porcentaje) {
    	progressBar_17.setValue(porcentaje);
    }

    public void porcentajeCriasExterior(int porcentaje) {
    	progressBar_18.setValue(porcentaje);
    }
    
    public void setLblNewLabel_9(String texto) {
    	lblNewLabel_9.setText(texto);
    }
    
    public void setLblNewLabel_11(String texto) {
    	lblNewLabel_11.setText(texto);
    }
    
    public ListaHormigas getRefugio() {
        return refugio;
    }
    
    public ListaHormigas getDormitorio() {
        return dormitorio;
    }
    
    public ListaHormigas getComedor() {
        return comedor;
    }
    
    public ListaHormigas getCuartel() {
        return cuartel;
    }
    
    public ListaHormigas getAlmacen() {
        return almacen;
    }
    
    public ListaHormigas getExterior() {
        return exterior;
    }
    
    public JButton getBtnNewButton_1() {
        return btnNewButton_1;
    }
    
    public JButton getBtnNewButton_2() {
        return btnNewButton_2;
    }
    
    public JButton getBtnNewButton_3() {
        return btnNewButton_3;
    }
    
    public JButton getBtnNewButton_5() {
        return btnNewButton_5;
    }
    
    public boolean getPausa() {
        return pausa;
    }
    
    public boolean getInvasion() {
        return invasion;
    }
    
    public int getSoldadosQuePelean() {
        return soldadosQuePelean;
    }
    
    public int getSoldadosPeleando() {
        return soldadosPeleando.get();
    }
    
    public int getHormigaPreviaInvasion() {
        return hormigaPreviaInvasion;
    }
    
    public Fichero getFichero() {
        return fichero;
    }
    
    public void setPausa(boolean p) {
        pausa = p;
    }
    
    public void setInvasion(boolean i) {
        invasion = i;
    }
    
    public void setHormigaSeguida(Hormiga h) {
        hormigaSeguida = h;
    }
    
    public void setNumeroSoldados() {
        soldadosQuePelean++;
    }
    
    public void setHormigaPreviaInvasion(int n) {
        hormigaPreviaInvasion = n;
    }
}//end-VentanaHormiguero
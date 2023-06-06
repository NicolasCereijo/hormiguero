package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

/**@author Nicolás Cereijo Ranchal*/
public class VentanaCliente extends JFrame {
    /**Código para la serialización*/
    private static final long serialVersionUID = 1L;
    /**Contenedor general*/
    private final JPanel contentPane;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_1;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_2;
    /**Cuadro de texto*/
    private final JTextField textField_1;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_3;
    /**Cuadro de texto*/
    private final JTextField textField_2;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_5;
    /**Cuadro de texto*/
    private final JTextField textField_4;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_6;
    /**Cuadro de texto*/
    private final JTextField textField_5;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_7;
    /**Cuadro de texto*/
    private final JTextField textField_6;
    /**Etiqueta de texto*/
    private final JLabel lblNewLabel_4;
    /**Cuadro de texto*/
    private final JTextField textField_3;
    /**Botón de ejecución*/
    private final JButton btnNewButton_1;
    
    /**Constructor sin parámetros*/
    public VentanaCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 175);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel_1 = new JLabel("Interfaz del cliente");
        lblNewLabel_1.setBounds(10, 10, 140, 13);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Obreras en el exterior:");
        lblNewLabel_2.setBounds(10, 33, 130, 13);
        contentPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(150, 30, 45, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        lblNewLabel_3 = new JLabel("Obreras en el interior:");
        lblNewLabel_3.setBounds(10, 56, 130, 13);
        contentPane.add(lblNewLabel_3);
        
        textField_2 = new JTextField();
        textField_2.setBounds(150, 53, 45, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        lblNewLabel_4 = new JLabel("Soldados entrenando:");
        lblNewLabel_4.setBounds(10, 79, 130, 13);
        contentPane.add(lblNewLabel_4);
        
        textField_3 = new JTextField();
        textField_3.setBounds(150, 76, 45, 19);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        lblNewLabel_5 = new JLabel("Soldados peleando:");
        lblNewLabel_5.setBounds(205, 33, 120, 13);
        contentPane.add(lblNewLabel_5);
        
        textField_4 = new JTextField();
        textField_4.setBounds(335, 30, 45, 19);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        lblNewLabel_6 = new JLabel("Crias en el comedor:");
        lblNewLabel_6.setBounds(205, 56, 120, 13);
        contentPane.add(lblNewLabel_6);
        
        textField_5 = new JTextField();
        textField_5.setBounds(335, 53, 45, 19);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        lblNewLabel_7 = new JLabel("Crias en el refugio:");
        lblNewLabel_7.setBounds(205, 79, 120, 13);
        contentPane.add(lblNewLabel_7);
        
        textField_6 = new JTextField();
        textField_6.setBounds(335, 76, 45, 19);
        contentPane.add(textField_6);
        textField_6.setColumns(10);
        
        btnNewButton_1 = new JButton("Generar bicho");
        btnNewButton_1.setActionCommand("Boton_1");
        btnNewButton_1.setBounds(10, 102, 370, 30);
        contentPane.add(btnNewButton_1);
    }
    
    public void setTextField_1(String dato) {
        textField_1.setText(dato);
    }

    public void setTextField_2(String dato) {
        textField_2.setText(dato);
    }

    public void setTextField_3(String dato) {
        textField_4.setText(dato);
    }

    public void setTextField_4(String dato) {
        textField_5.setText(dato);
    }

    public void setTextField_5(String dato) {
        textField_6.setText(dato);
    }

    public void setTextField_6(String dato) {
        textField_3.setText(dato);
    }

    public JButton getBtnNewButton_1() {
        return btnNewButton_1;
    }
}

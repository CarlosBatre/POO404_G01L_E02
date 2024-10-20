package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Persona extends JFrame{
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JPanel PnlPersona;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblbSexo;
    private JTable tblDatos;
    DefaultTableModel modelo = null;

//    constructor con parametro para inicializar el JFrame creado

    public Persona(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlPersona);
        this.setMinimumSize(new Dimension(800, 650));
        this.setLocationRelativeTo(getParent());

//        Arreglo de objeto para inicializar  con vacio la tabla

        Object [][] data = null;
//        Arreglo de string para crear los nombres de las columnas
        String [] columns={
                "Id", "Nombres", "Edad", "Telefono", "Sexo"
        };
//        Instancia del modelo
        modelo = new DefaultTableModel(data, columns);
        /*
        Seteamos el model, el cual tendra la estructura que permitira
        a la tabla represnetar los datos
         */
        tblDatos.setModel(modelo);

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }

            private void btnObtenerDatos() {
                String id;
                String nombres;
                String edad;
                String telefono;
                String sexo;

                id = txtId.getText();
                nombres = txtNombre.getText();
                edad = txtEdad.getText();
                telefono = txtTelefono.getText();
                sexo = cmbSexo.getSelectedItem().toString();

                JOptionPane.showMessageDialog(null, "Datos Obtenidos: \n ID: " +id + "\n nombres: " +nombres+ "\n Edad: " +edad+ "\n Telefono: " +telefono+ "\n Sexo: "+sexo);

                Object [] newRow = {
                        id, nombres, edad, telefono, sexo
                };
                modelo.addRow(newRow);
            }

        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
            private void btnLimpiar(){
                txtId.setText("");
                txtNombre.setText("");
                txtEdad.setText("");
                txtTelefono.setText("");
                cmbSexo.setSelectedIndex(0);
            }
        });
        tblDatos.addMouseMotionListener(new MouseMotionAdapter() {
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatos(e);
            }

            private void tblObtenerDatos(MouseEvent e) {
                int fila = tblDatos.rowAtPoint(e.getPoint());
                int columna = tblDatos.columnAtPoint(e.getPoint());

                if ((fila > -1) && (columna > -1)){
                    txtId.setText(modelo.getValueAt(fila, 0).toString());
                    txtNombre.setText(modelo.getValueAt(fila, 1).toString());
                    txtEdad.setText(modelo.getValueAt(fila, 2).toString());
                    txtTelefono.setText(modelo.getValueAt(fila, 3).toString());
                    cmbSexo.setSelectedItem(modelo.getValueAt(fila, 4).toString());
                }
            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new Persona("Ingreso de datos ");
        frame.setVisible(true);
    }

}

package sv.edu.udb.form;

import sv.edu.udb.datos.PersonasDatos;
import sv.edu.udb.datos.OcupacionesDatos;
import sv.edu.udb.beans.PersonaBeans;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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
    private JLabel lblFechaNacimiento;
    private JComboBox cmbOcupacion;
    private JTable tblDatos;
    DefaultTableModel modelo = null;
    PersonaBeans personaBeans = null;
    PersonasDatos personasDatos = new PersonasDatos();
    OcupacionesDatos ocupacionesDatos = new OcupacionesDatos();

//    constructor con parametro para inicializar el JFrame creado

    public Persona(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlPersona);
        this.setMinimumSize(new Dimension(800, 650));
        this.setLocationRelativeTo(getParent());

////        Arreglo de objeto para inicializar  con vacio la tabla
//
//        Object [][] data = null;
////        Arreglo de string para crear los nombres de las columnas
//        String [] columns={
//                "Id", "Nombres", "Edad", "Telefono", "Sexo"
//        };
////        Instancia del modelo
//        modelo = new DefaultTableModel(data, columns);
//        /*
//        Seteamos el model, el cual tendra la estructura que permitira
//        a la tabla represnetar los datos
//         */
//        tblDatos.setModel(modelo);

        modelo=personasDatos.selectPersona();
        tblDatos.setModel(modelo);
        cmbOcupacion.setModel(ocupacionesDatos.selectOcupaciones());

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }

            private void btnObtenerDatos() {
                int id;
                String nombres;
                int edad;
                String telefono;
                String sexo;
                int idOcupacion;
                String fechaNacimiento;
                if (txtId.getText().isEmpty()){
                    id = 0;
                }else{
                    id = Integer.parseInt(txtId.getText());
                }
                nombres = txtNombre.getText();
                edad = Integer.parseInt(txtEdad.getText());
                telefono = txtTelefono.getText();
                sexo = cmbSexo.getSelectedItem().toString();
                idOcupacion =
                        ocupacionesDatos.getIdOcupacion(cmbOcupacion.getSelectedItem().toString());
                Label txtFechaNacimiento;
                fechaNacimiento = txtFechaNacimiento.getText();
                personaBeans = new
                        PersonaBeans(id,nombres,edad,telefono,sexo, idOcupacion, fechaNacimiento);
                if(btnObtenerDatos.getText().equals("Guardar")) {
                    personasDatos.insert(personaBeans);
                }else if (btnObtenerDatos.getText().equals("Editar")) {
                    personasDatos.update(personaBeans);
                } modelo=personasDatos.selectPersona();
                tblDatos.setModel(modelo);
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

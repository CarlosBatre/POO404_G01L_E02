package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Persona extends JFrame{
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JLabel lblbSexo;
    private JLabel lblTelefono;
    private JLabel lblEdad;
    private JLabel lblNombre;
    private JLabel lblId;
    private JPanel pnlPersona;
    private JTable tblDatos;
    private JScrollPane t;
    DefaultTableModel modelo=null;

    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setSize(600, 500);
        this.setLocationRelativeTo(getParent());

        Object[][] data = null;
        String[] colums = {"Id", "Nombre", "Edad", "Telefono", "Sexo"};
        modelo = new DefaultTableModel(data,colums);
        tblDatos.setModel(modelo);



        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });
    }
    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
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
        JOptionPane.showMessageDialog(null,"Datos Obtenidos: \n ID: " +id+
                "\n nombres: "+ nombres+"\n Edad: "+edad+"\n Telefono: "+telefono+
                "\n Sexo: "+ sexo);

        Object[] Newrow = {id,nombres,edad,telefono,sexo};
        modelo.addRow(Newrow);
    }

    public static void main(String[] args) {
        JFrame frame = new Persona("Ingreso de Datos");
        frame.setVisible(true);
    }

}

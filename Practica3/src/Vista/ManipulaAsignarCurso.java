/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControlProfesor;
import Controlador.ControlProfesorAsignar;
import Modelo.CursoException;
import Modelo.DBAsignar;
import Modelo.Profesor;
import Modelo.ProfesorException;
import java.util.ArrayList;

/**
 *
 * @author Jose Montero
 */
public class ManipulaAsignarCurso extends javax.swing.JFrame {

    /**
     * Creates new form ManipulaAsignarCurso
     */
    private ControlProfesorAsignar ca;
    
    public ManipulaAsignarCurso(DBAsignar dba) {
        initComponents();
        ca = new ControlProfesorAsignar(this, dba);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_sigla = new javax.swing.JTextField();
        comboProfes = new javax.swing.JComboBox();
        btn_asignar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Profesores:");

        jLabel3.setText("Sigla:");

        comboProfes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProfes.setSelectedItem(comboProfes);

        btn_asignar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_asignar.setText("Asignar Curso");
        btn_asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asignarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_asignar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_nombre))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txt_sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboProfes, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txt_sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProfes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_asignar)
                        .addContainerGap(31, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_asignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignarActionPerformed
       if(evt.getActionCommand().equals(btn_asignar)){
           ca.actionPerformed(evt);
       }
    }//GEN-LAST:event_btn_asignarActionPerformed

    /**
     * @param cp
     */
    public void agregarAccionAsignar(ControlProfesor cp){
        this.btn_asignar.addActionListener(cp);
    }
    public int getCodigoPorFuente(Object source) {
        int dev = -1;
        if(this.btn_asignar.equals(source)){
            dev = ControlProfesorAsignar.ASIGNAR;
        }
        
     return dev;
    }
    public void set_Profesores(ArrayList<Profesor> profe_lista){
        this.comboProfes.removeAllItems();
        for(Profesor est: profe_lista){
           this.comboProfes.addItem(est.getCedula());
        }
    }
    public String get_Profesor_seleccionado() throws ProfesorException{
        int pos = this.comboProfes.getSelectedIndex();
        if(pos==-1){
            throw new ProfesorException("Profesor no seleccionado");
        }
        return (String) this.comboProfes.getModel().getElementAt(pos);
    }
    public String getSigla(){
        return txt_sigla.getText();
    }
    public String getNombre(){
        return txt_nombre.getText();
    }
    public void limpiarTXT(){
        this.txt_nombre.setText("");
        this.txt_sigla.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_asignar;
    private javax.swing.JComboBox comboProfes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_sigla;
    // End of variables declaration//GEN-END:variables
}

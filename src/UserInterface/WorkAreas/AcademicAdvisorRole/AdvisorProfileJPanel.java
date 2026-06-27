/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.AcademicAdvisorRole;

import Business.Person.Person;
import Business.UserAccounts.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author janet
 */
public class AdvisorProfileJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    UserAccount useraccount;

    public AdvisorProfileJPanel(UserAccount ua, JPanel jp) {
        useraccount = ua;
        CardSequencePanel = jp;
        initComponents();
        displayProfile();
    }

    private void displayProfile() {
        Person p = useraccount.getAssociatedPersonProfile().getPerson();
        txtRole.setText(useraccount.getRole());
       // txtPersonID.setText(p.getPersonId());
        txtName.setText(p.getFullName());
        txtNUID.setText(p.getNuid());
        txtEmail.setText(p.getEmail());
        txtDepartment.setText(p.getDepartment());
        txtTitle.setText(p.getTitle());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        lblRole = new javax.swing.JLabel();
        lblPersonID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblNUID = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        txtPersonID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtNUID = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDepartment = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("View Advisor Profile");
        add(jLabel1);
        jLabel1.setBounds(30, 20, 300, 28);

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back);
        Back.setBounds(60, 410, 90, 23);

        lblRole.setText("Role:");
        add(lblRole);
        lblRole.setBounds(30, 80, 120, 30);

        lblPersonID.setText("Person ID:");
        add(lblPersonID);
        lblPersonID.setBounds(30, 120, 120, 30);

        lblName.setText("Name:");
        add(lblName);
        lblName.setBounds(30, 160, 120, 30);

        lblNUID.setText("NUID:");
        add(lblNUID);
        lblNUID.setBounds(30, 200, 120, 30);

        lblEmail.setText("Email:");
        add(lblEmail);
        lblEmail.setBounds(30, 240, 120, 30);

        lblDepartment.setText("Department:");
        add(lblDepartment);
        lblDepartment.setBounds(30, 280, 120, 30);

        lblTitle.setText("Title:");
        add(lblTitle);
        lblTitle.setBounds(30, 320, 120, 30);

        txtRole.setEditable(false);
        add(txtRole);
        txtRole.setBounds(160, 80, 230, 30);

        txtPersonID.setEditable(false);
        add(txtPersonID);
        txtPersonID.setBounds(160, 120, 230, 30);

        txtName.setEditable(false);
        add(txtName);
        txtName.setBounds(160, 160, 230, 30);

        txtNUID.setEditable(false);
        add(txtNUID);
        txtNUID.setBounds(160, 200, 230, 30);

        txtEmail.setEditable(false);
        add(txtEmail);
        txtEmail.setBounds(160, 240, 230, 30);

        txtDepartment.setEditable(false);
        add(txtDepartment);
        txtDepartment.setBounds(160, 280, 230, 30);

        txtTitle.setEditable(false);
        add(txtTitle);
        txtTitle.setBounds(160, 320, 230, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
          CardSequencePanel.remove(this);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).previous(CardSequencePanel);
        
    }//GEN-LAST:event_BackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNUID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPersonID;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNUID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPersonID;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}

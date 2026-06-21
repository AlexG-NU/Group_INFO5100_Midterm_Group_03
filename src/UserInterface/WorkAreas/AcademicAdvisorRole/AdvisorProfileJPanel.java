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
        txtPersonID.setText(p.getPersonId());
        txtName.setText(p.getFullName());
        txtNUID.setText(p.getNuid());
        txtEmail.setText(p.getEmail());
        txtDepartment.setText(p.getDepartment());
        txtTitle.setText(p.getTitle());
       // txtLastAccess.setText(useraccount.getLastAccess());
       // I'll add it later txtLastUpdated.setText(useraccount.getLastUpdated());
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
        lblLastAccess = new javax.swing.JLabel();
        lblLastUpdated = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        txtPersonID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtNUID = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDepartment = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtLastAccess = new javax.swing.JTextField();
        txtLastUpdated = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        jLabel1.setText("My Profile");
        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 20, 300, 28);

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back);
        Back.setBounds(30, 420, 90, 23);

        lblRole.setText("Role:");
        add(lblRole);
        lblRole.setBounds(30, 80, 120, 20);

        lblPersonID.setText("Person ID:");
        add(lblPersonID);
        lblPersonID.setBounds(30, 115, 120, 20);

        lblName.setText("Name:");
        add(lblName);
        lblName.setBounds(30, 150, 120, 20);

        lblNUID.setText("NUID:");
        add(lblNUID);
        lblNUID.setBounds(30, 185, 120, 20);

        lblEmail.setText("Email:");
        add(lblEmail);
        lblEmail.setBounds(30, 220, 120, 20);

        lblDepartment.setText("Department:");
        add(lblDepartment);
        lblDepartment.setBounds(30, 255, 120, 20);

        lblTitle.setText("Title:");
        add(lblTitle);
        lblTitle.setBounds(30, 290, 120, 20);

        lblLastAccess.setText("Last Accessed:");
        add(lblLastAccess);
        lblLastAccess.setBounds(30, 325, 120, 20);

        lblLastUpdated.setText("Last Updated:");
        add(lblLastUpdated);
        lblLastUpdated.setBounds(30, 360, 120, 20);

        txtRole.setEditable(false);
        add(txtRole);
        txtRole.setBounds(160, 75, 230, 20);

        txtPersonID.setEditable(false);
        add(txtPersonID);
        txtPersonID.setBounds(160, 110, 230, 20);

        txtName.setEditable(false);
        add(txtName);
        txtName.setBounds(160, 145, 230, 20);

        txtNUID.setEditable(false);
        add(txtNUID);
        txtNUID.setBounds(160, 180, 230, 20);

        txtEmail.setEditable(false);
        add(txtEmail);
        txtEmail.setBounds(160, 215, 230, 20);

        txtDepartment.setEditable(false);
        add(txtDepartment);
        txtDepartment.setBounds(160, 250, 230, 20);

        txtTitle.setEditable(false);
        add(txtTitle);
        txtTitle.setBounds(160, 285, 230, 20);

        txtLastAccess.setEditable(false);
        add(txtLastAccess);
        txtLastAccess.setBounds(160, 320, 230, 20);

        txtLastUpdated.setEditable(false);
        add(txtLastUpdated);
        txtLastUpdated.setBounds(160, 355, 230, 20);
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
    private javax.swing.JLabel lblLastAccess;
    private javax.swing.JLabel lblLastUpdated;
    private javax.swing.JLabel lblNUID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPersonID;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastAccess;
    private javax.swing.JTextField txtLastUpdated;
    private javax.swing.JTextField txtNUID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPersonID;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}

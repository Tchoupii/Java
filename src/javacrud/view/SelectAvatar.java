/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javacrud.view;

import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacrud.control.ImageDAO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author b.chesneau
 */
public class SelectAvatar extends javax.swing.JDialog {

    private final int largeurIn = 420;
    private final int hauteurIn = 495;
    private final int largeurOut = 140;
    private final int hauteurOut = 165;
    private final int maxFileSize = 5000000;
    private String pseudo;
    private boolean selected;

    /**
     * Creates new form SelectAvatar
     */
    public SelectAvatar(java.awt.Frame parent, boolean modal, String pseudo) {
        
        super(parent, modal);
        this.pseudo = pseudo;
        initComponents();
        
    }
    public boolean isSelected(){
        return selected;
    }
    private void chargePhotoUt() {
        ImageIcon photo = ImageDAO.getUtIcon(this.pseudo);
        if (photo != null) {
            this.Miniature.setIcon(photo);
            this.VisuPhoto.setIcon(photo);
        } else {
            this.VisuPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/user-tie_.jpg")));
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Choose = new javax.swing.JFileChooser();
        VisuPhoto = new javax.swing.JLabel();
        Chercher = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        Abandonner = new javax.swing.JButton();
        Miniature = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        VisuPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/user-tie-max.jpg"))); // NOI18N
        VisuPhoto.setText("Photo");
        VisuPhoto.setMaximumSize(new java.awt.Dimension(420, 495));
        VisuPhoto.setMinimumSize(new java.awt.Dimension(420, 495));
        VisuPhoto.setPreferredSize(new java.awt.Dimension(420, 495));

        Chercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/folder-open_20.png"))); // NOI18N
        Chercher.setText("Ouvrir");
        Chercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChercherMouseClicked(evt);
            }
        });

        Valider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/valid_20.png"))); // NOI18N
        Valider.setText("Valider");
        Valider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValiderMouseClicked(evt);
            }
        });
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        Abandonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/escape_20.png"))); // NOI18N
        Abandonner.setText("Abandonner");
        Abandonner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbandonnerMouseClicked(evt);
            }
        });

        Miniature.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/user-tie-min.jpg"))); // NOI18N
        Miniature.setText("Miniature");
        Miniature.setPreferredSize(new java.awt.Dimension(140, 165));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Chercher)
                        .addGap(43, 43, 43)
                        .addComponent(Valider)
                        .addGap(64, 64, 64)
                        .addComponent(Abandonner))
                    .addComponent(VisuPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(Miniature, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Miniature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VisuPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Chercher)
                    .addComponent(Valider)
                    .addComponent(Abandonner))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChercherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChercherMouseClicked
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "png",
                "jpg", "jpeg", "gif");

        Choose.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
        Choose.setFileFilter(filter);
        int returnValue = Choose.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedImg = Choose.getSelectedFile();
            if (selectedImg.length() < maxFileSize) {
                try {
                    ImageIcon photo = ImageDAO.importImage(selectedImg.getPath(), largeurIn, hauteurIn);
                    if (photo != null) {
                        this.VisuPhoto.setIcon(photo);
                        photo = ImageDAO.importImage(selectedImg.getPath(), largeurOut, hauteurOut);
                        this.Miniature.setIcon(photo);
                    } else {
                        this.Miniature.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/user-tie.jpg")));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SelectAvatar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }


    }//GEN-LAST:event_ChercherMouseClicked
    {
       
    }
    private void AbandonnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbandonnerMouseClicked
        this.selected = false;
        this.dispose();
       // TODO add your handling code here:
    }//GEN-LAST:event_AbandonnerMouseClicked

    private void ValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValiderMouseClicked
        ImageDAO.setUtImage(pseudo, (ImageIcon) this.Miniature.getIcon());
        this.selected = true;
        this.dispose();
    }//GEN-LAST:event_ValiderMouseClicked

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValiderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectAvatar dialog = new SelectAvatar(new javax.swing.JFrame(), true, "Etudiant");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JButton Chercher;
    private javax.swing.JFileChooser Choose;
    private javax.swing.JLabel Miniature;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel VisuPhoto;
    // End of variables declaration//GEN-END:variables
}

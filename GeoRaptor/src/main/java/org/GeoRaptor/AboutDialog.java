/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AboutDialog.java
 *
 * Created on Nov 12, 2010, 11:45:02 AM
 */

package org.GeoRaptor;

import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.DefaultCaret;

import org.GeoRaptor.tools.PropertiesManager;
import org.GeoRaptor.tools.Tools;

import org.geotools.util.logging.Logger;


/**
 *
 * @author oracle
 * 
 * Use Resources class to replace propertiesFile
 */
public class AboutDialog extends javax.swing.JDialog {

    private ImageIcon GeoRaptorLogo;

    private ClassLoader cl = this.getClass().getClassLoader();

    /**
     * Reference to resource manager for accessing messages in properties file
     */
    protected PropertiesManager propertyManager;
    private static final String propertiesFile = "org.GeoRaptor.resource.Res";

    private static final Logger LOGGER = org.geotools.util.logging.Logging.getLogger("org.GeoRaptor.AboutDialog");
    
    private static AboutDialog INSTANCE;

    public static AboutDialog getInstance() {
        if (AboutDialog.INSTANCE == null) {
            AboutDialog.INSTANCE = new AboutDialog(null, true);
        }
        return AboutDialog.INSTANCE;
    }

    /** Creates new form AboutDialog */
    private AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        cl = this.getClass().getClassLoader();
        
        this.propertyManager = new PropertiesManager(AboutDialog.propertiesFile);
        
//        String version = Tools.getVersion();
        setTitle(Resources.getString("ABOUT_BOX_TITLE"));
        
        initComponents();
        
        DefaultCaret caret = (DefaultCaret)taGeoRaptorAboutText.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

        this.GeoRaptorLogo = new ImageIcon(cl.getResource("org/GeoRaptor/images/GeoRaptorLogo.jpg"));
        lblLogo.setIcon(this.GeoRaptorLogo);

        taGeoRaptorAboutText.setContentType("text/html");
        taGeoRaptorAboutText.setText(Resources.getString("ABOUT_TEXT"));
        taGeoRaptorAboutText.setBackground(this.getBackground());
        
        taGeoRaptorAboutText.addHyperlinkListener(new HyperlinkListener() {
               @Override
               public void hyperlinkUpdate(HyperlinkEvent e) {
                   if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                       try {
                           Desktop.getDesktop().browse(e.getURL().toURI());
                       } catch (Exception e1) {
                           LOGGER.error("Error opening link " + e.getURL());
                       }
                   }
               }
           });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        scrollGeoRaptorAboutText = new javax.swing.JScrollPane();
        taGeoRaptorAboutText = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(875, 350));

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        //lblLogo.setIcon(new javax.swing.ImageIcon(cl.getResource("org/GeoRaptor/images/GeoRaptorLogo.jpg")));

        taGeoRaptorAboutText.setEditable(false);
        taGeoRaptorAboutText.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        taGeoRaptorAboutText.setText("GeoRaptor is an open source project hosted on Sourceforge:\n  http://sourceforge.net/projects/georaptor\n\nPlease visit the wiki page for more information:\n  http://sourceforge.net/apps/mediawiki/georaptor\n\nDeveloped by Simon Greener, Holger Laebe, Pieter Minnaar,Matik Petek and Olaf Iseeger\n\nWith special thanks to Simon Greener:\n  http://www.spatialdbadvisor.com\n\nGeoRaptor development takes unpaid volunteer time. Consider helping by:\n\n1. Making a donation at:\n   http://sourceforge.net/project/project_donations.php?group_id=1581621\n2. Becoming a developer, documenter or tester\n\nThanks also to ...\n\n* John O'Toole from 1Spatial (www.1spatial.com);\n* Sandro Costa, Brazil;\n* Marco Giana, Australia.\n\n... for testing, release documentation and valuable suggestions.");
        taGeoRaptorAboutText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scrollGeoRaptorAboutText.setViewportView(taGeoRaptorAboutText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollGeoRaptorAboutText, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogo))
                    .addComponent(btnClose))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollGeoRaptorAboutText, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JScrollPane scrollGeoRaptorAboutText;
    private javax.swing.JTextPane taGeoRaptorAboutText;
    // End of variables declaration//GEN-END:variables

}

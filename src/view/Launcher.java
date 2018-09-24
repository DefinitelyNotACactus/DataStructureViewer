package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Launcher extends JFrame {

    /**
     * Creates new form Launcher
     */
    public Launcher() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        btSeqList = new javax.swing.JButton();
        btLinkedList = new javax.swing.JButton();
        btStack = new javax.swing.JButton();
        btQueue = new javax.swing.JButton();
        btTrees = new javax.swing.JButton();
        btGraphs = new javax.swing.JButton();
        versionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Structure Viewer");
        setBackground(new java.awt.Color(0, 51, 153));
        setMinimumSize(new java.awt.Dimension(100, 100));

        contentPanel.setToolTipText("");
        contentPanel.setMinimumSize(new java.awt.Dimension(400, 500));

        titleLabel.setFont(new java.awt.Font("Corbel", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 51, 51));
        titleLabel.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[0] : Constants.LAUNCHER_EN[0]);
        titleLabel.setToolTipText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[1] : Constants.LAUNCHER_EN[1]);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        btSeqList.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[2] : Constants.LAUNCHER_EN[2]);
        btSeqList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeqListActionPerformed(evt);
            }
        });

        btLinkedList.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[3] : Constants.LAUNCHER_EN[3]);
        btLinkedList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLinkedListActionPerformed(evt);
            }
        });

        btStack.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[5] : Constants.LAUNCHER_EN[5]);
        btStack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStackActionPerformed(evt);
            }
        });

        btQueue.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[6] : Constants.LAUNCHER_EN[6]);
        btQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQueueActionPerformed(evt);
            }
        });

        btTrees.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[7] : Constants.LAUNCHER_EN[7]);
        btTrees.setEnabled(false);

        btGraphs.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[8] : Constants.LAUNCHER_EN[8]);
        btGraphs.setEnabled(false);

        versionLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        versionLabel.setText(Constants.PORTUGUESE ? Constants.LAUNCHER_PT[9] : Constants.LAUNCHER_EN[9]);
        versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        versionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                versionLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSeqList, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(btLinkedList, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(btStack, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(btQueue, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(btTrees, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(btGraphs, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(versionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(39, 39, 39)
                .addComponent(btSeqList, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLinkedList, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btStack, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btQueue, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTrees, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGraphs, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addComponent(versionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSeqListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeqListActionPerformed
        new Viewer("Sequential List").setVisible(true);
        dispose();
    }//GEN-LAST:event_btSeqListActionPerformed

    private void btLinkedListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLinkedListActionPerformed
        new Viewer("Linked List").setVisible(true);
        dispose();
    }//GEN-LAST:event_btLinkedListActionPerformed

    private void btQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQueueActionPerformed
        new Viewer("Queue").setVisible(true);
        dispose();
    }//GEN-LAST:event_btQueueActionPerformed

    private void btStackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStackActionPerformed
        new Viewer("Stack").setVisible(true);
        dispose();
    }//GEN-LAST:event_btStackActionPerformed

    private void versionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_versionLabelMouseClicked
        sillyColors();
    }//GEN-LAST:event_versionLabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            try {
                UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        EventQueue.invokeLater(() -> {
            new Launcher().setVisible(true);
        });
    }
    
    private void sillyColors() {
        Random rand = new Random();
        contentPanel.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btGraphs.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btLinkedList.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btQueue.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btSeqList.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btStack.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btTrees.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btGraphs.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btLinkedList.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btQueue.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btSeqList.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btStack.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        btTrees.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        versionLabel.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        titleLabel.setForeground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGraphs;
    private javax.swing.JButton btLinkedList;
    private javax.swing.JButton btQueue;
    private javax.swing.JButton btSeqList;
    private javax.swing.JButton btStack;
    private javax.swing.JButton btTrees;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
}

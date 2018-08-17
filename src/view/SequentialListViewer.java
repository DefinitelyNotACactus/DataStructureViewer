/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import structures.SequentialList;

public class SequentialListViewer extends JPanel {

    private SequentialList<Integer> list;
    /**
     * Creates new form SequentialList
     */
    public SequentialListViewer() {
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

        btCreate = new javax.swing.JButton();
        btLoad = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        operationsPanel = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        statusLabel = new javax.swing.JLabel();

        btCreate.setText("Create List");
        btCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateActionPerformed(evt);
            }
        });

        btLoad.setText("Load");
        btLoad.setEnabled(false);

        btSave.setText("Save");
        btSave.setToolTipText("");
        btSave.setEnabled(false);

        listPanel.setLayout(new javax.swing.BoxLayout(listPanel, javax.swing.BoxLayout.LINE_AXIS));

        optionsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));
        optionsPanel.add(btCreate);
        optionsPanel.add(btLoad);

        operationsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btAdd.setText("Add");
        operationsPanel.add(btAdd);

        btRemove.setText("Remove");
        operationsPanel.add(btRemove);

        btSearch.setText("Search");
        operationsPanel.add(btSearch);

        statusLabel.setText("Empty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operationsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(scrollPane)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(operationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateActionPerformed
        try{
            int size = Integer.parseInt(JOptionPane.showInputDialog(this, "Insert the list maximum size (Leave 0 for default size)", "Info", JOptionPane.QUESTION_MESSAGE));
            if(size == 0){
                list = new SequentialList<>();
            } else {
                list = new SequentialList<>(size);
            }
            optionsPanel.remove(btCreate);
            optionsPanel.add(btSave);
            optionsPanel.revalidate();
            listElements();
            statusLabel.setText("Current Size: " + list.getSize() + "\t\t\tMaximum Size: " + list.getMaxSize());
            revalidate();
        } catch(NumberFormatException ex){
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid Size!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btCreateActionPerformed
   
    private void listElements(){
        for(int i = 0; i < list.getMaxSize(); i++){
            JPanel panel = new JPanel();
            panel.add(new JLabel("" + i));
            panel.revalidate();
            scrollPane.add(panel);
            System.out.printf("%d", list.getValueAtPosition(i+1));
        }
        scrollPane.revalidate();
        revalidate();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCreate;
    private javax.swing.JButton btLoad;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JPanel listPanel;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
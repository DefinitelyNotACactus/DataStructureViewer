package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import structures.Queue;

public class QueueViewer extends JPanel {

    private Queue<Integer> queue;
    /**
     * Creates new form SequentialList
     */
    public QueueViewer() {
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

        optionsPanel = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btLoad = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        operationsPanel = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        scrollPane = new JScrollPane();
        statusLabel = new javax.swing.JLabel();

        optionsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));
        optionsPanel.add(btNew);
        optionsPanel.add(btLoad);

        btNew.setText("New Queue");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        optionsPanel.add(btNew);

        btLoad.setText("Load");
        btLoad.setEnabled(false);
        optionsPanel.add(btLoad);

        btSave.setText("Save");
        btSave.setToolTipText("");
        btSave.setEnabled(false);
        optionsPanel.add(btSave);

        operationsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btAdd.setText("Add");
        btAdd.setEnabled(false);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        operationsPanel.add(btAdd);

        btRemove.setText("Remove");
        btRemove.setEnabled(false);
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });
        operationsPanel.add(btRemove);

        scrollPane.setToolTipText("");
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        statusLabel.setText("Empty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operationsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
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

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        try{
            String input = JOptionPane.showInputDialog(this, "Insert the queue maximum size (Type 0 for default size)", "Info", JOptionPane.QUESTION_MESSAGE);
            if(input == null){
                return;
            }
            int size = Integer.parseInt(input);
            if(size == 0){
                queue = new Queue<>();
            } else if(size > 0){
                queue = new Queue<>(size);
            } else {
                throw new NumberFormatException();
            }
            listElements();
            statusLabel.setText("Current Size: " + queue.getSize() + "         Maximum Size: " + queue.getMaxSize());
            btAdd.setEnabled(true);
            btRemove.setEnabled(true);
            revalidate();
        } catch(NumberFormatException ex){
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Size must be a positive integer!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btNewActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        int value = 0;
        String input;
        try{
            input = JOptionPane.showInputDialog(this, "Insert the value", "Info", JOptionPane.QUESTION_MESSAGE);
            if(input == null){
                return;
            }
            value = Integer.parseInt(input);
            try{
                queue.insert(value);
                listElements();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Value must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        try{
            Element element = new Element(""+ queue.remove());
            element.setBorderColor(Color.BLUE);
            JOptionPane.showMessageDialog(this, element, "Value at the queue start", JOptionPane.PLAIN_MESSAGE);
            listElements();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btRemoveActionPerformed
   
    private void listElements(){
        Container cont = new Container();
        Element element;
        for(int i = 1; i <= queue.getMaxSize(); i++){
            try {
                element = new Element("" + queue.getValueAtPosition(i));
                if(i-1 == queue.getStart() && queue.getSize() > 0){
                    element.setBorderColor(Color.BLUE);
                    element.setToolTipText("Queue's first element");
                } else if(i-1 == queue.getEnd() && queue.getSize() > 0){
                    element.setBorderColor(Color.RED);
                    element.setToolTipText("Queue's last element");
                }
                cont.add(element);
            }catch(Exception ex){
                cont.add(new Element("null"));
            }
        }     
        cont.setLayout(new GridLayout());
        scrollPane.getViewport().setView(cont);
        statusLabel.setText("Current Size: " + queue.getSize() + "         Maximum Size: " + queue.getMaxSize());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btLoad;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btSave;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}

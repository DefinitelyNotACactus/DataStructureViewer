package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import structures.Stack;

public class StackViewer extends JPanel {

    private Stack<Integer> stack;
    
    /**
     * Creates new form SequentialList
     */
    public StackViewer() {
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

        btLoad = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        optionsPanel = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        operationsPanel = new javax.swing.JPanel();
        btPush = new javax.swing.JButton();
        btpop = new javax.swing.JButton();
        scrollPane = new JScrollPane();
        statusLabel = new javax.swing.JLabel();

        btLoad.setText("Load");
        btLoad.setEnabled(false);

        btSave.setText("Save");
        btSave.setToolTipText("");
        btSave.setEnabled(false);

        optionsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btNew.setText("New Stack");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        optionsPanel.add(btNew);

        operationsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btPush.setText("Push");
        btPush.setEnabled(false);
        btPush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPushActionPerformed(evt);
            }
        });
        operationsPanel.add(btPush);

        btpop.setText("Pop");
        btpop.setEnabled(false);
        btpop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpopActionPerformed(evt);
            }
        });
        operationsPanel.add(btpop);

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setToolTipText("");
        scrollPane.setAutoscrolls(true);

        statusLabel.setText("Empty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addComponent(operationsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(operationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        try {
            String input = JOptionPane.showInputDialog(this, "Insert the stack maximum size (Type 0 for default size)", "Info", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                return;
            }
            int size = Integer.parseInt(input);
            if (size == 0) {
                stack = new Stack<>();
            } else if (size > 0) {
                stack = new Stack<>(size);
            } else {
                throw new NumberFormatException();
            }
            listElements();
            statusLabel.setText("Current Size: " + stack.getSize() + "         Maximum Size: " + stack.getMaxSize());
            btPush.setEnabled(true);
            btpop.setEnabled(true);
            revalidate();
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Size must be a positive integer!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btNewActionPerformed

    private void btPushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPushActionPerformed
        int value;
        String input;
        try {
            input = JOptionPane.showInputDialog(this, "Insert the value", "Info", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                return;
            }
            value = Integer.parseInt(input);
            try {
                stack.push(value);
                listElements();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Value must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btPushActionPerformed

    private void btpopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpopActionPerformed
        try {
            Element element = new Element("" + stack.pop());
            element.setBorderColor(Color.BLUE);
            JOptionPane.showMessageDialog(this, element, "Value at the stack top", JOptionPane.PLAIN_MESSAGE);
            listElements();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btpopActionPerformed

    private void listElements() {
        Container cont = new Container();
        Element element;        
        for (int i = stack.getSize(); i > 0; i--) {
            try {
                element = new Element("" + stack.getValueAtPosition(i));
                if(i == stack.getTop()){
                    element.setBorderColor(Color.BLUE);
                    element.getLabel().setText("<html><center>" + stack.getValueAtPosition(i) + "<br>Top</center></html>");
                    element.setToolTipText("Top");
                }
                cont.add(element);
            } catch (Exception ex) {
                //element = new Element("");
                //element.setBackground(new Color(240, 240, 240));
                //element.getLabel().setVisible(false);
                //cont.add(element);
            }
        }
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        int sValue = scrollPane.getVerticalScrollBar().getValue();
        scrollPane.getViewport().setView(cont);
        scrollPane.getVerticalScrollBar().setValue(sValue);
        statusLabel.setText("Current Size: " + stack.getSize() + "         Maximum Size: " + stack.getMaxSize());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLoad;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btPush;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btpop;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}

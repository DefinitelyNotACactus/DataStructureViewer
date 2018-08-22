package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
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

        optionsPanel = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btLoad = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        operationsPanel = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btModify = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        scrollPane = new JScrollPane();
        statusLabel = new javax.swing.JLabel();

        optionsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));
        optionsPanel.add(btNew);
        optionsPanel.add(btLoad);

        btNew.setText("New List");
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

        btModify.setText("Modify");
        btModify.setEnabled(false);
        btModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifyActionPerformed(evt);
            }
        });
        operationsPanel.add(btModify);

        btRemove.setText("Remove");
        btRemove.setEnabled(false);
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });
        operationsPanel.add(btRemove);

        btSearch.setText("Search");
        btSearch.setEnabled(false);
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });
        operationsPanel.add(btSearch);

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
            String input = JOptionPane.showInputDialog(this, "Insert the list maximum size (Type 0 for default size)", "Info", JOptionPane.QUESTION_MESSAGE);
            if(input == null){
                return;
            }
            int size = Integer.parseInt(input);
            if(size == 0){
                list = new SequentialList<>();
            } else if(size > 0){
                list = new SequentialList<>(size);
            } else {
                throw new NumberFormatException();
            }
            listElements();
            statusLabel.setText("Current Size: " + list.getSize() + "         Maximum Size: " + list.getMaxSize());
            btAdd.setEnabled(true);
            btModify.setEnabled(true);
            btRemove.setEnabled(true);
            btSearch.setEnabled(true);
            revalidate();
        } catch(NumberFormatException ex){
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Size must be a positive integer!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btNewActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        int value = 0, position = 0, selection;
        String options[] = {"Beginning", "Ending", "In a given position", "Cancel"}, input;
        selection = JOptionPane.showOptionDialog(this, "Where you would like to add an element", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(selection >= 0 && selection <= 2){
            try{
                input = JOptionPane.showInputDialog(this, "Insert the value", "Info", JOptionPane.QUESTION_MESSAGE);
                if(input == null){
                    return;
                }
                value = Integer.parseInt(input);
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Value must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            switch(selection){
                case 0://first
                    position = 1;
                    break;
                case 1://last
                    position = list.getSize()+1;
                    break;
                case 2://x position
                    try{
                        input = JOptionPane.showInputDialog(this, "Insert the position where you would like to add " + value, "Info", JOptionPane.QUESTION_MESSAGE);
                        if(input == null){
                            return;
                        }
                        position = Integer.parseInt(input);
                    } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(this, "Position must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                default:
                    break;
            }
            if(!list.addValue(position, value)){
                JOptionPane.showMessageDialog(this, "Invalid position or the list is full!", "Info", JOptionPane.WARNING_MESSAGE);
            }
        }
        listElements();
    }//GEN-LAST:event_btAddActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        int selection;
        String options[] = {"By Value", "By Position", "Cancel"}, input;
        selection = JOptionPane.showOptionDialog(this, "How you would like to search the list?", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch(selection){
            case 0://search by value
                try{
                    input = JOptionPane.showInputDialog(this, "Type the value to search for:", "Info", JOptionPane.QUESTION_MESSAGE);
                    if(input == null){
                        return;
                    }
                    int value = Integer.parseInt(input);
                    try{
                        listElements(list.getPositionByValue(value), false);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Value must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 1://search by position
                try{
                    input = JOptionPane.showInputDialog(this, "Type the position to search for:", "Info", JOptionPane.QUESTION_MESSAGE);
                    if(input == null){
                        return;
                    }
                    int position = Integer.parseInt(input);
                    try{
                        list.getValueAtPosition(position);
                        JOptionPane.showMessageDialog(this, new Element(""+ list.getValueAtPosition(position)), "Value at position " + position, JOptionPane.PLAIN_MESSAGE);
                        listElements(position, true);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }                
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Position must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                break;
        } 
    }//GEN-LAST:event_btSearchActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        int position = 0, selection;
        String options[] = {"Remove by position", "Remove by element", "Cancel"}, input;
        selection = JOptionPane.showOptionDialog(this, "How you would like to remove an element", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(selection >= 0 && selection <= 2){
            switch(selection){
                case 0://remove by position
                    try {
                        input = JOptionPane.showInputDialog(this, "Where do you would like to remove a element?", "Info", JOptionPane.QUESTION_MESSAGE);
                        if(input == null){
                            return;
                        }
                        position = Integer.parseInt(input);
                        try{
                            Integer value = list.remove(position);
                            JOptionPane.showMessageDialog(this, "" + value + " was removed from the list!");
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);
                        }
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(this, "Position must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                case 1://remove by element
                    try {
                        input = JOptionPane.showInputDialog(this, "Type the element to remove from the list:", "Info", JOptionPane.QUESTION_MESSAGE);
                        if(input == null){
                            return;
                        }
                        Integer value = Integer.parseInt(input);
                        try{
                            position = list.remove(value);
                            JOptionPane.showMessageDialog(this, "" + value + " was removed from the list at position " + position);
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(this, "The element must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                default:
                    break;
            }         
        }
        listElements();
    }//GEN-LAST:event_btRemoveActionPerformed

    private void btModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifyActionPerformed
        try{
            String input = JOptionPane.showInputDialog(this, "Please type the position you would like to modify: ", "Info", JOptionPane.QUESTION_MESSAGE);
            if(input == null){
                return;
            }
            int pos = Integer.parseInt(input);
            if(!list.isValidPosition(pos)){
                throw new Exception();
            } else {
                input = JOptionPane.showInputDialog(this, "Insert the new value for position " + pos + " : ", "Info", JOptionPane.QUESTION_MESSAGE);
                int newValue = Integer.parseInt(input);
                list.setValueAtPosition(pos, newValue);
                listElements(pos, true);
            }
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "The position and value must be a integer!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex){
            
        }
    }//GEN-LAST:event_btModifyActionPerformed
   
    private void listElements(){
        Container cont = new Container();
        for(int i = 1; i <= list.getMaxSize(); i++){
            try {
                cont.add(new Element("" + list.getValueAtPosition(i)));
            }catch(Exception ex){
                cont.add(new Element("null"));
            }
        }     
        cont.setLayout(new GridLayout());
        scrollPane.getViewport().setView(cont);
        statusLabel.setText("Current Size: " + list.getSize() + "         Maximum Size: " + list.getMaxSize());
    }
    
    private void listElements(int number, boolean position){
        Container cont = new Container();
        for(int i = 1; i <= list.getMaxSize(); i++){
            Element element;
            try {
                int value = list.getValueAtPosition(i);
                element = new Element("" + list.getValueAtPosition(i));
                cont.add(element);
                if(position){
                    if(i == number){
                        element.setBorderColor(Color.yellow);
                    }
                } else {
                    if(value == number){
                        element.setBorderColor(Color.yellow);
                    }
                }
            }catch(Exception ex){
                element = new Element("null");
                cont.add(element);
            }
            cont.add(element);
        }     
        cont.setLayout(new GridLayout());
        scrollPane.getViewport().setView(cont);
        statusLabel.setText("Current Size: " + list.getSize() + "         Maximum Size: " + list.getMaxSize());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btLoad;
    private javax.swing.JButton btModify;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}

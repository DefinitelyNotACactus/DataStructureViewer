package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Arrow extends JPanel {
    
    private boolean hasNext;
    
    /** Creates new form Element
     * @param hasNext */
    public Arrow(boolean hasNext) {
        this.hasNext = hasNext;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arrowLabel = new javax.swing.JLabel();

        setForeground(new java.awt.Color(240, 240, 240));
        setMaximumSize(new java.awt.Dimension(100, 100));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(100, 100));

        arrowLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        arrowLabel.setToolTipText("Next Element");
        arrowLabel.setMaximumSize(new java.awt.Dimension(90, 90));
        arrowLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        arrowLabel.setOpaque(true);
        arrowLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        arrowLabel.setHorizontalAlignment(SwingConstants.CENTER);
        arrowLabel.setVerticalAlignment(SwingConstants.CENTER);
        arrowLabel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                arrowLabelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(arrowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(arrowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void arrowLabelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_arrowLabelComponentResized
        setNext();
    }//GEN-LAST:event_arrowLabelComponentResized

    public JLabel getLabel(){
        return arrowLabel;
    }

    public void setNext(){
        if(hasNext){
            arrowLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/arrow.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        } else {
            arrowLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/null.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            arrowLabel.setToolTipText("Null");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrowLabel;
    // End of variables declaration//GEN-END:variables

}

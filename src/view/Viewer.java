package view;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Viewer extends JFrame {

    /**
     * Creates new form Viewer
     */
    private String title;

    public Viewer(String title) {
        this.title = title + " Viewer";
        initComponents();
        loadPanel();
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
        contentPanel = new javax.swing.JPanel();

        btCreate.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);

        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadPanel() {
        switch (title) {
            case "Sequential List Viewer":
                contentPanel.add(new SequentialListViewer());
                break;
            case "Linked List Viewer":
                contentPanel.add(new LinkedListViewer());
                break;
            case "Queue Viewer":
                contentPanel.add(new QueueViewer());
                break;
            case "Stack Viewer":
                setBounds(getX(), getY(), 800, 470);
                contentPanel.add(new StackViewer());
                break;
            default:
                break;
        }
        contentPanel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCreate;
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}

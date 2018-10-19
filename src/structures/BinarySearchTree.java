package structures;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import view.DiagonalArrow;
import view.Element;

public class BinarySearchTree {
    private TreeNode root;
    private JScrollPane pane;
    
    public BinarySearchTree(JScrollPane pane){
        root = null;
        this.pane = pane;
    }
    
    public boolean isEmpty(){
        return (root == null);
    }
    
    private TreeNode search(TreeNode node, int value) throws Exception {
        if(node == null){
            throw new Exception("" + value + " not found!");
        }
        if(node.getValue() == value){
            return node;
        }
        if(value < node.getValue()){
            return search(node.getLeft(), value);
        } else {
            return search(node.getRight(), value);
        }
    }
    
    public TreeNode search(int value) throws Exception {
        if(!isEmpty()){
            return search(root, value);
        }
        throw new Exception("The tree is empty!");
    }
    
    public void insert(int value){
        TreeNode newNode = new TreeNode(value);
        if(isEmpty()){
            root = newNode;
            return;
        }
        TreeNode aux = root, p = null;
        while(aux != null){
            p = aux;
            if(value < aux.getValue()){
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }
        }
        if(value < p.getValue()){
            p.setLeft(newNode);
        } else {
            p.setRight(newNode);
        }
    }
    
    public void showTree() {
        int maxLevel = maxLevel(root);
        Container cont = new Container();
        printNodeInternal(Collections.singletonList(root), 1, maxLevel, cont);
        cont.setLayout(new GridLayout(0,1));
        JPanel panel = new JPanel();
        panel.add(cont);
        int sVerticalValue = pane.getVerticalScrollBar().getValue();
        int hVerticalValue = pane.getHorizontalScrollBar().getValue();
        pane.getViewport().setView(panel);
        pane.getVerticalScrollBar().setValue(sVerticalValue);
        pane.getHorizontalScrollBar().setValue(hVerticalValue);
        pane.getViewport().setView(panel);
    }

    public void showTree(int value) {
        int maxLevel = maxLevel(root);
        Container cont = new Container();
        printNodeInternal(Collections.singletonList(root), 1, maxLevel, value, cont);
        cont.setLayout(new GridLayout(0,1));
        JPanel panel = new JPanel();
        panel.add(cont);
        int sVerticalValue = pane.getVerticalScrollBar().getValue();
        int hVerticalValue = pane.getHorizontalScrollBar().getValue();
        pane.getViewport().setView(panel);
        pane.getVerticalScrollBar().setValue(sVerticalValue);
        pane.getHorizontalScrollBar().setValue(hVerticalValue);
        pane.getViewport().setView(panel);
    }
    
    private void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel, int value, Container cont) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)){
            return;
        }
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
        printWhitespaces(firstSpaces, pnl);
        
        List<TreeNode> newNodes = new ArrayList<>();     
        for (TreeNode node : nodes) {
            Element element;
            if (node != null) {
                int nodeValue = node.getValue();
                element = new Element("" + nodeValue);
                if(nodeValue == value){
                    element.setBackground(Color.YELLOW);
                }
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                element = new Element(" ");
                element.setBackground(new Color(240, 240, 240, 0));
                newNodes.add(null);
                newNodes.add(null);
            }
            pnl.add(element);
            printWhitespaces(betweenSpaces, pnl);
        }
        cont.add(pnl);
        
        for (int i = 1; i <= endgeLines; i++) {
            pnl = new JPanel();
            pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i, pnl);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1, pnl);
                    continue;
                }
                if (nodes.get(j).getLeft() != null){
                    DiagonalArrow arrow = new DiagonalArrow(true);
                    pnl.add(arrow);
                } else {
                    printWhitespaces(1, pnl);
                }
                printWhitespaces(i + i - 1, pnl);

                if (nodes.get(j).getRight() != null){
                    DiagonalArrow arrow = new DiagonalArrow(false);
                    pnl.add(arrow);
                }else{
                    printWhitespaces(1, pnl);
                }
                printWhitespaces(endgeLines + endgeLines - i, pnl);
            }
            cont.add(pnl);
        }
        printNodeInternal(newNodes, level + 1, maxLevel, value, cont);
    }
    
    private void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel, Container cont) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)){
            return;
        }
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
        printWhitespaces(firstSpaces, pnl);
        
        List<TreeNode> newNodes = new ArrayList<>();     
        for (TreeNode node : nodes) {
            Element element;
            if (node != null) {
                element = new Element("" + node.getValue());
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                element = new Element(" ");
                element.setBackground(new Color(240, 240, 240, 0));
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            pnl.add(element);
            printWhitespaces(betweenSpaces, pnl);
        }
        System.out.println("");
        cont.add(pnl);
        
        for (int i = 1; i <= endgeLines; i++) {
            pnl = new JPanel();
            pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i, pnl);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1, pnl);
                    continue;
                }
                if (nodes.get(j).getLeft() != null){
                    DiagonalArrow arrow = new DiagonalArrow(true);
                    pnl.add(arrow);
                    System.out.print("/");
                } else {
                    printWhitespaces(1, pnl);
                }
                printWhitespaces(i + i - 1, pnl);

                if (nodes.get(j).getRight() != null){
                    DiagonalArrow arrow = new DiagonalArrow(false);
                    pnl.add(arrow);
                    System.out.print("\\");
                }else{
                    printWhitespaces(1, pnl);
                }
                printWhitespaces(endgeLines + endgeLines - i, pnl);
            }
            System.out.println("");
            cont.add(pnl);
        }
        printNodeInternal(newNodes, level + 1, maxLevel, cont);
    }

    private void printWhitespaces(int count, JPanel pnl) {
        for (int i = 0; i < count; i++){
            Element element = new Element("");
            element.setBackground(new Color(240, 240, 240, 0));
            System.out.print(" ");
            pnl.add(element);
        }
    }

    private int maxLevel(TreeNode node) {
        if (node == null){
            return 0;
        }
        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private boolean isAllElementsNull(List<TreeNode> list) {
        return list.stream().noneMatch((node) -> (node != null));
    } 
}

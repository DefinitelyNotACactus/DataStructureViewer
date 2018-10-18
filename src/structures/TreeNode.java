package structures;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int value;
    
    public TreeNode(int value){
        left = null;
        right = null;
        this.value = value;
    }
    
    public TreeNode getLeft(){
        return left;
    }
    
    public void setLeft(TreeNode newLeft){
        left = newLeft;
    }
    
    public TreeNode getRight(){
        return right;
    }
    
    public void setRight(TreeNode newRight){
        right = newRight;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setData(int newData){
        value = newData;
    }
}

package assignment4;

/**
 * Created by JMG on 11/3/2015.
 */
public class BSTNode <T> {
    private T element;
    private BSTNode left;
    private BSTNode right;
    private BSTNode parent;

    /**
     * Default constructor to initialize the queue array
     */
    public BSTNode(){
        element = null;
        left = null;
        right = null;
        parent = null;
    }
    /**
     * Default constructor to initialize the queue array
     */
    public BSTNode(T element) {
        this.element = element;
        left = null;
        right = null;
        parent = null;
    }

    public T getElement() {
        return element;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public BSTNode getLeft() {
        return left;
    }
    public void setLeft(BSTNode left) {
        this.left = left;
        if (left!=null) left.setParent(this);
    }
    public BSTNode getRight() {
        return right;
    }
    public void setRight(BSTNode right) {
        this.right = right;
        if (right!=null) right.setParent(this);
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }
}

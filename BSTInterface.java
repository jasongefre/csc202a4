package assignment4;

/**
 * Created by JMG on 11/3/2015.
 */
public interface BSTInterface<T> {
    public void add(T element);
    public T remove(T element);
    public T contains(T element);
    public int size();
    public void preorder(BSTNode root);
    public void postorder(BSTNode root);
    public void inorder(BSTNode root);
    public boolean isEmpty();
    public void reset();
}

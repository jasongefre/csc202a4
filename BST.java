package assignment4;

/**
 * Created by JMG on 11/1/2015.
 */
public class BST <T extends Comparable<T>>implements BSTInterface <T>{

    private BSTNode<T> root=null;
    private int numElement=0;
    private BSTNode<T> pointer = null;
    public Queue<T> inqueue;
    public Queue<T> prequeue;
    public Queue<T> postqueue;
    public enum Order {PREORDER, POSTORDER, INORDER};
    boolean found=false;

    public BST(){
    }

    @Override
    public void add(T element) {
        BSTNode<T> newNode = new BSTNode<>(element);
        if (root == null) {root = newNode;
        } else {recAdd(element,this.root);}
        numElement++;
    }
    public int rSize(BSTNode<T> root){
        if (root==null) return 0;
        if (root.getElement() == null) return 0;
        return 1 + rSize(root.getLeft()) + rSize(root.getRight());
    }
    private void rotate (BSTNode<T> n){
        BSTNode<T> p = n.getParent();
        BSTNode<T> gp = p.getParent();
        if (n == p.getLeft()) {
            p.setLeft(n.getRight());
            n.setRight(p);
            p.setParent(n);
        } else {
            p.setRight(n.getLeft());
            n.setLeft(p);
            p.setParent(n);
        }

        // Update the upper edge which switches sides

        if (gp == null)
            root = n;
        else if (p == gp.getLeft())
            gp.setLeft(n);
        else
            gp.setRight(n);
        n.setParent(gp);
    }
    /*
    public T add(T element,boolean ret){
        BSTNode<T> newNode = new BSTNode<>(element);
        if (root == null) {root = newNode;
        } else {recAdd(element,this.root);}
        numElement++;
        if(ret)return element;
        else return null;
    }*/
    @SuppressWarnings("unchecked")
    private BSTNode<T> recAdd(T element, BSTNode<T> root) {
        if (root == null) {
            root = new BSTNode<>(element);
        } else {
            if (root==this.root) {
                if ((element).compareTo(root.getElement()) <= 0) {// < root
                    //ADD TO THE LEFT
                    root.setLeft(recAdd(element, root.getLeft()));
                } else if ((element).compareTo(root.getElement()) > 0) { // > root
                    //ADD TO THE RIGHT
                    root.setRight(recAdd(element, root.getRight()));
                }
            }
            else {
                if (((element).compareTo((T) root.getParent().getElement()) <= 0 && root.getParent().getLeft() == root) ||
                        (element).compareTo((T) root.getParent().getElement()) > 0 && root.getParent().getRight() == root) {
                    if ((element).compareTo(root.getElement()) <= 0) {// < root
                        //ADD TO THE LEFT
                        root.setLeft(recAdd(element, root.getLeft()));
                    } else if ((element).compareTo(root.getElement()) > 0) { // > root
                        //ADD TO THE RIGHT
                        root.setRight(recAdd(element, root.getRight()));
                    }
                } else {
                    root.setParent(recAdd(element, root.getParent()));
                }
            }
            if (rSize(root.getLeft()) > rSize(root.getRight()) + 1){
                rotate(root.getLeft());
            }else if (rSize(root.getRight()) > rSize(root.getLeft()) + 1){
                rotate(root.getRight());
            }


        }
        return root;
    }

    @Override
    public T remove(T element) {
        if (!isEmpty()) {
            root = recRemove(element, root);
            return element;
        } else {
            try {
                throw new INFException("Cannot remove from empty BST.");
            } catch (INFException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    private BSTNode<T> recRemove(T element, BSTNode<T> tree)
    {
        if (tree == null) found = false;
        else if (element.compareTo(tree.getElement()) < 0) tree.setLeft(recRemove(element, tree.getLeft()));
        else if (element.compareTo(tree.getElement()) > 0) tree.setRight(recRemove(element, tree.getRight()));
        else
        {
            this.removeNode(tree);
            found = true;
        }
        return tree;
    }
    @SuppressWarnings("unchecked")
    private void removeNode(BSTNode<T> tree)
    {
        T data;

        if (tree.getLeft() == null) {
        }
        else if (tree.getRight() == null) {
        }
        else {
            data = getRootRelative(false, tree, false);
            tree.setElement(data);
            tree.setLeft(recRemove(data, tree.getLeft()));
        }
    }
    @SuppressWarnings("unchecked")
    private T getRootRelative(boolean prePost, BSTNode<T> tree,boolean kill){
        T data;
        if (tree == null) return null;
        if ((tree = (prePost)? tree.getRight() : tree.getLeft())== null) return null;
        if ((data = tree.getElement())==null) return null;
        if (prePost) {
            while (tree.getLeft() != null) tree = tree.getLeft();
        }else{
            while(tree.getRight() !=null) tree = tree.getRight();
        }
        if (kill) remove(tree.getElement());
        return data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T contains(T element) {
        recContains(element,this.root);
        if (found) {
            return element;
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public T contains(String rope) {

            return (T) recContains(rope, this.root);
    }
    @SuppressWarnings("unchecked")
    public BSTNode<T> recContains(T element, BSTNode<T> root) {

        if (root == null) {found = false;
        } else if (element.compareTo(root.getElement())<0) {recContains(element,root.getLeft());
        } else if (element.compareTo(root.getElement())>0) {recContains(element,root.getRight());
        } else if (element.compareTo(root.getElement())==0) {
            pointer = root;
            found = true;
        }
        return root;
    }

    public BSTNode<T> recContains(String rope, BSTNode<T> root) {
        if (root == null) {
            return null;
        } else if (root.getElement().toString().compareTo(rope)<0) {
            recContains(rope,root.getLeft());
        } else if (root.getElement().toString().compareTo(rope)>0) {
            recContains(rope,root.getRight());
        } else if (root.getElement().toString().compareTo(rope)==0) {
            found = true;
        }
        return root;
    }

    @Override
    public int size() {
        return numElement;
    }

    public Queue traversal(Order order) {
        prequeue = new Queue<>(numElement);
        postqueue = new Queue<>(numElement);
        inqueue = new Queue<>(numElement);
        pointer = this.root;
        if (!isEmpty()) {
            if (order.equals(Order.PREORDER)) {
                System.out.println("PREORDER");
                preorder(pointer);
                return prequeue;
            } else if (order.equals(Order.POSTORDER)) {
                System.out.println("POSTORDER");
                postorder(pointer);
                return postqueue;
            } else if (order.equals(Order.INORDER)) {
                System.out.println("INORDER");
                inorder(pointer);
                return inqueue;
            }
        }
        return null;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void preorder(BSTNode root) {
        if(root != null) {
            prequeue.enqueue((T)root.getElement());
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void postorder(BSTNode root) {
        if(root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            postqueue.enqueue((T)root.getElement());

        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void inorder(BSTNode root) {
        if(root != null) {
            inorder(root.getLeft());
            inqueue.enqueue((T)root.getElement());
            inorder(root.getRight());
        }
    }

    @Override
    public boolean isEmpty() {
        return (numElement == 0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void reset() {
        Queue<Object> q = traversal(Order.POSTORDER);
        while(!q.isEmpty()){
            q.dequeue();
        }
        numElement=0;
    }
}

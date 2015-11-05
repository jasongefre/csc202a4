package assignment4;

/**
 * Created by JMG on 11/3/2015.
 */
public class Queue<T> {
    private T[] queue;
    private int front = 0;
    private int rear = -1;
    private int count = 0;
    private int cap = 10;

    /**
     * Default constructor to initialize the queue array
     */
    @SuppressWarnings("unchecked")
    public Queue()
    {
        queue = (T[]) new Object[cap];
    }
    public Queue(int cap)
    {
        this.cap = cap;
        queue = (T[]) new Object[cap];
    }
    /**
     * Enlarges the queue array by one.
     */
    @SuppressWarnings("unchecked")
    private void enlarge()
    {
        T[] NEW = (T[]) new  Object[queue.length + 1];
        int j = front;
        for (int i = 0; i < count; i++)
        {
            NEW[i] = queue[j];
            j = (front + i + 1) % queue.length;
        }
        queue = NEW;
        front = 0;
        rear = count-1;
    }
    /**
     * @param data Adds data(T) to end of queue.
     */
    public void enqueue (T data)
    {
        if (isFull())
        {
            enlarge();
        }
        queue[(rear + 1) % queue.length] = data;
        rear = (rear + 1) % queue.length;
        count++;
        System.out.println(data);
    }

    /**
     * @return T at front of queue.
     */
    public T dequeue()
    {
        if (!isEmpty()) {
            T remove = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            count--;
            return remove;
        }
        return null;
    }
    /**
     * @return empty queue.
     */
    public boolean isEmpty()
    {
        return (count==0);
    }
    /**
     * @return full queue.
     */
    public boolean isFull()
    {
        return (count==queue.length);
    }

    /**
     * @return count
     */
    public  int inQueue()
    {
        return count;
    }
    public T getElement(int index){
        if (index > count)
        {
            return null;
        }
        else
            return queue[(index + front)%queue.length];
    }
    public int getIndexOf(T data){
        int j = front;
        for (int i = 0; i < count; i++)
        {
            if (queue[(front + i) % queue.length].equals(data)){
                return i;
            }
        }
        return -1;
    }
}

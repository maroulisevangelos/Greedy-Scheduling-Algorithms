
/**
 * Single-link List. Uses {@link Node} for list nodes.
 */
public class List<T> implements ListInterface<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size;

    /**
     * Default constructor
     */
    public List() {
    }

    /**
     * Determine whether list is empty
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Inserts the data at the front of the list
     *
     * @param data the inserted data
     */
    @Override
    public void insertAtFront(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
        size++;
    }

    /**
     * Inserts the data at the end of the list
     *
     * @param data the inserted item
     */
    @Override
    public void insertAtBack(T data) {
        Node<T> n = new Node<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    @Override
    public T removeFromFront() {
        

        T data = head.getData();

        if (head == tail) {
            head = tail = null;  
        }else {
            head = head.getNext();
        }
        size--;
        return data;
    }

    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws EmptyListException if the list is empty
     */
    @Override
    public T removeFromBack() {

        T data = tail.getData();

        if (head == tail) {
            head = tail = null;
        }else {
            Node<T> iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
        }
        size--;
        return data;
    }

    /**
     * Returns list as String
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append("HEAD -> ");

        while (current != null) {
            ret.append(current.data.toString());

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }
    
    public Node<T> getHead(){//return the head of the list
    	return head;
    }
    
    public Node<T> getTail(){//return the tail of the list
    	return tail;
    }
    
    public int getSize() {//return the size of the list
    	return size;
    }
}

import java.util.Comparator;

/**
 * PQ implementation based in Heap
 */
public class MaxPQ  implements PQInterface{
	/**
     * Heap based implementation of PQ
     * To implement it you need to implement the following helper functions as well
     * swim, sing, swap, grow
     */
	
	private Processor [] heap;//heap to store data in
	private int size;// current size of the queue
	private Comparator comparator;// the comparator to use between the objects
	private int min;//the active time with the lowest priority
	
	private static final int DEFAULT_CAPACITY = 4;// default capacity
	
	/**
     * Queue constructor
     *
     * @param comparator
     */
	public MaxPQ(Comparator comparator) {
		this.heap = new Processor[DEFAULT_CAPACITY + 1];
		this.size = 0;
		this.comparator = comparator;
		this.min=1000000000;
	}
	
	
	@Override
	public boolean isEmpty() { //check if the queue is empty
		if (this.size == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public int size() { //return the number of active elements in the queue
		System.out.println("lista: " + heap.length);
		return this.size;
	}
	
	/**
     * Inserts the specified element into this priority queue.
     *
     * @param x
     */
    @Override
	public void insert(Processor x) { // insert the object x to the queue
    	
		if (size >= (heap.length - 1) * 0.75) {//check if the heap should be resized 
			resize();
		}
		if (size==0) {//if this is the first Processor of the list
			min = x.getActiveTime();//this is the active time with the lowest priority
		}else if (x.getActiveTime()>min) {//else if the active time of this Processor is higher than the previous
			min = x.getActiveTime();//give to the min the active time of this Processor
		}
		heap[++size] = x;// Place item at the next available position
		swim(size);// Let the newly added item swim
		
	}
	
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    @Override
	public Processor max(){/*return without removing the object with
	the highest priority */
		if (size ==0) {// Ensure not empty
			return null;
		}
		
		return heap[1] ;// return root without removing
	}
    
    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    @Override
	public Processor getmax(){/* remove and return the object
	with the highest priority*/
		if (size == 0 ) {// Ensure not empty
			return null;
		}
		
		Processor root = heap[1];// Keep a reference to the root item
		heap[1] = heap[size];// Replace root item with the one at rightmost leaf
		size--;//reduce the size
		
		// Dispose the rightmost leaf
        // Sink the new root element
		sink(1);
		
		return root;// Return the item removed
	}
	
    /**
     * Helper function to swim items to the top
     *
     * @param i the index of the item to swim
     */
	private void swim(int i) {
		
		if (i==1) {// if i is root (i==1) return
			return;
		}
		
		int parent = i/2;// find parent
		while (i!=1 && comparator.compare(heap[i], heap[parent]) > 0) {// compare parent with child i
			swap (i,parent);
			i = parent;
			parent = i/2;
		}
	}
	
	/**
     * Helper function to swim items to the bottom
     *
     * @param i the index of the item to sink
     */
	private void sink(int i) {
        
        int left = 2 * i;// determine left child
        int right = left + 1;//determine right child

        
        if (left > size) {// if 2*i > size, node i is a leaf return
            return;
        }
        
        while (left <= size) {// while haven't reached the leafs
            
            int max = left;// Determine the largest child of node i
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) < 0)
                    max = right;
            }

            // If the heap condition holds, stop. Else swap and go on.
            // child smaller than parent
            if (comparator.compare(heap[i], heap[max]) > 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }
	
	/**
     * Helper function to swap two elements in the heap
     *
     * @param i the first element's index
     * @param j the second element's index
     */
	private void swap(int i, int j) {
		Processor tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
	}
	
	/**
     * Helper function to grow the size of the heap
     */
	private void resize() {
		Processor[] newHeap = new Processor[heap.length*2];

	    // copy array
		//(notice: in the priority queue, elements are located in the array slots with positions in [1, size])
	    for (int i = 0; i <= size; i++) {
	    	newHeap[i] = heap[i];
	      }

        heap = newHeap;
    }
	
	public void printMaxPQ() {//print the whole heap with a retrospectively way
		if (isEmpty()) {
			return;
		}
		Processor n = this.getmax();//get and remove the processor with the highest priority
		System.out.println(n);//print the processor
		this.printMaxPQ();//call the function for the heap without the processor we removed 
		this.insert(n);//insert again this processor
	}
	public int makespan() {//return the active time of the processor with the lowest priority
		if (size ==0) {// Ensure not empty
			return 0;
		}
		return min;
	}
}
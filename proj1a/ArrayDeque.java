/** Array based list */
public class ArrayDeque<T>{
    private T [] items;
    private int size;
    private int capacity;
    private int nextFirst;
    private int nextLast;

    /** Create an empty array empty */
    public ArrayDeque(){
        capacity = 8;
        items = (T []) new Object[capacity];
        nextFirst = 1;
        nextLast = 2;
        size = 0;

    }

    /** Create a deep copy of other */
    public ArrayDeque(ArrayDeque<T> other){
        this.capacity = other.capacity;
        this.size = other.size;
        this.items = (T[]) new Object[capacity]; // Allocate new memory
        this.nextFirst = other.nextFirst;
        this.nextLast = other.nextLast;

        // Copy elements one by one
        for (int i = 0; i < capacity; i++) {
            this.items[i] = other.items[i];
        }
    }

    /** Add an item of type T to the front of deque */
    public void addFirst(T x){
        if (size == capacity){
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = (nextFirst - 1 + capacity) % capacity;
        size += 1;
    }

    /** Add an item of type T to the back of deque */
    public void addLast(T x){
        if (size == capacity){
            resize(size * 2);
        }
        items[nextLast] = x;
        nextLast = (nextLast + 1 + capacity) % capacity;
        size += 1;
    }

    /** Resize the deque */
    private void resize(int newcapacity){
        T [] newData = (T []) new Object[newcapacity];
        int start = (nextFirst + 1) % capacity;
        for (int i = 0; i < size; i ++){
            newData[i] = items[start];
            start = (start + 1) % capacity;
        }
        items = newData;
        capacity = newcapacity;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /** Return true if the Deque is empty, false ohterwise */
    public boolean isEmpty(){
        return size == 0;
    }

    /** Return the number of the item in the deque */
    public int size(){
        return size;
    }

    /** Return the item at the given index */
    public T get(int index){
        index = (nextFirst + 1 + index) % capacity;
        return items[index];
    }

    /** Return the first item in the deque */
    public T getFirst(){
        int firstIndex = (nextFirst + 1) % capacity;
        return items[firstIndex];
    }

    /** Return the last item in the deque */
    public T getLast(){
        int lastIndex = (nextLast - 1 + capacity) % capacity;
        return items[lastIndex];
    }

    /** Remove the return the first item in the deque */
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T first = getFirst();
        nextFirst = (nextFirst + 1) % capacity;
        items[nextFirst] = null;
        size -= 1;
        
        if ( size > 0 && size < capacity * 0.25 && capacity > 8){
            resize(size / 2);
        }
        return first;
    }

    /** Remove and return the last item in the deque */
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T last = getLast();
        nextLast = (nextLast - 1 + capacity) % capacity;
        items[nextLast] = null;
        size -= 1;

        if ( size > 0 && size < capacity / 4 && capacity > 8){
            resize(size / 4);
        }
        return last;
    }

    /** Prints the deque elements */
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.print("Deque: ");
        int index = (nextFirst + 1) % capacity;
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = (index + 1) % capacity;
        }
        System.out.println();
    }

    /** Main method to test the deep copy constructor */
    public static void main(String[] args) {
        ArrayDeque<String> originalDeque = new ArrayDeque<>();

        // Adding elements to the original deque
        originalDeque.addLast("A");
        originalDeque.addLast("B");
        originalDeque.addLast("C");

        System.out.println("Original Deque:");
        originalDeque.printDeque();

        // Creating a deep copy
        ArrayDeque<String> copiedDeque = new ArrayDeque<>(originalDeque);

        System.out.println("Copied Deque:");
        copiedDeque.printDeque();

        // Modify the original deque
        originalDeque.addFirst("X");
        originalDeque.removeLast();

        System.out.println("Original Deque after modification:");
        originalDeque.printDeque();

        System.out.println("Copied Deque should remain unchanged:");
        copiedDeque.printDeque();
    }


}
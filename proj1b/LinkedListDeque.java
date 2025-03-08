/** LinkedListDeque*/
public class LinkedListDeque<T> implements Deque<T> {
    public IntNode sentinel;
    private int size;

    public class IntNode{
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T x){
            this.item = x;
            this.next = null;
            this.prev = null;
        }
    }

    /** No-Arg Constructor */
    public LinkedListDeque(){
        sentinel = new IntNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Parameterized Constructor*/
    public LinkedListDeque(T x){
        this();
        addFirst(x);
    }

    /** Create a copy of other */
    public LinkedListDeque(LinkedListDeque<T> other){
        this();

        IntNode current = other.sentinel.next;
        while( current != other.sentinel){
            this.addLast(current.item);
            current = current.next;
        }
    }

    @Override
    /** Add an item to the front of the list */
    public void addFirst(T x){
        IntNode newNode = new IntNode(x);
        newNode.next = sentinel.next;
        newNode.prev = sentinel;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    @Override
    /** Add an last item to the back of the list */
    public void addLast(T x){
        IntNode newNode = new IntNode(x);
        sentinel.prev.next = newNode;
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev = newNode;
        size += 1;
    }

    /** Determine if the list is empty:true is empty; false is not empty */
//    public boolean isEmpty(){
//        return (sentinel.next == null);
//        //return (size == 0);
//    }

    /** Return the numbers of the items in the deque*/
    public int size(){
        return size;
    }

    @Override
    /** Print the items in the deque from first to the last */
    public void printDeque(){
        if (isEmpty()){
            System.out.println("Deque is empty!");
            return ;
        }
        IntNode p = sentinel.next;
        while( p.next != sentinel){
            System.out.println(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item + " ");
    }

    @Override
    /** Remove the first item and return it; iff the deque is empty, return null */
    public T removeFirst(){
        if (isEmpty()) return null;

        T temp = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return temp;
    }

    @Override
    /** Remove the last item and return it; if the deque is empty, return null */
    public T removeLast(){
        if (isEmpty()) return null;

        T temp = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return temp;

    }

    @Override
    /** Gets the item at the given index */
    public T get(int index){
        IntNode p = sentinel.next;
        if (index > size - 1){
            return null;
        }else{
            while (index != 0){
                p = p.next;
                index -= 1;
            }
            return p.item;
        }
    }

    @Override
    /** Get the last item */
    public T getLast(){
        return get(size - 1);
    }

    @Override
    /** Get the first item */
    public T getFirst(){
        return get(0);
    }

   public static void main(String[] args){
       LinkedListDeque<String> deque = new LinkedListDeque<>();

       deque.addFirst("T1");
       deque.addLast("T2");
       deque.addFirst("T0");

       System.out.println("Deque after adding elements:");
       deque.printDeque();
       String first = deque.getFirst();
       System.out.println("First Element: " + first);

       System.out.println("First Element: " + deque.get(0));
       System.out.println("Last Element: " + deque.sentinel.prev.item);

       System.out.println("Removed First: " + deque.removeFirst());
       System.out.println("Removed Last: " + deque.removeLast());

       System.out.println("Deque after removals:");
       deque.printDeque();

   }
}
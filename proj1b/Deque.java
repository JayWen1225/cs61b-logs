public interface Deque<Item>{
    public void addFirst(Item x);
    public void addLast(Item x);
    public Item removeFirst();
    public Item removeLast();
    public Item get(int i);
    public Item getFirst();
    public Item getLast();
    public int size();
    public void printDeque();
    default public boolean isEmpty(){
        return size() == 0;
    };
    
}
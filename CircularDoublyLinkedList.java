package Assignment1;



/*
 * Romin Patel
 * 3164066
 * Assignment-1
 * ACS-2947
 */
public class CircularDoublyLinkedList <E>{
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element=e;
            prev=p;
            next=n;
        }
            
        private E getElement(){return element;}
        private Node<E> getPrev(){return prev;}
        private Node<E> getNext(){return next;}
        private void setPrev(Node<E> p){prev=p;}
        private void setNext(Node<E> n){next=n;}
        public String toString(){return element.toString();}
    }
    //instance variables
    private Node<E> last=null;
    private int size=0;
    //no-arg constructor
    public CircularDoublyLinkedList(){
        last=null;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if(isEmpty())return null;
        return  last.getNext().getElement();
    }
    public E last(){
        if(isEmpty())return null;
        return last.getElement();
    }
    //adds a new element to thr front of the list
    public void addFirst(E e){
        addBetween(e, last, last.getNext());
    }
    //adds a new element to the end of the list
    public void addLast(E e){
       // addBetween(e, last, last.getNext());
       Node<E> newest = new Node<>(e, null, null);

        if (isEmpty()) {
            newest.next = newest;
            newest.prev = newest;
            last = newest;
        } else {
            newest.next = last.next;
            newest.prev = last;
            last.next.prev = newest;
            last.next = newest;
            last = newest;
        }

        size++;
    }
    public E removeFirst(){
        if(isEmpty())return null;
        return remove(last.getNext());
    }
    public E  removeLast(){
        if(isEmpty())return null;
        return remove(last.getNext());
    }
    //advances to the next element in the list
    public void rotate(){
        if(!isEmpty())
        last = last.getNext();
    }
    //returns true if e is in the list or otherwise false
    public boolean contains(E e){
        Node<E> element = last;
        for(int i=0; i<size;i++){
        if(!(element.getElement().equals(e))){
            return false;
        }
        element= element.getNext();
    }
        return true;
    }
    private void addBetween(E e, Node<E> p, Node<E> n){
        Node<E> newest = new Node<>(e, p, n);
        p.setNext(newest);
        n.setPrev(p);
        size++;
    }
    public E remove(Node<E> e){
        Node<E> p = e.getPrev();
        Node<E> s= e.getNext();
            p.setNext(s);
        s.setNext(p);
        size--;
        return e.getElement();
    }
    public String toString(){
        if(isEmpty()){
            return "Empty ACS-2947 Waitlist";
        } 
        StringBuilder sb = new StringBuilder();
        Node<E> current = last.getNext();
        do {
            sb.append(current.getElement()).append("\n");
            current = current.getNext();
        } while (current != last.getNext());
        return sb.toString();
    }
    
}

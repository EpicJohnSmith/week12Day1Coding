package code;

public class StackandQueue {

	public interface Stack<T> {
	    void push(T item);
	    T pop();
	    T peek();
	    boolean isEmpty();
	}

	public interface Queue<T> {
	    void enqueue(T item);
	    T dequeue();
	    T front();
	    boolean isEmpty();
	}

	public class MyDoublyLinkedList<T> {

	    protected class Node {
	        T data;
	        Node prev, next;

	        Node(T data) {
	            this.data = data;
	        }
	    }

	    protected Node head;
	    protected Node tail;
	    protected int size = 0;

	    public void addFirst(T data) {
	        Node node = new Node(data);
	        if (head == null) {
	            head = tail = node;
	        } else {
	            node.next = head;
	            head.prev = node;
	            head = node;
	        }
	        size++;
	    }

	    public void addLast(T data) {
	        Node node = new Node(data);
	        if (tail == null) {
	            head = tail = node;
	        } else {
	            tail.next = node;
	            node.prev = tail;
	            tail = node;
	        }
	        size++;
	    }

	    public T removeFirst() {
	        if (head == null) return null;

	        T data = head.data;

	        if (head == tail) { // only one element
	            head = tail = null;
	        } else {
	            head = head.next;
	            head.prev = null;
	        }

	        size--;
	        return data;
	    }

	    public T removeLast() {
	        if (tail == null) return null;

	        T data = tail.data;

	        if (head == tail) { // only one element
	            head = tail = null;
	        } else {
	            tail = tail.prev;
	            tail.next = null;
	        }

	        size--;
	        return data;
	    }

	    public int size() {
	        return size;
	    }

	    public void printList() {
	        Node curr = head;
	        System.out.print("[ ");
	        while (curr != null) {
	            System.out.print(curr.data + " ");
	            curr = curr.next;
	        }
	        System.out.println("]");
	    }
	}

	
	public class MyStack<T> extends MyDoublyLinkedList<T> implements Stack<T> {

	    @Override
	    public void push(T item) {
	        addLast(item);
	    }

	    @Override
	    public T pop() {
	        return removeLast();
	    }

	    @Override
	    public T peek() {
	        return (tail != null) ? tail.data : null;
	    }

	    @Override
	    public boolean isEmpty() {
	        return size == 0;
	    }
	}

	public class MyQueue<T> extends MyDoublyLinkedList<T> implements Queue<T> {

	    @Override
	    public void enqueue(T item) {
	        addLast(item);
	    }

	    @Override
	    public T dequeue() {
	        return removeFirst();
	    }

	    @Override
	    public T front() {
	        return (head != null) ? head.data : null;
	    }

	    @Override
	    public boolean isEmpty() {
	        return size == 0;
	    }
	}

	public class MainDemo {
	    public static void main(String[] args) {

	        System.out.println("===== STACK TEST =====");
	        MyStack<Integer> stack = new MyStack<>();

	        stack.push(10);
	        stack.push(20);
	        stack.push(30);

	        stack.printList();
	        System.out.println("Peek: " + stack.peek());
	        System.out.println("Pop: " + stack.pop());
	        stack.printList();


	        System.out.println("\n===== QUEUE TEST =====");
	        MyQueue<String> queue = new MyQueue<>();

	        queue.enqueue("A");
	        queue.enqueue("B");
	        queue.enqueue("C");

	        queue.printList();
	        System.out.println("Front: " + queue.front());
	        System.out.println("Dequeue: " + queue.dequeue());
	        queue.printList();
	    }
	}
	
}

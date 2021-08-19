public class Driver {
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);

        System.out.println("\nElements Pushed from Array Stack: 1,7,3,4,9,2");
        System.out.println("\nPopped elements from ArrayStack\n");

        stack.push(1);
        stack.push(7);
        stack.push(3);
        stack.push(4);
        stack.push(9);
        stack.push(2);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        LinkedStack link = new LinkedStack();

        System.out.println("\nElements Pushed from LinkedStack: 1,7,3,4,9,2");

        link.push(1);
        link.push(7);
        link.push(3);
        link.push(4);
        link.push(9);
        link.push(2);

        System.out.println("\nRemove elements from Bottom Half\n");

        link.removeBottomHalf();

        System.out.println("\nPopped elements from the remaining stack\n");

        int val;
        val = link.pop();

        while(val != -999) {
            System.out.println(val);
            val = link.pop();
        }
    }

}

class ArrayStack {

    private int[] arr;
    private int top;
    private int size;

    public ArrayStack(int size) {

        this.size = size;
        this.top = -1;
        this.arr = new int[size];

    }
    public boolean isFull(){
        return ( size -1 ==top);
    }
    public boolean isEmpty(){
        return ( top == -1);
    }
    public void push(int num){

        if(!isFull()) {
            arr[++top] = num;

        } else {
            System.out.println("Full Stack");
        }
    }
    public int pop(){
        if(!isEmpty()) {
            int val = arr [top];
            top--;
            System.out.println(val);
            return val;
        } else {
            System.out.println("Empty Stack");
            return -1;
        }
    }
}

class LinkedStack {

    class Node {

        int data;
        Node next;
        Node(int theData) {
            data = theData;
        }
    }

    private Node topNode;
    private int n;
    public LinkedStack() {
        topNode = null;
        n = 0;
    }

    public void push(int newEntry) {

        Node temp = new Node(newEntry);
        temp.next = topNode;
        topNode = temp;
        n++;
    }

    public int size() {
        return n;
    }
    public boolean isEmpty(){
        return topNode ==null;
    }

    public int pop() {

        if(isEmpty()) {
            return -999;
        }

        int result = topNode.data;
        topNode = topNode.next;
        n--;
        return result;
    }

    public void removeBottomHalf(){
        int half = n/2; // O(n/2)
        for (int i = 0; i < half; i++){
            System.out.println("Removed: " + pop());
        }
    }
}

/* Time complexity of removeBottomHalf method is O(n) */





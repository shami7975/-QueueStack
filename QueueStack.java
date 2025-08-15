package queuestack;

import java.util.Stack;

public class QueueStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int item) {
        stack1.push(item);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return stack2.pop();
    }

    // Peek at the front element
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("Front element: " + queue.peek());  // 10
        System.out.println("Dequeued: " + queue.dequeue());    // 10
        System.out.println("Front after dequeue: " + queue.peek()); // 20
    }
}

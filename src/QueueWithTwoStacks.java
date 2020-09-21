/*
 * A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
 */

import java.util.Scanner;
import java.util.Stack;

class Queue {
    public Stack<Integer> enqueue = new Stack<Integer>();
    public Stack<Integer> dequeue = new Stack<Integer>();

}

public class QueueWithTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int queriesNumber = Integer.parseInt(scanner.next());
        Queue queue = new Queue();

        for (int i = 1; i <= queriesNumber; i++) {
            String querie = scanner.next();

            if (querie.charAt(0) == '1') {
                int x = Integer.parseInt(scanner.next());
                enqueue(x, queue);
            } else if (querie.charAt(0) == '2') {
                dequeue(queue);
            } else if (querie.charAt(0) == '3') {
                System.out.println(print(queue));
            }

        }
    }

    public static void enqueue(int x, Queue q) {
        q.enqueue.add(x);

        if (q.dequeue != null) {
            while (!q.dequeue.isEmpty()) {
                q.enqueue.add(q.dequeue.pop());
            }
        }
    }

    public static int dequeue(Queue q) {        
        while (!q.enqueue.isEmpty()) {
            q.dequeue.add(q.enqueue.pop());
        }

        int element = q.dequeue.pop();
        
        while (!q.dequeue.isEmpty()) {
            q.enqueue.add(q.dequeue.pop());
        }
        
        return element;
    }

    public static int print(Queue q) {
        if (q.enqueue != null && q.enqueue.size() > 0)
            return readTheBottomElement(q.enqueue, q.dequeue);
        else
            return readTheBottomElement(q.dequeue, q.enqueue);
    }

    public static int readTheBottomElement(Stack<Integer> from, Stack<Integer> to) {
        
        while (!from.isEmpty()) {
            to.add(from.pop());
        }

        int element = to.peek();
        
        while (!to.isEmpty()) {
            from.add(to.pop());
        }
        
        return element;
    }
}
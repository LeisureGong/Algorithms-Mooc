

/*
* Queue with two stacks.
* Implement a queue with two stacks so that each queue
* operations takes a constant amortized number of stack operations.
*
*Note: these interview questions are ungraded and purely for your own enrichment.
*To get a hint, submit a solution.
*
* Hint:If you push elements onto a stack and then pop them all, they appear in reverse order.
* If you repeat this process, they're now back in order.
*
*
*
* */


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Quiz_QueueWithTwoStacks {

    public static class QueueWithTwoStacks<Item> {

        Stack<Item> s1 = new Stack<Item>();
        Stack<Item> s2 = new Stack<Item>();

        public void enqueue(Item item) {
            s1.push(item);
        }

        public Item dequeue() {

            Item item;

            if (!s2.isEmpty()) {
                item = (Item) s2.pop();
            } else {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
                item = (Item) s2.pop();
            }

            return item;

        }

    }

    public static void main(String[] args){
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue("Hello ");
        queue.enqueue("World");
        StdOut.println(queue.dequeue());
    }
}

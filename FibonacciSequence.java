

import java.util.*;

class FibonacciSequence {

    /**
     * #1. Fibonacci Sequence
     * <p>
     * The Fibonacci sequence is constructed by adding the last two numbers of the sequence so far
     * to get the next number in the sequence. The first and second numbers of the sequence are
     * defined as 0 and 1. We get:
     * 0, 1, 1, 2, 3, 5, 8, 13, 21...
     * Write a function that returns the nth number of the sequence. A single function or you may
     * choose to have a “setup function” and a “processing function,” as you see fit.
     */

    public static void main(String[] args) {
        System.out.println("*** Exercise 1 ***");
        System.out.println("Nth number of the sequence is: " + getFibonacciNth(8));

    }

    public static Integer getFibonacciNth(int num) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(1);

        for (Integer index = 2; index <= num; index++) {

            sequence.add(sequence.get(index - 1) + sequence.get(index - 2));
        }
        //System.out.println(sequence);

        return sequence.get(sequence.size() - 1);
    }

}
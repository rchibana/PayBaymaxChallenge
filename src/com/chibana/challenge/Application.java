package com.chibana.challenge;

import com.chibana.challenge.queue.ImmutableQueue;
import com.chibana.challenge.queue.Queue;

/**
 * Created by Rodrigo Chibana
 * Date: 07/01/2020
 **/
public class Application {

    public static void main(String[] args) throws Exception {

        Queue queue = new ImmutableQueue();

        test(queue.isEmpty());

        //Adding items into the queue
        queue = setupQueue(4, queue);

        test(!queue.isEmpty());
        test(queue.head().equals("1"));

        queue = queue.deQueue();
        test(queue.head().equals("2"));

        queue = queue.deQueue();
        queue = queue.deQueue();
        test(queue.head().equals("4"));

        queue = queue.deQueue();
        test(queue.isEmpty());

    }

    private static void test(boolean value) throws AssertionError {
        if(!value) {
            throw new AssertionError("Invalid assertion!");
        }
    }

    private static Queue setupQueue(int quantity, Queue queue){

        for(int value = 1 ; value <= quantity; value++) {
            queue = queue.enQueue(String.valueOf(value));
        }

        return queue;
    }

}

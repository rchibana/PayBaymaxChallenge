package com.chibana.challenge.queue;

import com.chibana.challenge.exception.EmptyQueueException;

/**
 * Created by Rodrigo Chibana
 * Date: 07/01/2020
 **/
public interface Queue<T> {

    /**
     * Adds a new element into the queue
     * @param value Object to be added
     * @return A queue containing the previous elements more the new one.
     */
    Queue<T> enQueue(T value);

    /**
     * Removes the element at the beginning of the immutable queue, and returns the new queue.
     * @return A queue containing the previous elements apart from the head
     */
    Queue<T> deQueue() throws EmptyQueueException;

    /**
     * Peeks the first element
     * @return Value from head position
     */
    T head() throws EmptyQueueException;

    /**
     * Verifies whether the queue is empty
     * @return A {@link Boolean} value
     */
    boolean isEmpty();

}

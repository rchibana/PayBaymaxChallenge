package com.chibana.challenge.queue;

import com.chibana.challenge.exception.EmptyQueueException;
import com.chibana.challenge.node.Node;

/**
 * Created by Rodrigo Chibana
 * Date: 07/01/2020
 **/
public final class ImmutableQueue<T> implements Queue<T> {

    private final Node<T> node;

    public ImmutableQueue() {
        this.node = null;
    }

    private ImmutableQueue(Node<T> node) {
        this.node = node;
    }

    @Override
    public Queue<T> enQueue(T value) {

        final Node<T> newNode = new Node<>(value);

        if (!isEmpty()) {
            newNode.setNext(this.node);
            this.node.setPrevious(newNode);
        }

        return new ImmutableQueue<>(newNode);
    }

    @Override
    public Queue<T> deQueue() throws EmptyQueueException {

        final Node<T> head = getHead().getPrevious();

        if(head != null) {
            head.setNext(null);
            return new ImmutableQueue<>(this.node);
        }

        return new ImmutableQueue<>();

    }

    @Override
    public T head() throws EmptyQueueException {
        return getHead().getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }

    /**
     * Gets the head node
     * @return A {@link Node} object from the first position of queue
     * @throws EmptyQueueException In case of empty queue, instead of returning null, it will throw an exception
     */
    private Node<T> getHead() throws EmptyQueueException {

        if(isEmpty()) {
            throw new EmptyQueueException();
        }

        Node<T> headNode = this.node;

        while (headNode.hasNext()) {
            headNode = headNode.getNext();
        }

        return headNode;

    }

}

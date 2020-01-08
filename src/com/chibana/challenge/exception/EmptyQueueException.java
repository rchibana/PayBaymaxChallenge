package com.chibana.challenge.exception;

/**
 * Created by Rodrigo Chibana
 * Date: 08/01/2020
 **/
public class EmptyQueueException extends Exception{

    public EmptyQueueException() {
        super("The queue is empty!");
    }
}

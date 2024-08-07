package org.example3;

public interface Handler<T> {
    void setNext(Handler<T> nextHandler);
    boolean validate(T data);
}

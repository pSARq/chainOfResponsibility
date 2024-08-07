package org.example2;

public interface Handler {
    void setNext(Handler handler);
    boolean handleRequest(Request request);
}

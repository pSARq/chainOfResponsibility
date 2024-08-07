package org.example1;

public class BasicSupportHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if (canHandle(request)) {
            System.out.println("BasicSupportHandler está procesando la solicitud: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    private boolean canHandle(String request) {
        return request.contains("basic");
    }
}

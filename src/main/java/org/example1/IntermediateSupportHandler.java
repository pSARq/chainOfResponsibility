package org.example1;

public class IntermediateSupportHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if (canHandle(request)) {
            System.out.println("IntermediateSupportHandler está procesando la solicitud: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    private boolean canHandle(String request) {
        return request.contains("intermediate");
    }
}

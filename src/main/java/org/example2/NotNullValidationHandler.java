package org.example2;

public class NotNullValidationHandler implements Handler {
    private Handler nextHandler;

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    public boolean handleRequest(Request request) {
        if (validateNotNull(request)) {
            if (nextHandler != null) {
                return nextHandler.handleRequest(request);
            }
            return true;
        }
        return false;
    }

    private boolean validateNotNull(Request request) {
        return request.getData() != null;
    }
}

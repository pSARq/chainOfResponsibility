package org.example2;

public class AlphanumericValidationHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public boolean handleRequest(Request request) {
        if (validateAlphanumeric(request)) {
            if (nextHandler != null) {
                return nextHandler.handleRequest(request);
            }
            return true;
        }
        return false;
    }

    private boolean validateAlphanumeric(Request request) {
        return request.getData().matches("^[a-zA-Z0-9]*$");
    }
}

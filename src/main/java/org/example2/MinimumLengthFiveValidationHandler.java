package org.example2;

public class MinimumLengthFiveValidationHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public boolean handleRequest(Request request) {
        if (validateLength(request)) {
            if (nextHandler != null) {
                return nextHandler.handleRequest(request);
            }
            return true;
        }
        return false;
    }

    private boolean validateLength(Request request) {
        return request.getData().length() > 5;
    }

}

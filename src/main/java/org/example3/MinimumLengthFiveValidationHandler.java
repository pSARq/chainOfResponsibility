package org.example3;

public class MinimumLengthFiveValidationHandler extends AbstractHandler<Request> {
    @Override
    protected boolean validateData(Request request) {
        return request.getData().length() > 5;
    }
}

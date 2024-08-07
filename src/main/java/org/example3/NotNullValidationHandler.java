package org.example3;

public class NotNullValidationHandler extends AbstractHandler<Request> {
    @Override
    protected boolean validateData(Request request) {
        return request.getData() != null;
    }
}

package org.example3;

public class AlphanumericValidationHandler extends AbstractHandler<Request> {
    @Override
    protected boolean validateData(Request request) {
        return request.getData().matches("\\w*");
    }
}

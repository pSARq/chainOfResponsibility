package org.example3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request validRequest = new Request("Datavalida123");
        Request invalidRequest = new Request("Data invalida 123");
        List<Request> requestList = List.of(validRequest, invalidRequest);

        Handler<Request> handlerChain = HandlerChainBuilder.buildChainHandler(
                new NotNullValidationHandler(),
                new MinimumLengthFiveValidationHandler(),
                new AlphanumericValidationHandler()
        );

        requestList.forEach(request -> {
            System.out.println("Procesando solicitud: " + request.getData());
            if (handlerChain.validate(request)) {
                System.out.println("La solicitud supera todas las validaciones");
            } else {
                System.out.println("La solicitud no supera todas las validaciones");
            }
            System.out.println();
        });
    }
}

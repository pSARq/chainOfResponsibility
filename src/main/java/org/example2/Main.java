package org.example2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*En este ejemplo la data pasa clase por clase hasta terminar todas las validaciones. En el siguiente ejemplo se
        * acomodará un poco el patrón para evitar tanto código duplicado en las clases validadoras y también mejora
        * un poco el cómo construir y asignar la siguiente clase a la cadena*/
        Request validRequest = new Request("Datavalida123");
        Request invalidRequest = new Request("Data invalida 123");
        List<Request> requestList = List.of(validRequest, invalidRequest);

        Handler notNullHandler = new NotNullValidationHandler();
        Handler minimumLengthFiveValidationHandler = new MinimumLengthFiveValidationHandler();
        Handler alphanumericValidationHandler = new AlphanumericValidationHandler();

        notNullHandler.setNext(minimumLengthFiveValidationHandler);
        minimumLengthFiveValidationHandler.setNext(alphanumericValidationHandler);

        requestList.forEach(request -> {
            System.out.println("Procesando solicitud: " + request.getData());
            if (notNullHandler.handleRequest(request)) {
                System.out.println("La solicitud supera todas las validaciones");
            } else {
                System.out.println("La solicitud no supera todas las validaciones");
            }
            System.out.println();
        });
    }
}

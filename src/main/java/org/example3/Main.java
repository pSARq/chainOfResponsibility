package org.example3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*En este ejemplo se extrajo toda la logica en común en una clase abstracta y en las clases hijas
        * solo se les implementa un metodo que es donde realizan su respectiva validación, además de que se
        * crea un constructor estático para recibir N cantidad de objetos de tipo Handler y asi se van agregando
        * dinámicamente a la cadena desde el primer elemento hasta el último evitando tener que hacer el llamado
        * del método setHandler() desde aquí, lo cual hace que el código se vea más organizado y sea más limpio*/
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

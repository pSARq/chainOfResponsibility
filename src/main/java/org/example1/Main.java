package org.example1;

public class Main {
    public static void main(String[] args) {
        /*Este es un ejemplo de cadena en donde teniendo una lista de valores se pasan uno a uno y alguna clase de la
        * cadena procesa el valor, pero eso significa que un valor solo es procesado por una clase entonces en el ejemplo 2
        * hay una variación en donde un valor es procesado por N clases*/
        Handler basicSupportHandler = new BasicSupportHandler();
        Handler intermediateSupportHandler = new IntermediateSupportHandler();
        Handler advancedSupportHandler = new AdvancedSupportHandler();
        Handler unknownSupportHandler = new UnknownSupportHandler();

        basicSupportHandler.setNext(intermediateSupportHandler);
        intermediateSupportHandler.setNext(advancedSupportHandler);
        advancedSupportHandler.setNext(unknownSupportHandler);

        String[] requests = {"basic issue", "intermediate issue", "advanced issue", "unknown issue"};

        for (String request : requests) {
            System.out.println("Procesando solicitud: " + request);
            basicSupportHandler.handleRequest(request);
            System.out.println();
        }

    }

}
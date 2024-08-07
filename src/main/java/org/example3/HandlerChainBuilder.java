package org.example3;

public class HandlerChainBuilder {

    private HandlerChainBuilder() {
    }

    /*Un constructor que recibe N cantidad de objetos de tipo Handler y construye la cadena.
    * También se puede declarar directamente en la clase abstracta*/
    @SafeVarargs
    public static <T> Handler<T> buildChainHandler(Handler<T> firstHandler, Handler<T>... handlers) {
        Handler<T> currentHandler = firstHandler;
        for (Handler<T> handler : handlers) {
            currentHandler.setNext(handler);
            currentHandler = handler;
        }
        return firstHandler;
    }
}

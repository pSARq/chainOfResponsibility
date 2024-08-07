package org.example1;

public class UnknownSupportHandler implements Handler {
    @Override
    public void setNext(Handler handler) {
        //Final de la cadena, no se hace nada aquí, ya que es la clase que procesa las solicitudes desconocidas
    }

    @Override
    public void handleRequest(String request) {
        System.out.println("UnknownSupportHandler está procesando la solicitud: " + request);
    }
}
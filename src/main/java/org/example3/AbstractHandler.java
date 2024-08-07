package org.example3;

public abstract class AbstractHandler<T> implements Handler<T> {
    private Handler<T> nextHandler;

    @Override
    public void setNext(Handler<T> nextHandler) {
        this.nextHandler = nextHandler;
    }

    /*Este método es el método público, es decir, el que se usa desde afuera que se encarga de validar la solicitud,
    primero válida la data y luego llama al siguiente validador, en este caso se declaró aquí porque esta estructura base
    se repetía mucho en las otras clases validadoras, pero si es algo no tan repetitivo entonces se puede dejar directamente
    que el método lo declare las clases hijas*/
    @Override
    public boolean validate(T data) {
        if (validateData(data)) {
            return validateNext(data);
        }
        return false;
    }

    /*Este se llama al final del método "validate" (al finalizar una validación exitosa), para verificar si hay un siguiente elemento
    * en la cadena, si es asi procede a pasar con la siguiente clase validadora si no retorna true indicando que ha terminado de pasar
    * por todas las validaciones y las ha superado exitosamente*/
    protected boolean validateNext(T data) {
        if (nextHandler == null) {
            return true;
        }
        return nextHandler.validate(data);
    }

    /*Este es el método que se sobreescribe en cada clase hija en donde se agregará la validación correspondiente*/
    protected abstract boolean validateData(T data);

}

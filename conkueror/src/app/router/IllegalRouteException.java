package app.router;

public class IllegalRouteException extends Exception{

    public IllegalRouteException(String message){
        super(message);
    }

    public IllegalRouteException(String message, Throwable cause){
        super(message, cause);
    }

    public IllegalRouteException(Throwable cause){
        super(cause);
    }

    public IllegalRouteException(){
        super();
    }

    @Override
    public String toString() {
        return "IllegalRouteException: " + getMessage();
    }

}

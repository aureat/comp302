package app.router;

/**
 * Exception for router configuration errors.
 * @see Router
 */
public class RouterConfigException extends Exception{

    public RouterConfigException(String message){
        super(message);
    }

    public RouterConfigException(String message, Throwable cause){
        super(message, cause);
    }

    public RouterConfigException(Throwable cause){
        super(cause);
    }

    public RouterConfigException(){
        super();
    }

    @Override
    public String toString() {
        return "RouterConfigException: " + getMessage();
    }

}

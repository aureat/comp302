package app.router;

public interface RouterRedirect {

    public void redirect(String name, Object... args);

    public void redirect(String name);

}

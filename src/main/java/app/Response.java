package app;

public class Response {

    public final boolean isProcess;
    public final String response;

    public Response(boolean isProcess, String response){
        this.isProcess = isProcess;
        this.response = response;
    }
}

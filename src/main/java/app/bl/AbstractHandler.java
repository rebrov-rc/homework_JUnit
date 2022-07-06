package app.bl;

import app.Connect;
import app.Response;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHandler implements Connect {

    private int mode = 0;
    private boolean proc = false;
    private List<String> commands = new ArrayList<>();
    private String currentCommand = null;


    public AbstractHandler(){

    }
    public AbstractHandler(String [] cmd){
        this.putCommands(cmd);
    }

    private void putCommands(String []cmd){
        for ( String c: cmd ) {
            commands.add(c);
        }
    }

    public Response response(String str){
        return new Response(this.proc, str);
    }

    public void start(){
        this.mode = 1;
        this.proc = true;
    }

    public void close(){
        this.mode = 0;
        this.proc = false;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getCurrentCommand() {
        return currentCommand;
    }

    public void setCurrentCommand(String currentCommand) {
        this.currentCommand = currentCommand;
    }
}

package app.bl;

import app.Response;

import java.util.List;

class ToDoHandler extends AbstractHandler {

    private final String[] commands = Commands.toDoCommands;
    private final ToDoEditor editor;

    public ToDoHandler(List<String> ls) {
        super(Commands.toDoCommands);
        this.editor = new ToDoEditor(ls);
    }

    private String getCommands() {
        StringBuilder builder = new StringBuilder();

        int counter = 0;
        for (String el : commands) {
            ++counter;
            if (commands.length > counter) {
                builder.append(el + ", ");
            } else {
                builder.append(el + "");
            }
        }
        return builder.toString();
    }

    private boolean cmdCheck(String str) {
        for (String el : commands) {
            if (el.equals(str)) {
                super.setCurrentCommand(str);
                return true;
            }
        }
        return false;
    }

    @Override
    public Response connect(String req) {


        if (super.getMode() == 0) {
            super.start();
            return super.response(this.getCommands());
        }

        if (super.getMode() == 1) {
            boolean checkRes = this.cmdCheck(req);
            if (checkRes) {
                super.setMode(2);
            } else {
                return super.response("enter correct command!\n" + this.getCommands());
            }
        }

        if (super.getMode() == 2) {
            String curr = super.getCurrentCommand();
            Response resp = null;

            if (curr.equals(Commands.toDoCommands[0])) {         // create
                resp = editor.create(req);
            } else if (curr.equals(Commands.toDoCommands[1])) {   // delete
                resp = editor.delete(req);
            } else if (curr.equals(Commands.toDoCommands[2])) {   // show
                resp = editor.show();
            }

            if (!resp.isProcess){

                super.setMode(1);
                super.setCurrentCommand("");

                return super.response(resp.response + "\n" + this.getCommands());
            }else{
                return super.response(resp.response);
            }
        }


        return super.response(req);
    }
}

package app.bl;

import app.Connect;
import app.Response;

import java.util.ArrayList;
import java.util.List;

public class BL{

    private List<String> list = new ArrayList<>();
    private Connect toDoHandler = new ToDoHandler(list);


    public String run(String str){

        Response resp = toDoHandler.connect(str);

        return resp.response;
    }
}

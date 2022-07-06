package app.bl;

import app.Response;

import java.util.ArrayList;
import java.util.List;


public class ToDoEditor {

    private int mode = 0;
    private boolean proc = false;
    private final List<String> list;
    private ListMarker<String> marker;


    public ToDoEditor(List<String> ls){
        this.list = ls == null? new ArrayList<>() : ls;
    }

    public Response create(String str){

        if (this.mode == 0){
            this.proc = true;
            this.mode = 1;
            return this.response("Enter to do task:");
        }
        if (this.mode == 1){

            list.add(str);
            this.mode = 0;
            this.proc = false;
            return this.response("The task was created!");
        }
        return new Response(this.proc, "");
    }

    public Response delete(String str){

        if (this.mode == 0){
            this.proc = true;
            this.mode = 1;
            this.marker = new ListMarker(this.list);
            String res = this.marker.getMarkedList();

            return this.response(res);
        }
        if (this.mode == 1){
            int check = this.intCheck(str);
            boolean res = marker.delete(check);
            if (res){
                this.mode = 0;
                this.proc = false;
                return this.response("The task was deleted!");

            }else{
                return this.response("Enter correct number!");
            }
        }

        return this.response("");

    }

    public Response show(){
        this.marker = new ListMarker(this.list);
        String res = this.marker.getMarkedList();

        return this.response(res);
    }

    private Response response(String str){
        return new Response(this.proc, str);
    }
    private int intCheck(String str){

        int result = -1;
        try{
            result = Integer.parseInt(str);
        }catch(NumberFormatException ex){
            return result;
        }

        return result;
    }

}

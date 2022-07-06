package app.bl;

import java.util.ArrayList;
import java.util.List;


public class ListMarker<E> {

    List<E> list;

    public ListMarker(List<E> ls){
        this.list = ls == null? new ArrayList<>() : ls;
    }

    public String getMarkedList(){
        StringBuilder bld = new StringBuilder();
        int counter = 0;

        for (E el : list) {
            bld.append( ++counter + ") " + el.toString() + "\n");
        }

        return bld.toString();
    }

    public boolean delete(int num){

        int index = num - 1;

        if (list.size() <= index || index < 0){
            return false;
        }

        list.remove(index);
        return true;
    }

}

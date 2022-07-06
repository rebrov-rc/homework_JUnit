import app.bl.BL;
import app.bl.Commands;
import app.bl.ListMarker;
import app.bl.ToDoEditor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



public class Test1 {

    @Test
    @DisplayName("Проверка маркера на создание")
    public void taskCreateTest(){
        ListMarker<String> marker = new ListMarker(null);

        Assertions.assertEquals("", marker.getMarkedList(), "тест создание листа");

    }

    @Test
    @DisplayName("Проверка маркера на удаление")
    public void taskDelTest(){

        List<String> ls = new ArrayList<>();
        ls.add("t");
        ListMarker<String> marker = new ListMarker(ls);


        Assertions.assertEquals(false, marker.delete(-500), "тест меньше нуля");
        Assertions.assertEquals(false, marker.delete(500), "тест больше нуля");
        Assertions.assertEquals(false, marker.delete(1), "тест удаление элемента");
    }

    @Test
    @DisplayName("Проверка ToDoEditor")
    public void toDoEditorTest(){
        ToDoEditor editorCreate = new ToDoEditor(null);
        ToDoEditor editorDel = new ToDoEditor(null);
        ToDoEditor editorShow = new ToDoEditor(null);

        Assertions.assertNotNull(editorCreate.create(""), "creation");
        Assertions.assertNotNull(editorDel.delete(""), "delete");
        Assertions.assertNotNull(editorShow.show(), "show");
    }

    @Test
    @DisplayName("Проверка BL")
    public void blTest(){
        BL bl = new BL();

        Assertions.assertNotNull(bl.run(""), "запуск BL");

    }

    @Test
    @DisplayName("Проверка commands")
    public void commandsTest(){
        String [] cmd = Commands.toDoCommands;

        Assertions.assertNotNull(cmd, "commands");

    }

}

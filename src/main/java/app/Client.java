package app;

import java.util.Scanner;

public class Client {

    private final Scanner scanner = new Scanner(System.in);

    public String req(){
        return scanner.nextLine();
    }

    public void resp(String str){
        System.out.println(str);
    }

}

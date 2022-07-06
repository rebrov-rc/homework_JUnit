package app;

import app.bl.BL;

public class App {

    Client client = new Client();
    BL bl = new BL();

    public void run(){

        client.resp(bl.run(""));

        while(true){
            String req = client.req();

            if (req.equals("--off")){
                break;
            }

            String resp = bl.run(req);

            client.resp(resp);
        }

    }
}

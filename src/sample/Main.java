package sample;


import View.Entrance;

import java.io.*;
import java.net.*;


public class Main extends Client {

    public static void main(String[] args) throws IOException {
        try{
            socket=new Socket("127.0.0.1",4000);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Entrance entrance = new Entrance();
            entrance.main();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

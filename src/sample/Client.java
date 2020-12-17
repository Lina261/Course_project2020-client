package sample;


import java.io.*;
import java.net.*;

public class Client {
    protected static Socket socket;
    protected static BufferedReader in;
    protected static PrintWriter out;

    public void sendStr(String str){out.println(str);}
    public void sendInt(int a){out.println(Integer.toString(a));}
    public boolean getBoolean() throws IOException {
        return Boolean.getBoolean(in.readLine());
    }
    public int getInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public String getString() throws IOException {
        return in.readLine();
    }

    public void sendBoolean(Boolean role) {
        out.println(role);
    }
}

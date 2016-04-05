/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package httpanalyzer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;
import sun.misc.IOUtils;
/**
 *
 * @author mohamad
 */
public class AnalyzeHttp {

    public AnalyzeHttp() throws IOException {
        Analyze();
    }
    
    public static void Analyze () throws IOException{
      
      Scanner reader = new Scanner(System.in);  
//      System.out.println("Enter the Request Method (ex : GET ) : ");
//      String method = reader.next();
      System.out.println("Enter the URL (ex : http://w3.org ) : ");
      String urlString = reader.next();
      URL url = new URL (urlString);
      HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();
      HttpURLConnection connection2 = (HttpURLConnection) url.openConnection();
      connection1.setRequestMethod("GET");
      connection2.setRequestMethod("OPTIONS");
//    connection1.connect();
//      System.out.println(connection1.getIfModifiedSince() +"\n"+connection1.getPermission());
      String allowedMethod = connection2.getHeaderField("Allow");
      if (allowedMethod == null)
            System.out.println("The web servers dose not support any method \n");
      else
      System.out.println("Supported Methods ------> " + allowedMethod +"\n");
//      System.out.println("Response : " + connection1.getResponseCode() +" "+ connection1.getResponseMessage() + "\n");
      System.out.println("Header field key ------> Header field value");
//      System.out.println(connection1.getHeaderField("WWW-Authenticate"));
        System.out.println("Web Server Info ------>  "+connection1.getHeaderField(0));
    for (int i = 1 ; i <= 12 ; i++){
        System.out.println(connection1.getHeaderFieldKey(i)+" ------> "+connection1.getHeaderField(i));
    }
//    System.out.println( connection1.getHeaderField("Set-Cookie"));
      
      /*
    try {
      InetAddress addr;
      Socket sock = new Socket("zamanak.", 80);
      addr = sock.getInetAddress();
      System.out.println("Connected to " + addr);
      sock.close();
    } catch (java.io.IOException e) {
      System.out.println("Can't connect to " + args[0]);
      System.out.println(e);
    }
    */
    }
}

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
import sun.misc.IOUtils;

public class HttpAnalyzer extends UI{
  public static void Analyze() throws MalformedURLException, IOException {
      
    URL url = new URL("http://www.zamanak.ir/");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
//    connection.connect();
//      System.out.println(connection.getIfModifiedSince() +"\n"+connection.getPermission());
      System.out.println("Response : " + connection.getResponseCode() +" "+ connection.getResponseMessage());
      System.out.println("Header field key ------> Header field value");
//      System.out.println(connection.getHeaderField("WWW-Authenticate"));
    for (int i = 1 ; i <= 12 ; i++){
        System.out.println(connection.getHeaderFieldKey(i)+" ------> "+connection.getHeaderField(i));
    }
//    System.out.println( connection.getHeaderField("Set-Cookie"));
      
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

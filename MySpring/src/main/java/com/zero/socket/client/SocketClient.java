package com.zero.socket.client;

import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.InputStreamReader ;
import java.io.PrintWriter ;
import java.net.Socket ;
import java.net.UnknownHostException ;

public class SocketClient extends Thread{
	Socket sk = null;  
    BufferedReader reader = null;  
    PrintWriter wtr = null;  
    BufferedReader keyin = null;  
    
    
    
	public SocketClient() {
		 try {
			sk = new Socket("127.0.0.1", 4010);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public void run()  
    {  
        try  
        {  
            reader = new BufferedReader(new InputStreamReader(sk  
                    .getInputStream()));  
            wtr = new PrintWriter(sk.getOutputStream());  
            String get = keyin.readLine();  
  
            while (true)  
            {  
                if (get != null & get.length() > 0)  
                {  
                    wtr.println(get);  
                    wtr.flush();  
//                  wtr.close();  
//                  System.out.println(get + "发送完毕");  
                }  
                if (reader != null)  
                {  
                    String line = reader.readLine();  
                    System.out.println("从服务器来的信息：" + line);  
                      
                }  
                  
            }  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
	 public static void main(String [] args)  
	    {  
	        new SocketClient().start();  
	    }  
	
	
	
}

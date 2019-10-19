package com.zero.socket.server;

import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;
import java.io.PrintWriter ;
import java.net.ServerSocket ;
import java.net.Socket ;
import java.util.concurrent.ExecutorService ;
import java.util.concurrent.Executors ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

public class SocketServer {

	private static  final Logger logger = LoggerFactory.getLogger(Handler.class);

	private int port=4010;   
	
    public ServerSocket serverSocket;   
    
    private ExecutorService executorService;//线程池   
    
    private final int POOL_SIZE=80;//单个CPU线程池大小     
      
    public InputStream ips;
    
    public Socket socket=null;
    
    boolean isRunning = true;
    
    public SocketServer() throws IOException{
        serverSocket = new ServerSocket(port);
        //Runtime的availableProcessor()方法返回当前系统的CPU数目.     
        executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);       
    }     
          
    public void start(){  
    	logger.info("Socket Start...");
        while(isRunning){       
            try {     
                socket=serverSocket.accept();    
                executorService.execute(new Handler(socket));                       
            } catch (Exception e) {  
            	isRunning = false;
            	logger.error("Socket Exception:" + e.getMessage());
                e.printStackTrace();     
            }     
        }     
    }         
    class Handler implements Runnable{  
    	
    	private final Logger logger = LoggerFactory.getLogger(Handler.class);
    	
    	BufferedReader rdr = null;  
        PrintWriter wtr = null;  
        
        private Socket socket;
        
        private BufferedReader getBufferedReader(Socket socket) throws IOException {
        	return new BufferedReader(new InputStreamReader(socket.getInputStream())); 
        }
        
        private PrintWriter getPrintWriter(Socket socket) throws IOException {
        	return new PrintWriter(socket.getOutputStream()); 
        }
        
        public Handler(Socket socket){       
            this.socket=socket;  
        }

		@Override
		public void run() {
			try {
				wtr = getPrintWriter(socket);
				rdr = getBufferedReader(socket);
				String req = null;
				if((req = rdr.readLine()) != null) {
					logger.info("[RECV MSG]:" + req);
				}
				String res = "excute " + req + " success";
				wtr.println("[SEND MSG]:" + res + "\r\n");  
                wtr.flush();  
 			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }         
	
}

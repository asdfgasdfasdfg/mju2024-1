package minegame.server;

import java.io.*; 
import java.net.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


class MineServer {
	public static int inServerPort = 25565;
	public static Vector<Client> clientList = new Vector<Client>();
	
	public static void main(String[] args) throws Exception {
		new MineServer().createNewServer();
	}
	
	
	public void createNewServer() throws Exception {
		System.out.println("Server on");
	    ServerSocket server = new ServerSocket(inServerPort); 
	    while (true) {
	    	Socket socket = server.accept(); 
	    	Client c = new Client(socket);
	    	clientList.add(c);
	    }
	}
	
	
	
	
	
	class Client extends Thread {
		Socket socket; 
		PrintWriter out = null; 
		BufferedReader in = null; 
		int width = 0, mineNum = 0;
     	int count = 0, successCount = 0, failCount = 0;
		Map map;
		
		public Client(Socket socket) throws Exception { 			
			System.out.println("\n\n"+socket.getInetAddress()+ "  joined the game.");
			this.socket = socket;
         out = new PrintWriter(socket.getOutputStream(), true); 
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			           
         initialGame();
						
         start();                                  
		}
		
		
		public void printStatitics(PrintWriter out, int count, int successCount, int failCount) {
			out.println();
			out.println("총 시도 횟수: " + count);
			out.println("성공 횟수: " + successCount);
			out.println("실패 횟수: " + failCount);
		}
		
		public void initialGame() throws IOException {
			String msg = in.readLine();		
			String[] a = msg.split(",");
			width = Integer.parseInt(a[0]);				        
			mineNum = Integer.parseInt(a[1]);			
			
			map = new Map(width, mineNum);
     }
			

     @Override
     public void run() {
     	String msg;

         try {
         	while(true) {
         		msg = in.readLine();
         		if(msg.equalsIgnoreCase("Exit")) { 
         			out.println("게임을 종료합니다. 다음에 또 오세요!");
         			printStatitics(out, count, successCount, failCount);
         			break;
         		}
         		
         		String[] arr = msg.split(",");            		
         		int x = Integer.parseInt(arr[0]);
         		int y = Integer.parseInt(arr[1]);
         		if (x < 0 || y < 0) {
         			out.println("게임을 종료합니다. 다음에 또 오세요!");
         			printStatitics(out, count, successCount, failCount);
         			break;
         		}
         		
         		
         		int result = map.findMine(x,y);
         		out.println(""+result);
         		if(result > 0) {
         			map.updateVisibleMap(x, y);
         			successCount++;
         		} else {
         			failCount++;
         		}
         		count++;
         		out.println(count);
         		
         	}
         	
         	System.out.println("you found "+ mineNum +" mines! congratulations!");
 			printStatitics(out, count, successCount, failCount);
         	out.close();
         	in.close();
         	socket.close();
         }
     	catch (IOException e) { } 
     }
     
     
     
     
     
         
	}
     
} 

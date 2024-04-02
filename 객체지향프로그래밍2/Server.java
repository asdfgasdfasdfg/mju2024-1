package Server;

import java.io.*;
import java.net.*;
import java.util.Vector;

// 미완성인데 일단 저장

class Server {
    public static int inPort = 9999;
    public static Vector<Client> clients = new Vector<Client>();

    final double rock = 0;
    final double paper = 1;
    final double scissors = 2;
    
    int rcount = 0;
    int pcount = 0;
    int scount = 0;
    int selectedClients = 0;
    double result;

    public static void main(String[] args) throws Exception {
        new Server().createServer();
    }

    public void createServer() throws Exception {
        ServerSocket server = new ServerSocket(inPort);
        while (true) {
            Socket socket = server.accept();
            Client c = new Client(socket);
            clients.add(c);
        }
    }

    public void sendtoall(String msg) {
        for(Client c : clients)
            c.send(msg);
    }


    class Client extends Thread {
        Socket socket;
        PrintWriter out = null;
        BufferedReader in = null;
        boolean r = false;
        boolean p = false;
        boolean s = false;
        
        public Client(Socket socket) throws Exception {
            this.socket = socket;
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            start();
        }

        public void send(String msg) {
            out.println(msg);
        }

        public String rpsNumToString(double num) {
        	if (num == rock) {
        		resetSelectionRps();
        		r = true;
        		rcount++;
        		return "주먹";
        	} else if (num == paper) {
        		resetSelectionRps();
        		p = true;
        		pcount++;
        		return "보자기";
        	} else if (num == scissors) {
        		resetSelectionRps();
        		s = true;
        		scount++;
        		return "가위";
        	} else {
        		return "입력 오류";
        	}
        }
  
        public void rpsPlay(boolean r, boolean p, boolean s) {
        	if (rcount == 0) {
        		if (pcount != 0 && scount != 0) {
        			if (p == true) {
        				result = -1;
        			} else {
        				result = 1;
        			}
        		} else { // 1종류만 나오면 무승부.
        			result = 0;
        		}
            } else if (pcount == 0) {
        		if (scount != 0 && rcount != 0) {
        			if (s == true) {
        				result = -1;
        			} else {
        				result = 1;
        			}
        		} else { // 1종류만 나오면 무승부.
        			result = 0;
        		}            				
        	} else if (scount == 0) {
        		if (rcount != 0 && pcount != 0) {
        			if (r == true) {
        				result = -1;
        			} else {
        				result = 1;
        			}
        		} else { // 1종류만 나오면 무승부.
        			result = 0;
        		}        		
        	} else { // 셋 다 카운트되면 무승부.
        		result = 0;
        	}
        }
        
        public synchronized void rpsResult() {
        	Vector<String> clientStr = new Vector<String>();
        	
        	int i = 0;
    		for (Client c : clients) {
                if (result == 1) {
                    clientStr.add("승리");
                } else if (result == -1) {
                	clientStr.add("패배");
                } else {
                	clientStr.add("무승부");
                }
            }
    		
    		
    		
        	if (selectedClients == clients.size()) {
        		for (int j = 0; j < clients.size(); j++) {
        		    // 각 클라이언트에 대해 해당하는 결과를 전송합니다.
        			clients.get(j).send(clientStr.elementAt(j));
        		}
            	
        		selectedClients = 0;
        		rcount = 0;
                pcount = 0;
                scount = 0;
                result = 0;
        	}
        	
        }
     
        public void resetSelectionRps() {
            r = false;
            p = false;
            s = false;
    		selectedClients++;
        }

        @Override
        public void run() {
            String line;
            try {
                while(true) {
                    line = in.readLine();
                    System.out.println("("+ socket.getInetAddress()+ ") " + line);
                    double num = Double.parseDouble(line);
                    this.send("당신의 선택: " + rpsNumToString(num) + "!");
                    rpsPlay(r, p, s);
                    rpsResult();
                }
            }
            catch (IOException e) { }
            finally {
                try {
                    if (out != null)
                        out.close();
                    if (in != null) {
                        in.close();
                        socket.close();
                    }
                }
                catch (IOException e) { }
            }
        }
      
        
        

    }

}


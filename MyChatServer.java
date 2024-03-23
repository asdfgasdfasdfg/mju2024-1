import java.io.*;
import java.net.*;

public class MyChatServer {
    public static void main(String []args){
        final int myServerPort = 25565;

        try { // 서버 포트로 접속 가능하도록 소켓 생성
            ServerSocket myServerSocket = new ServerSocket(myServerPort);
            System.out.println("서버 활성화!");

            while (true) {
                Socket clientSocket = myServerSocket.accept(); // 유저의 접속 요청 수락
                System.out.println("클라이언트가 성공적으로 서버에 접속했습니다.");

                // 클라이언트와 통신할 스레드 생성
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        }
        catch (IOException error){
            System.out.println("연결에 실패했습니다.");
            error.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // 클라이언트로부터 데이터를 읽고 쓰기 위한 입출력 스트림 생성
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // 클라이언트로부터 받은 메시지를 읽어서 처리
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine); // 클라이언트가 보낸 메시지 출력
                out.println(inputLine); // 클라이언트가 보낸 메시지를 클라이언트에게 다시 보냄
            }

            in.close();
            out.close();
            clientSocket.close();
        }
        catch (IOException error) {
            System.out.println("연결 실패");
            error.printStackTrace();
        }
    }
}


package com.company.RSA_server_client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
/**
 *This class represents the server running on localhost.
 * For every new user connecting a ClientHandler thread is created.
 */
class Testserver {
    //public RSA obj;
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3335);
        Socket s = null;
        int cno = 0;
        while(true) {
            try {
                s=ss.accept();
                //cno++;  
                System.out.println("Adam wants to send you a message : " + s);
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                //System.out.println("Assigning new thread for this"); 
                Thread t = new ClientHandler(s, din, dout, cno);
                t.start();
            } catch(Exception e)
            {
                s.close();
                e.printStackTrace();
            }
        }
       // ss.close();  
    }
}

/**
 *This class represents the server-side of a connection with a user in the chat and messages encryption/decryption.
 */
class ClientHandler extends Thread {
    final DataInputStream din; 
    final DataOutputStream dout; 
    final int cnt;
    final Socket s;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //Scanner scan=new Scanner(System.in);
    public ClientHandler(Socket s, DataInputStream din, DataOutputStream dout, int cnt) {
        this.s = s;
        this.din = din;
        this.dout = dout;
        this.cnt = cnt;
    }

    @Override
    public void run() {
        RSA obj = new RSA();
        obj.Keygenerate();
        String pubkey = obj.getpubkey();
        String privkey = obj.getprivkey();
        String pk1 = "", str = "", str2 = "";
        try {
                pk1 = din.readUTF();
                System.out.println("Adam's public key is: " + pk1);
                dout.writeUTF(pubkey);  
                dout.flush();  
            } catch(Exception e) {
                e.printStackTrace();
            }

        while(true) {
            int flag = 0;
            try {
                str = din.readUTF();
                String msg = obj.decrypt(str, privkey);
                System.out.println(str);
                System.out.println("Want to Decrypt Message? Y/N");
                String ans = br.readLine();
                if (ans.equalsIgnoreCase("Y"))
                    System.out.println("Adam says: " + msg);
                str2 = br.readLine();
                if (msg.equals("stop"))
                    flag = 1;
                String encryptedString = Base64.getEncoder().encodeToString(obj.encrypt(str2, pk1)); 
                dout.writeUTF(encryptedString);  
                dout.flush();  
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
            if (flag == 1)
                break;
        }
    try {
        din.close(); 
        dout.close();   
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
} 
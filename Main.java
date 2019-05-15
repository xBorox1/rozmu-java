import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(7890);
        Socket client = socket.accept();
        DataInputStream inputStream = new DataInputStream(client.getInputStream());;
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
//
//        try
//        {
//            socket = new ServerSocket(7890);
//
//            System.out.println("Czekam na połączenie");
//            Socket client = socket.accept();
//            inputStream =
//            outputStream = ;
//            System.out.println("Połączono!");
//        }
//        catch(Exception e)
//        {
//            System.out.println("socket error");
//        }

        JFrame f=new JFrame();//creating instance of JFrame

        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(0,400,400, 100);//x axis, y axis, width, height

        JTextField text = new JTextField("teskt");
        text.setVisible(true);
        text.setSize(400,300);
        text.setEditable(false);

        JTextField input = new JTextField("");
        input.setVisible(true);
        input.setBounds(0, 300, 400, 100);

        f.add(b);//adding button in JFrame
        f.add(text);
        f.add(input);

        f.setSize(500,600);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = input.getText();
                System.out.println(message);
                try {
                    outputStream.writeChars(message);
                    outputStream.flush();
                    System.out.println("wysłano: "+message);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                text.setText(text.getText()+ "\n" + message);
                input.setText("");
            }
        });

        while(true)
        {
//            System.out.println("petla");
        }
    }
}

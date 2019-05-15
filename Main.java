import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
//
//        try
//        {
//            ServerSocket socket = new ServerSocket(7890);
//
//            Socket client = socket.accept();
//
//        }
//        catch(Exception e)
//        {
//            System.out.println("socket error");
//        }
//        
        JFrame f=new JFrame();//creating instance of JFrame

        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(0,400,400, 100);//x axis, y axis, width, height

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked");
            }
        });

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
    }
}

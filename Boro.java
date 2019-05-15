import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("brown10", 7890);
        DataInputStream inputStream =
                new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream =
                new DataOutputStream(socket.getOutputStream());

        JFrame f=new JFrame();//creating instance of JFrame

        JTextField input = new JTextField("");
        input.setVisible(true);
        input.setBounds(0, 300, 400, 100);

        JTextField text = new JTextField("teskt");
        text.setVisible(true);
        text.setSize(400,300);
        text.setEditable(false);

        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(0,400,400, 100);//x axis, y axis, width, height

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked");
                String message = input.getText();
                try {
                    outputStream.writeChars(message);
                    outputStream.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    outputStream.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                text.setText(text.getText() + "\n" + message);
                input.setText("");
            }
        });

        f.add(b);//adding button in JFrame
        f.add(text);
        f.add(input);

        f.setSize(500,600);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        for(;;) {
            String messageFrom = inputStream.readLine();
            System.out.println(messageFrom);
            text.setText(input.getText() + "\n" + messageFrom);
        }
    }
}

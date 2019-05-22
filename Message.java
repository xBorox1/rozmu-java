package GUI;

import javax.swing.*;

public class Message extends JTextField {
    public static int WIDTH = 300;
    public static int HEIGHT = 400;

    private String author;
    private String message;

    public Message(String author, String message) {
        super(message);
        setVisible(true);
        setEditable(false);
        setSize(WIDTH, HEIGHT);
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

}

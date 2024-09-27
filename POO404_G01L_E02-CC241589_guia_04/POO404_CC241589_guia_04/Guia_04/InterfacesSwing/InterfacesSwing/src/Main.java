import javax.swing.*;

public class Main extends JFrame{
    public Main(){
        JLabel lblHola = new JLabel("Hola");
        add(lblHola);
        this.setSize(600, 500);
        this.setTitle("Jframeeee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
        System.out.println("Hello World");
    }
}
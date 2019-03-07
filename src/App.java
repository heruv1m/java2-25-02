import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Hello world!
 */
public class App extends JFrame {
    public App() throws HeadlessException {
        setBounds(500, 200, 400, 400);
        setTitle("My application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setLayout(new GridLayout(3,1));
        JButton[] jb = new JButton[10];
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JButton("button:" + i);
            // add(jb[i]);
        }

        JPanel p1 = new JPanel();

        p1.setBackground(Color.GREEN);
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        // p1.setLayout(new FlowLayout());
        JTextArea jta1 = new JTextArea();

        p1.add(new JScrollPane(jta1));
        p1.add(jb[0]);
        jb[0].addActionListener(e->{
            jta1.append("skdjflsjdf\n\nsfkjhsdh\n\r" + System.currentTimeMillis());
        });



        JPanel p2 = new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setLayout(new GridLayout(1, 1));
        JTextField jTextField = new JTextField();


        jTextField.addActionListener(e->{
            JFrame jFrame = new JFrame();
            JTextArea jta = new JTextArea();
            jta.setText(jTextField.getText());
            jFrame.add(jta);
            jFrame.setBounds(500, 200, 300, 300);
            jFrame.setVisible(true);

            // add(jFrame);
            System.out.println(jTextField.getText());

            jTextField.setText("");
        });

        p2.add(jTextField);



        add(p1);
        add(p2);


        JButton jbf = new JButton("firstButton");
        jbf.setBounds(50, 50, 100, 100);
        jbf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pushed me");
            }
        });

        jbf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("you pressed me!");
            }
        });

        // add(jbf);


        setVisible(true);

    }

    public static void main(String[] args) {
        new App();
    }
}


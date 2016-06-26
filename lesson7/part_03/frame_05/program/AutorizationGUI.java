package lesson7.part_03.frame_05.program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutorizationGUI extends JFrame{

    private JFrame autor;
    private Buffer buffer;
    private boolean userIsLigin;

    public AutorizationGUI(Buffer buffer) throws HeadlessException {
        this.buffer = buffer;
        autor = new JFrame();

        autor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        autor.setMinimumSize(new Dimension(300,200));
        autor.setLocation(300,300);

        autor.getContentPane().add(addJPanelAutorization());
        autor.pack();
        autor.setVisible(true);
    }

    private JPanel addJPanelAutorization(){

        JPanel autorizaton = new JPanel();
        autorizaton.setBackground(Color.PINK);
        autorizaton.setLayout(new GridBagLayout());

        JLabel lLogin = new JLabel("Enter login: ");
        JTextField tfLogin = new JTextField(20);

        JLabel lPassword = new JLabel("Enter password: ");
        JPasswordField jpPassword = new JPasswordField(20);

        JButton jbLogin = new JButton("Login");
        jbLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = tfLogin.getText();
                String password = jpPassword.getText();
                Authorization autor = new Authorization(login, password, buffer);



            }
        });

        JButton jbRegistration = new JButton("Registration");
        jbRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" Run Registration ");
            }
        });

        autorizaton.add(lLogin, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));
        autorizaton.add(tfLogin, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));

        autorizaton.add(lPassword, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));
        autorizaton.add(jpPassword, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));

        autorizaton.add(jbLogin, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 0, 0, 0), 0, 0));
        autorizaton.add(jbRegistration, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(5, 120, 0, 0), 0, 0));

        return autorizaton;
    }
}
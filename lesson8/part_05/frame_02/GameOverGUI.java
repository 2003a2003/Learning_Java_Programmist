package lesson8.part_05.frame_02;

import lesson8.part_05.frame_02.bf.BattleField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverGUI implements ActionListener {

    private ActionEvent event;
    private JFrame frame;
    private BattleField battleField;

    public GameOverGUI(BattleField battleField) throws Exception {
        this.battleField = battleField;
        addPanelGameOver();
    }

    private void setPanelDateMenu(JPanel panel) {

        frame = new JFrame("BATTLE FIELD - GAME OVER");
        frame.setLocation(350, 150);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    private void addPanelGameOver() throws Exception {
        JPanel jpGameOver = new JPanel();
        jpGameOver.setBackground(Color.black);
        jpGameOver.setLayout(new GridBagLayout());

        JPanel jpText = new JPanel();
        jpText.setBackground(Color.black);

        JLabel jlText = new JLabel("Game OVER!!!");
        jlText.setForeground(Color.RED);
        jlText.setFont(new Font("Verdana", Font.PLAIN, 65));
        jlText.setVerticalTextPosition(JLabel.CENTER);
        jlText.setHorizontalTextPosition(JLabel.CENTER);
        jpText.add(jlText);

        JPanel jpButton = new JPanel();
        jpButton.setLayout(new GridLayout(2, 1));
        JButton jbExit = new JButton("EXIT");
        jbExit.setBackground(Color.ORANGE);
        jbExit.setFont(new Font("Verdana", Font.BOLD, 30));
        jbExit.addActionListener(this);
//        jbExit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
//                System.exit(0);
//            }
//        });

        JButton jbRestart = new JButton("RESTART GAME");
        jbRestart.setBackground(Color.green);
        jbRestart.setFont(new Font("Verdana", Font.BOLD, 30));
        jbRestart.addActionListener(this);
//        jbRestart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
//                try {
//                    StartMenuGUI startMenuGUI = new StartMenuGUI();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });


        jpButton.add(jbRestart);
        jpButton.add(jbExit);

        jpGameOver.add(jpText, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));

        jpGameOver.add(jpButton, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 80, 0, 0), 0, 0));

        //jpGameOver.add(jpText);
//        jpGameOver.add(jpButton);

        setPanelDateMenu(jpGameOver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("EXIT")) {
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
        if (e.getActionCommand().equals("RESTART GAME")) {
            event = e;
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public ActionEvent getEvent() {
        return event;
    }
}
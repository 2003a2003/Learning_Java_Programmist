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
        Font foneText = new Font("Verdana", Font.BOLD, 65);
        Font foneButton = new Font("Verdana", Font.BOLD, 30);

        JPanel jpGameOver = new JPanel();
        jpGameOver.setBackground(Color.black);
        jpGameOver.setLayout(new GridBagLayout());

        JPanel jpText = new JPanel();
        jpText.setBackground(Color.black);

        JLabel jlText = new JLabel("Game OVER!!!");
        jlText.setForeground(Color.RED);
        jlText.setFont(foneText);
        jlText.setVerticalTextPosition(JLabel.CENTER);
        jlText.setHorizontalTextPosition(JLabel.CENTER);
        jpText.add(jlText);
        jpGameOver.add(jpText, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));

        JPanel jpButton = new JPanel();
        jpButton.setLayout(new GridLayout(3, 1));

        JButton jbRestart = new JButton("RESTART GAME");
        jbRestart.setBackground(Color.green);
        jbRestart.setFont(foneButton);
        jbRestart.addActionListener(this);

        JButton jbViewLestGame = new JButton("View the last game.");
        jbViewLestGame.setBackground(Color.BLUE);
        jbViewLestGame.setForeground(Color.cyan);
        jbViewLestGame.setFont(foneButton);
        jbViewLestGame.addActionListener(this);

        JButton jbExit = new JButton("EXIT");
        jbExit.setBackground(Color.ORANGE);
        jbExit.setFont(foneButton);
        jbExit.addActionListener(this);

        jpButton.add(jbRestart);
        jpButton.add(jbViewLestGame);
        jpButton.add(jbExit);

        jpGameOver.add(jpButton, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 80, 0, 0), 0, 0));

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
        if (e.getActionCommand().equals("View the last game.")) {
            event = e;
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public ActionEvent getEvent() {
        return event;
    }
}
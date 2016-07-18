package lesson8.part_05.frame_02;

import lesson8.part_05.frame_02.bf.BattleField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuGUI implements ActionListener {

    private JFrame frame;
    private ActionEvent event;
    private BattleField battleField;

    public StartMenuGUI(BattleField battleField) throws Exception {
        this.battleField = battleField;
        addPanelStartGame();
    }

    private void setPanelDateMenu(JPanel panel) {
        frame = new JFrame("BATTLE FIELD");
        frame.setLocation(350, 150);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void addPanelStartGame() throws Exception {

        JPanel jpStartMenu = new JPanel();
        jpStartMenu.setBackground(Color.BLACK);
        jpStartMenu.setLayout(new GridBagLayout());

        JButton jbBT7 = new JButton("Agressor: BT7");
        jbBT7.setPreferredSize(new Dimension(250,50));
        jbBT7.setBackground(Color.RED);
        jbBT7.addActionListener(this);

        JButton jbTiger = new JButton("Agressor: TIGER");
        jbTiger.setPreferredSize(new Dimension(250,50));
        jbTiger.setBackground(Color.RED);
        jbTiger.addActionListener(this);

        JButton jbT34 = new JButton("Defender: T34");
        jbT34.setPreferredSize(new Dimension(250,50));
        jbT34.setBackground(Color.green);
        jbT34.addActionListener(this);

        JButton jbExit = new JButton("-EXIT-");
        jbExit.setPreferredSize(new Dimension(250,50));
        jbExit.setBackground(Color.BLUE);
        jbExit.setForeground(Color.WHITE);
        jbExit.addActionListener(this);

        jpStartMenu.add(jbBT7, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));
        jpStartMenu.add(jbTiger, new GridBagConstraints(1, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));
        jpStartMenu.add(jbT34, new GridBagConstraints(0, 1, 2, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 125, 0, 0), 0, 0));
        jpStartMenu.add(jbExit, new GridBagConstraints(0, 2, 2, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 125, 0, 0), 0, 0));

        //jpStartMenu.add(jbBT7);
//        jpStartMenu.add(jbTiger);
//        jpStartMenu.add(jbT34);
//        jpStartMenu.add(jbExit);

        setPanelDateMenu(jpStartMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agressor: BT7")) {
            event = e;
            frame.setVisible(false);
//            frame.dispose();
        } else if (e.getActionCommand().equals("Agressor: TIGER")) {
            event = e;
            frame.setVisible(false);
//            frame.dispose();
        } else if (e.getActionCommand().equals("Defender: T34")) {
            event = e;
            frame.setVisible(false);
        } else if (e.getActionCommand().equals("-EXIT-")) {
            frame.setVisible(false);
            System.exit(0);
        }
    }

    public ActionEvent getEvent() {
        return event;
    }
}

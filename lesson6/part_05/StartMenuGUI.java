package lesson6.part_05;

import lesson6.part_05.bf.BattleField;

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
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void addPanelStartGame() throws Exception {

        JPanel jpStartMenu = new JPanel();
        jpStartMenu.setLayout(new GridLayout(4, 1));

        JButton jbBT7 = new JButton("Agressor: BT7");
        jbBT7.addActionListener(this);

        JButton jbTiger = new JButton("Agressor: TIGER");
        jbTiger.addActionListener(this);

        JButton jbT34 = new JButton("Defender: T34");
        jbT34.addActionListener(this);

        JButton jbExit = new JButton("-EXIT-");
        jbExit.addActionListener(this);

        jpStartMenu.add(jbBT7);
        jpStartMenu.add(jbTiger);
        jpStartMenu.add(jbT34);
        jpStartMenu.add(jbExit);

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

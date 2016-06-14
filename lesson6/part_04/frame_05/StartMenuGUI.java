package lesson6.part_04.frame_05;

import lesson6.part_04.frame_05.bf.BattleField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuGUI {

    private JFrame frame;
    private StateOtherMenu stateOtherMenu = StateOtherMenu.NOTE;
    private ActionField af;

    public StartMenuGUI() throws Exception {
        addPanelStartGame();
    }

    private void setPanelDateMenu(JPanel panel) {

        BattleField battleField = new BattleField();

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
        jpStartMenu.setLayout(new GridLayout(4, 1));

        JButton jbBT7 = new JButton("Agressor: BT7");
        jbBT7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOtherMenu = StateOtherMenu.BT7;
                frame.setVisible(false);
                frame.dispose();
            }
        });

        JButton jbTiger = new JButton("Agressor: TIGER");
        jbTiger.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateOtherMenu = StateOtherMenu.TIGET;
                frame.setVisible(false);
//              frame.dispose();
            }
        });

        JButton jbT34 = new JButton("Defender: T34");

        JButton jbExit = new JButton("-EXIT-");

        jpStartMenu.add(jbBT7);
        jpStartMenu.add(jbTiger);
        jpStartMenu.add(jbT34);
        jpStartMenu.add(jbExit);

        setPanelDateMenu(jpStartMenu);
    }

    public StateOtherMenu getStateOtherMenu() {
        return stateOtherMenu;
    }
}

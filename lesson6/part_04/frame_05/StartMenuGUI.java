package lesson6.part_04.frame_05;

import lesson6.part_04.frame_05.bf.BattleField;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuGUI extends JPanel{

    private JFrame frame;
    private int startLogic = 0;
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
        jpStartMenu.setLayout(new GridBagLayout());

        JButton jbBT7 = new JButton("Agressor: BT7");
        jbBT7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.pack();
            }
        });

        jpStartMenu.add(jbBT7, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        JButton jbTiger = new JButton("Agressor: TIGER");
        jbTiger.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                startLogic = 2;
            }
        });
        jpStartMenu.add(jbTiger, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        JButton jbT34 = new JButton("Defender: T34");
        jpStartMenu.add(jbTiger, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        jpStartMenu.add(jbBT7);
        jpStartMenu.add(jbTiger);
        jpStartMenu.add(jbT34);
        jpStartMenu.setVisible(true);
        setPanelDateMenu(jpStartMenu);
    }

    public int getStartLogic() {
        return startLogic;
    }
}

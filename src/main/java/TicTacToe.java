import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.SwingUtilities.invokeLater;

public class TicTacToe {
    private Dimension size;

    private JButton button00 = new JButton("-");
    private JButton button01 = new JButton("-");
    private JButton button02 = new JButton("-");
    private JButton button10 = new JButton("-");
    private JButton button11 = new JButton("-");
    private JButton button12 = new JButton("-");
    private JButton button20 = new JButton("-");
    private JButton button21 = new JButton("-");
    private JButton button22 = new JButton("-");
    private JButton restartGameButton = new JButton("Restart");

    private JLabel playersTurn = new JLabel("X Turn Now");
    private JLabel scoreCount = new JLabel("Scoreboard:");
    private JLabel xCount = new JLabel("X: ");
    private JLabel oCount = new JLabel("O: ");
    private JLabel xScore = new JLabel("--");
    private JLabel oScore = new JLabel("--");

    private int xScoreCounter = 0;
    private int oScoreCounter = 0;

    private int setMark = 0;

    private void addComponentsToPane(Container pane) {
        pane.setLayout(null);
        pane.add(button00);
        button00.addActionListener(listener(button00));
        pane.add(button01);
        button01.addActionListener(listener(button01));
        pane.add(button02);
        button02.addActionListener(listener(button02));

        pane.add(button10);
        button10.addActionListener(listener(button10));
        pane.add(button11);
        button11.addActionListener(listener(button11));
        pane.add(button12);
        button12.addActionListener(listener(button12));

        pane.add(button20);
        button20.addActionListener(listener(button20));
        pane.add(button21);
        button21.addActionListener(listener(button21));
        pane.add(button22);
        button22.addActionListener(listener(button22));

        pane.add(restartGameButton);
        restartGameButton.addActionListener(restartGameListener);

        pane.add(scoreCount);
        pane.add(xCount);
        pane.add(oCount);
        pane.add(xScore);
        pane.add(oScore);
        pane.add(playersTurn);

        Insets insets = pane.getInsets();

        size = button00.getPreferredSize();
        button00.setBounds(90 + insets.left, 70 + insets.top,
                size.width + 25, size.height + 25);

        size = button01.getPreferredSize();
        button01.setBounds(170 + insets.left, 70 + insets.top,
                size.width + 25, size.height + 25);

        size = button02.getPreferredSize();
        button02.setBounds(250 + insets.left, 70 + insets.top,
                size.width + 25, size.height + 25);

        size = button10.getPreferredSize();
        button10.setBounds(90 + insets.left, 150 + insets.top,
                size.width + 25, size.height + 25);

        size = button11.getPreferredSize();
        button11.setBounds(170 + insets.left, 150 + insets.top,
                size.width + 25, size.height + 25);

        size = button12.getPreferredSize();
        button12.setBounds(250 + insets.left, 150 + insets.top,
                size.width + 25, size.height + 25);

        size = button20.getPreferredSize();
        button20.setBounds(90 + insets.left, 230 + insets.top,
                size.width + 25, size.height + 25);

        size = button21.getPreferredSize();
        button21.setBounds(170 + insets.left, 230 + insets.top,
                size.width + 25, size.height + 25);

        size = button22.getPreferredSize();
        button22.setBounds(250 + insets.left, 230 + insets.top,
                size.width + 25, size.height + 25);

        size = restartGameButton.getPreferredSize();
        restartGameButton.setBounds(125 + insets.left, 305 + insets.top,
                      size.width + 80, size.height + 15);

        playersTurn.setBounds(155, 10, 200, 60);
        playersTurn.setForeground(Color.RED);
        playersTurn.setFont(new Font(playersTurn.getFont().getName(), playersTurn.getFont().getStyle(), 18));

        scoreCount.setBounds(5, 90, 80, 15);
        xCount.setBounds(26, 110, 40, 15);
        xScore.setBounds(46, 110, 40, 15);
        oCount.setBounds(25, 130, 40, 15);
        oScore.setBounds(45, 130, 40, 15);
    }

    private static void createUI() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        TicTacToe fillFrame = new TicTacToe();
        fillFrame.addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
    }

    private void buttonsEnable(boolean enabled){
        button00.setEnabled(enabled);
        button01.setEnabled(enabled);
        button02.setEnabled(enabled);
        button10.setEnabled(enabled);
        button11.setEnabled(enabled);
        button12.setEnabled(enabled);
        button20.setEnabled(enabled);
        button21.setEnabled(enabled);
        button22.setEnabled(enabled);
    }

    private ActionListener listener(final JButton button) {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    if ((setMark%2) == 0){
                        button.setText("X");
                        playersTurn.setText("O Turn Now");

                    }else
                    {
                        button.setText("O");
                        playersTurn.setText("X Turn Now");
                    }
                setMark++;

                    if(button00.getText().equals("X") && button01.getText().equals("X") && button02.getText().equals("X") ||
                       button10.getText().equals("X") && button11.getText().equals("X") && button12.getText().equals("X") ||
                       button20.getText().equals("X") && button21.getText().equals("X") && button22.getText().equals("X") ||
                       button00.getText().equals("X") && button10.getText().equals("X") && button20.getText().equals("X") ||
                       button01.getText().equals("X") && button11.getText().equals("X") && button21.getText().equals("X") ||
                       button02.getText().equals("X") && button12.getText().equals("X") && button22.getText().equals("X") ||
                       button00.getText().equals("X") && button11.getText().equals("X") && button22.getText().equals("X") ||
                       button02.getText().equals("X") && button11.getText().equals("X") && button20.getText().equals("X")
                    ){
                        playersTurn.setText("X Won This!");
                    }

                    if(button00.getText().equals("O") && button01.getText().equals("O") && button02.getText().equals("O") ||
                        button10.getText().equals("O") && button11.getText().equals("O") && button12.getText().equals("O") ||
                        button20.getText().equals("O") && button21.getText().equals("O") && button22.getText().equals("O") ||
                        button00.getText().equals("O") && button10.getText().equals("O") && button20.getText().equals("O") ||
                        button01.getText().equals("O") && button11.getText().equals("O") && button21.getText().equals("O") ||
                        button02.getText().equals("O") && button12.getText().equals("O") && button22.getText().equals("O") ||
                        button00.getText().equals("O") && button11.getText().equals("O") && button22.getText().equals("O") ||
                        button02.getText().equals("O") && button11.getText().equals("O") && button20.getText().equals("O")
                    ){
                    playersTurn.setText("O Won This!");
                    }

                    if((setMark == 9) && playersTurn.getText().equals("X Turn Now") ||
                       (setMark == 9) && playersTurn.getText().equals("O Turn Now")
                    ){
                        playersTurn.setText("Draw Guys!");
                    }

                    if (playersTurn.getText().equals("X Won This!")){
                        xScoreCounter++;
                        xScore.setText(String.valueOf(xScoreCounter));
                        buttonsEnable(false);
                    }else if (playersTurn.getText().equals("O Won This!")){
                        oScoreCounter++;
                        oScore.setText(String.valueOf(oScoreCounter));
                        buttonsEnable(false);
                    }

                button.setEnabled(false);
            }
        };
        return actionListener;
    }

    private ActionListener restartGameListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button00.setText("-");
                button01.setText("-");
                button02.setText("-");
                button10.setText("-");
                button11.setText("-");
                button12.setText("-");
                button20.setText("-");
                button21.setText("-");
                button22.setText("-");
                setMark = 0;
                playersTurn.setText("X Turn Now");

                buttonsEnable(true);
            }
        };

    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                createUI();
            }
        });
    }
}
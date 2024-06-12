import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import java.net.URL;

public class Instructions extends JPanel
{
    public static void main (String [] args) {
        //random graphics setup stuff
        var panel = new Instructions();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null); 
        JFrame frame = new JFrame("TicTacToeMEGA");  
        frame.setSize(1015, 1100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        panel.revalidate();
        panel.repaint();

        JButton back = new JButton();
        back.setFont(new Font("Monospaced", Font.BOLD, 30));
        back.setText("Back");

        back.setBounds(370, 600,240 ,100 );
        back.setBackground(new Color (0, 255, 30));

        panel.add(back);
        panel.revalidate(); 
        panel.repaint();
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    Play.main(new String[0]);
                }
            });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Monospaced",Font.BOLD, 50));
        g.setColor(Color.YELLOW);
        g.drawString("How To Play Tic Tac Toe MEGA", 10, 200);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif",Font.BOLD, 20));
        g.drawString("Objective: Win three 3x3 boxes in a row (horizontally, vertically, or diagonally) on a 9x9 board. ", 10, 400);
        g.drawString("The board is a 9x9 grid, divided into nine 3x3 boxes.Players take turns placing X or O.", 10, 500);
        g.drawString("The square where Player 1 places their X determines which 3x3 box Player 2 must play in next.",10,600);
        g.drawString("Example: If Player 1 places an X in the top-right cell of a 3x3 box, Player 2 must place their O in the top-right 3x3 box.",10,700);
        g.drawString(" the required 3x3 box is full or already won, the player can place their marker anywhere on the board.", 10, 400);
        g.drawString("The game ends when a player wins three 3x3 boxes in a row. If all boxes are filled and no one has three in a row, the game is a draw.",10,900);
        /***
        Ultimate Tic-Tac-Toe: Simple Instructions
        Objective:
        Win three 3x3 boxes in a row (horizontally, vertically, or diagonally) on a 9x9 board.

        Setup:

        The board is a 9x9 grid, divided into nine 3x3 boxes.
        Players take turns placing X or O.
        Gameplay:

        First Move: Player 1 can place an X anywhere on the board.
        Subsequent Moves:
        The square where Player 1 places their X determines which 3x3 box Player 2 must play in next.
        Example: If Player 1 places an X in the top-right cell of a 3x3 box, Player 2 must place their O in the top-right 3x3 box.
        If the required 3x3 box is full or already won, the player can place their marker anywhere on the board.
        Winning a 3x3 Box:

        Get three of your markers in a row (horizontally, vertically, or diagonally) within a 3x3 box to win that box.
        Winning the Game:

        The first player to win three 3x3 boxes in a row (horizontally, vertically, or diagonally) wins the game.
        Special Rules:

        If a 3x3 box is full and no player wins it, it’s tied and remains neutral.
        Players must move within the dictated 3x3 box unless it’s full or won.
        End of Game:

        The game ends when a player wins three 3x3 boxes in a row.
        If all boxes are filled and no one has three in a row, the game is a draw.
        Enjoy the game!
        ***/
    }
}
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
public class Game extends JPanel {

    public ArrayList<Grid> gridList = new ArrayList<Grid>(); //list of all small squares
    int x; //coords for graphics
    int y; //coords for graphics 
    public boolean turn; //whose turn it is: true for X (player 1) false for O (player 2) 
    public boolean gameOver; //true if game is over false if not
    public Grid big; //the big overall grid
    String result =""; //the result of the game 
    public Grid activeGrid; 
    public Game() {
        big = new Grid(0,0,0,327,1); //creates the new game grid
    }

    public static void main(String[] args) {
        //random graphics setup stuff
        var panel = new Game();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null); 
        JFrame frame = new JFrame("TicTacToeMEGA");  
        frame.setSize(1150, 1100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        panel.turn = true;  //p1 first (x) 
        panel.gameOver = false; //game is not over

        //initialize all grids
        Grid g1 = new Grid(1,0,0,119-30);
        Grid g2 = new Grid(2,327,0,119-30);
        Grid g3 = new Grid(3,327*2-2,0,119-30);

        Grid g4 = new Grid(4,0,327,119-30);
        Grid g5 = new Grid(5,327,327,119-30);
        Grid g6 = new Grid(6,327*2-2,327,119-30);

        Grid g7 = new Grid(7,0,327*2-1,119-30);
        Grid g8 = new Grid(8,327,327*2-1,119-30);
        Grid g9 = new Grid(9,327*2-2,327*2-1,119-30);

        //add all grids to arraylist so that printing them is easier and you can use for loops
        panel.gridList.add(g1);
        panel.gridList.add(g2);
        panel.gridList.add(g3);
        panel.gridList.add(g4);
        panel.gridList.add(g5);
        panel.gridList.add(g6);
        panel.gridList.add(g7);
        panel.gridList.add(g8);
        panel.gridList.add(g9);

        JButton home = new JButton();
        home.setBounds(1015,100,100,100);
        home.setBackground(new Color (0, 255, 30));
        home.setFont(new Font("Monospaced", Font.BOLD, 15));
        home.setText("Home");
        panel.add(home);
        panel.revalidate(); 
        panel.repaint();

        
         /***   
        JButton res = new JButton();
        res.setBounds(1015,300,100,100);
        res.setBackground(new Color (0, 255, 30));
        res.setFont(new Font("Monospaced", Font.BOLD, 15));
        res.setText("Restart");
        res.add(home);
        res.revalidate(); 
        res.repaint();

        res.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    Game.main(new String[0]);
                }
            });   
        ***/
        home.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    Play.main(new String[0]);
                }
            });
        
        ArrayList<JButton> emptyButtons = new ArrayList<JButton>(); 
        for (Grid grid : panel.gridList) {
            for (JButton button : grid.getButtons()){
                emptyButtons.add(button);
            }
        }
        //always in loop 
        for (Grid grid : panel.gridList){
            for (JButton button : grid.getButtons() ) {
                button.setBackground(new Color(247, 121, 121));
                panel.add(button); //draws buttons on screen 

                button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { //stuff inside this loop only updates every time a button is pressed. 
                            //making sure the particular button pressed sets the small array correctly
                            if (panel.turn == true) { //X
                                grid.setGridState(button,1); //sets small grid arrays for X
                                button.setVisible(false); //removes button
                                panel.turn = false; //changes turn
                                emptyButtons.remove(button);
                                if ((grid.checkWin(1)) || (grid.checkDraw())|| ((grid.checkWin(2)))){
                                    for (JButton but : grid.getButtons() ){
                                        emptyButtons.remove(but);
                                    }
                                }
                            }

                            else if (panel.turn == false){ //O
                                grid.setGridState(button,2); //sets small grid arrays for O
                                button.setVisible(false); //removes button
                                panel.turn = true; //changes turn
                                emptyButtons.remove(button);
                                if ((grid.checkWin(1)) || (grid.checkDraw())|| ((grid.checkWin(2)))){
                                    for (JButton but : grid.getButtons() ){
                                        emptyButtons.remove(but);
                                    }
                                }
                            }

                            if (button.equals(grid.sq1)){
                                panel.activeGrid = g1;
                            }
                            else if(button.equals(grid.sq2)){
                                panel.activeGrid = g2;
                            }
                            else if(button.equals(grid.sq3)){
                                panel.activeGrid = g3;
                            }
                            else if(button.equals(grid.sq4)){
                                panel.activeGrid = g4;
                            }
                            else if(button.equals(grid.sq5)){
                                panel.activeGrid = g5;
                            }
                            else if(button.equals(grid.sq6)){
                                panel.activeGrid = g6;
                            }
                            else if(button.equals(grid.sq7)){
                                panel.activeGrid = g7;
                            }
                            else if(button.equals(grid.sq8)){
                                panel.activeGrid = g8;
                            }
                            else if(button.equals(grid.sq9)){
                                panel.activeGrid = g9;
                            }

                            for (Grid g : panel.gridList) {
                                for (JButton button : g.getButtons() ) {
                                    button.setVisible(false);
                                }
                            }
                            for (JButton button : panel.activeGrid.getButtons()){
                                if (emptyButtons.indexOf(button) != -1){
                                    button.setVisible(true);
                                    if (panel.turn) {
                                        button.setBackground(new Color(247, 121, 121));
                                    }
                                    else {
                                        button.setBackground(new Color(179, 246, 255));
                                    }
                                }
                            }
                            int temp = 0;
                            for (JButton button : panel.activeGrid.getButtons()){
                                if (button.isVisible() ==true){
                                    temp = 1;
                                }

                            }
                            if (temp ==0 ){
                                for (JButton but : emptyButtons){
                                    but.setVisible(true);
                                    if (panel.turn) {
                                        but.setBackground(new Color(247, 121, 121));
                                    }
                                    else {
                                        but.setBackground(new Color(179, 246, 255));
                                    }
                                }
                            }

                            //checks small grid wins for X or O 
                            for (int z = 1;z<=2;z++){ 
                                if (grid.checkWin(z)) {
                                    sleepFor(1); //wait for 1 second
                                    grid.gridWon(); //update that grid to be 3 (which means its been won)
                                    panel.revalidate();
                                    panel.repaint();
                                    for (int x = 1; x<=9;x++){
                                        if (grid.getGridNum()==x){
                                            panel.big.setGridState(x,z);
                                        }

                                    }
                                }
                            } 
                            //checks small grid draws
                            if (grid.checkDraw()){
                                sleepFor(1);
                                grid.gridDraw();
                                panel.revalidate();
                                panel.repaint();
                                int row = grid.getGridRow();
                                int col = grid.getGridCol();
                                for (int x = 1; x<=9;x++){
                                    if ((grid.getGridNum()==x)&& (panel.big.getGridState()[row][col]!=3)){
                                        panel.big.setGridState(x,4);
                                    }

                                }
                            }
                            //checks big grid wins
                            for (int z = 1;z<=2;z++){
                                if (panel.big.checkWin(z)) {
                                    sleepFor(1); //wait for 1 second
                                    if (z ==1) {
                                        panel.result = ("player 1 wins");

                                    }
                                    if (z ==2) {
                                        panel.result = ("player 2 wins");

                                    }
                                    panel.gameOver = true; 

                                    panel.revalidate();
                                    panel.repaint();

                                }
                                else if (panel.big.checkDraw(1)){ //checks big grid draws
                                    sleepFor(3);
                                    panel.result = ("draw");
                                    panel.gameOver = true; 

                                }
                            } 
                            panel.revalidate(); 
                            panel.repaint();

                            //if the game is over, it gets rid of all the buttons
                            if (panel.gameOver) { 
                                for (Grid grid : panel.gridList){
                                    for (JButton button : grid.getButtons() ) {
                                        button.setVisible(false);
                                    }
                                }

                            }
                            panel.revalidate(); 
                            panel.repaint();
                            /*** //just for testing: prints specific array
                            for (int row = 0; row <=2; row++){
                            for (int col = 0; col<=2;col++){

                            System.out.print(panel.big.getGridState()[row][col]);

                            }
                            System.out.println();
                            }   
                             ***/
                        }
                    });
            }
        }

        panel.revalidate(); 
        panel.repaint();
    }
    //all graphics 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBigGrid(g);
        Graphics2D g2 = (Graphics2D) g;
        int size = 119-30; //SMALL GRID GRAPHICS 
        g2.setStroke(new BasicStroke(1));
        for (Grid grid : gridList) {

            for (int row = 0; row <=2; row++){
                for (int col = 0; col<=2;col++){
                    //drawX's
                    g.setColor(Color.RED);
                    if (grid.getGridState()[row][col] ==1){
                        if (row == 0) {
                            if (col ==0) {
                                x = grid.sq1.getX(); 
                                y = grid.sq1.getY();

                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                            if (col ==1) {
                                x = grid.sq2.getX(); 
                                y = grid.sq2.getY();
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                            if(col==2) {
                                x = grid.sq3.getX(); 
                                y = grid.sq3.getY();
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                        }
                        if (row == 1) {
                            if (col ==0) {
                                x = grid.sq4.getX(); 
                                y = grid.sq4.getY();
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                            if (col ==1) {
                                x = grid.sq5.getX(); 
                                y = grid.sq5.getY();
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                            if (col ==2) {
                                x = grid.sq6.getX(); 
                                y = grid.sq6.getY(); 
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                        }
                        if (row == 2) {
                            if (col ==0) {
                                x = grid.sq7.getX(); 
                                y = grid.sq7.getY();
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                            if (col ==1) {
                                x = grid.sq8.getX(); 
                                y = grid.sq8.getY();
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                            if (col ==2)  {
                                x = grid.sq9.getX(); 
                                y = grid.sq9.getY();
                                g.drawLine(x, y, x + size, y + size);
                                g.drawLine(x + size, y, x, y + size);
                            }
                        }

                    }
                    //drawO's
                    g.setColor(new Color(31,190,214));
                    if (grid.getGridState()[row][col] ==2){
                        if (row == 0) {
                            if (col ==0) {
                                x = grid.sq1.getX(); 
                                y = grid.sq1.getY();
                                g.drawOval(x,y,size,size);
                            }
                            if (col ==1) {
                                x = grid.sq2.getX(); 
                                y = grid.sq2.getY();
                                g.drawOval(x,y,size,size);
                            }
                            if(col==2) {
                                x = grid.sq3.getX(); 
                                y = grid.sq3.getY();
                                g.drawOval(x,y,size,size);
                            }
                        }
                        if (row == 1) {
                            if (col ==0) {
                                x = grid.sq4.getX(); 
                                y = grid.sq4.getY();
                                g.drawOval(x,y,size,size);
                            }
                            if (col ==1) {
                                x = grid.sq5.getX(); 
                                y = grid.sq5.getY();
                                g.drawOval(x,y,size,size);
                            }
                            if (col ==2) {
                                x = grid.sq6.getX(); 
                                y = grid.sq6.getY(); 
                                g.drawOval(x,y,size,size);
                            }
                        }
                        if (row == 2) {
                            if (col ==0) {
                                x = grid.sq7.getX(); 
                                y = grid.sq7.getY();
                                g.drawOval(x,y,size,size);
                            }
                            if (col ==1) {
                                x = grid.sq8.getX(); 
                                y = grid.sq8.getY();
                                g.drawOval(x,y,size,size);
                            }
                            if (col ==2)  {
                                x = grid.sq9.getX(); 
                                y = grid.sq9.getY();
                                g.drawOval(x,y,size,size);
                            }
                        }

                    }
                }

            }

        }
        size = 300; //BIG GRID GRAPHICS 

        g2.setStroke(new BasicStroke(5));
        for (int row = 0; row <=2; row++){
            for (int col = 0; col<=2;col++){
                if ((row == 0) && (col ==0)){
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);
                        x = big.sq1.getX(); 
                        y = big.sq1.getY();
                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));
                        x = big.sq1.getX(); 
                        y = big.sq1.getY();
                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);
                        x = big.sq1.getX(); 
                        y = big.sq1.getY();
                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 0) && (col ==1)){
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);
                        x = big.sq2.getX(); 
                        y = big.sq2.getY();
                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));
                        x = big.sq2.getX(); 
                        y = big.sq2.getY();

                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);
                        x = big.sq2.getX(); 
                        y = big.sq2.getY();
                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 0) && (col ==2)){
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);
                        x = big.sq3.getX(); 
                        y = big.sq3.getY();
                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));
                        x = big.sq3.getX(); 
                        y = big.sq3.getY();
                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);
                        x = big.sq3.getX(); 
                        y = big.sq3.getY();
                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 1) && (col ==0)){
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);
                        x = big.sq4.getX(); 
                        y = big.sq4.getY();
                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));
                        x = big.sq4.getX(); 
                        y = big.sq4.getY();
                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);
                        x = big.sq4.getX(); 
                        y = big.sq4.getY();
                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 1) && (col ==1)){
                    x = big.sq5.getX(); 
                    y = big.sq5.getY();
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);

                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));

                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);

                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 1) && (col ==2)){
                    x = big.sq6.getX(); 
                    y = big.sq6.getY();
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);

                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));

                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);

                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 2) && (col ==0)){
                    x = big.sq7.getX(); 
                    y = big.sq7.getY();
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);

                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));

                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);

                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 2) && (col ==1)){
                    x = big.sq8.getX(); 
                    y = big.sq8.getY();
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);

                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));

                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);

                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }

                if ((row == 2) && (col ==2)){
                    x = big.sq9.getX(); 
                    y = big.sq9.getY();
                    if (big.getGridState()[row][col] == 1){
                        g.setColor(Color.RED);

                        g.drawLine(x, y, x + size, y + size);
                        g.drawLine(x + size, y, x, y + size);

                    }
                    if (big.getGridState()[row][col] == 2){
                        g.setColor(new Color(31,190,214));

                        g.drawOval(x,y,size,size);
                    }
                    if (big.getGridState()[row][col] ==4) {
                        g.setColor(Color.YELLOW);

                        g.fillRect(x+25,y+25,size-50,size-50);
                        g.setColor(Color.BLACK);
                        g.setFont(new Font("SansSerif", Font.BOLD, 50));
                        g.drawString("DRAW", x+75, y+160);
                    }
                }
            }
        }
        g2.setStroke(new BasicStroke(1));
        //active Grid
        if (turn){
            g.setColor(Color.RED);
        }
        else {
            g.setColor(new Color(31,190,214));
        }

        int size1 = 60;
        //final results 
        if (result.equals("player 1 wins")) {
            g.setColor(Color.GREEN);
            g.fillRect(200,300, 600,100);
            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.BOLD, size1));
            g.drawString("PLAYER 1 WINS", 270, 370);

        }
        if (result.equals("player 2 wins")) {
            g.setColor(Color.GREEN);
            g.fillRect(200,300, 600,100);
            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.BOLD, size1));
            g.drawString("PLAYER 2 WINS", 270, 370);

        }
        if (result.equals("draw")) {
            g.setColor(Color.GREEN);
            g.fillRect(200,300, 600,100);
            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.BOLD, size1));
            g.drawString("DRAW", 415, 370);

        }

    }

    //draws big grid and smaller squares but needs to be called in paintComponent to actually print 
    public void drawBigGrid(Graphics g) {
        if (turn) {
            g.setColor(Color.RED);
        }
        else {
            g.setColor(new Color(31,190,214));
        }
        g.drawRect(10,10,980,980); //big square
        g.drawRect(9,9,980,980);
        g.drawRect(11,11,980,980);
        g.drawRect(8,8,980,980);
        g.drawRect(12,12,980,980);

        g.setColor(Color.WHITE);
        //small grid lines
        //vertical 
        g.drawLine(119,25,119,975);
        g.drawLine(228,25,228,975);
        g.drawLine(446,25,446,975);  
        g.drawLine(555,25,555,975);
        g.drawLine(770,25,770,975);
        g.drawLine(879,25,879,975);

        //horizontal 
        g.drawLine(25,119,975,119);
        g.drawLine(25,228,975,228);
        g.drawLine(25,446,975,446);  
        g.drawLine(25,555,975,555);
        g.drawLine(25,770,975,770);
        g.drawLine(25,879,975,879);

        //grid squares
        g.setColor(new Color(255,223,0));
        g.drawRect(10,10,327, 327); //grid 1
        g.drawRect(337,10,327, 327); //grid 2
        g.drawRect(664,10,326,327); //grid 3

        g.drawRect(10,337,327, 327); //grid 4
        g.drawRect(337,337,327, 327); //grid 5
        g.drawRect(664,337,326,327); //grid 6

        g.drawRect(10,664,327, 326); //grid 7
        g.drawRect(337,664,327, 326); //grid 8
        g.drawRect(664,664,326,326); //grid 9

        ////to make lines thicker
        //vertical 
        g.drawLine(338,10,338,990);
        g.drawLine(665,10,665,990
        );
        g.drawLine(338-1,10,338-1,990);
        g.drawLine(665-1,10,665-1,990);
        g.drawLine(338+1,10,338+1,990);
        g.drawLine(665+1,10,665+1,990);
        g.drawLine(338-2,10,338-2,990);
        g.drawLine(665-2,10,665-2,990);
        g.drawLine(338+2,10,338+2,990);
        g.drawLine(665+2,10,665+2,990);
        //horizontal 
        g.drawLine(10,338,990,338);
        g.drawLine(10,665,990,665);
        g.drawLine(10,338-1,990,338-1);
        g.drawLine(10,665-1,990,665-1);
        g.drawLine(10,338+1,990,338+1);
        g.drawLine(10,665+1,990,665+1);
        g.drawLine(10,338-2,990,338-2);
        g.drawLine(10,665-2,990,665-2);
        g.drawLine(10,338+2,990,338+2);
        g.drawLine(10,665+2,990,665+2);

    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Sleep for 1 second
        } catch (InterruptedException e) {

        }
    }
}

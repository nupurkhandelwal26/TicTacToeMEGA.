import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Grid
{
    // instance variables - replace the example below with your own
    private int[][]grid= new int [3][3];
    private int gridNum; 
    private int xMin,yMin;
    private ArrayList<JButton> buttonList = new ArrayList<JButton>(); 
    JButton sq1 = new JButton();
    JButton sq2 = new JButton();
    JButton sq3 = new JButton();
    JButton sq4 = new JButton();
    JButton sq5 = new JButton();
    JButton sq6 = new JButton();
    JButton sq7 = new JButton();
    JButton sq8 = new JButton();
    JButton sq9 = new JButton();
    int counter = 1; 

    /***
    JButton button = new JButton();
    button.setBounds(25, 25, c, c);
    button.setBackground(Color.BLACK);
    panel.add(button); 
    panel.revalidate(); 
    panel.repaint();
     ***/

    /**
     * Constructor for objects of class Grid
     */
    public Grid(int num, int a,int b, int c)    {
        xMin = a; 
        yMin = b; 
        gridNum = num;
        buttonList.add(sq1);
        sq1.setBounds(xMin+25, yMin+25, c, c);
        buttonList.add(sq2);
        sq2.setBounds(xMin+119+5, yMin+25, c+10, c);
        buttonList.add(sq3);
        sq3.setBounds(xMin+228+5,yMin+ 25, c, c);

        buttonList.add(sq4);
        sq4.setBounds(xMin+25,yMin+ 119+5, c, c+10);
        buttonList.add(sq5);
        sq5.setBounds(xMin+119+5, yMin+119+5, c+10, c+10);
        buttonList.add(sq6);
        sq6.setBounds(xMin+228+5,yMin+ 119+5, c, c+10);

        buttonList.add(sq7);
        sq7.setBounds(xMin+25, yMin+228+5, c, c);
        buttonList.add(sq8);
        sq8.setBounds(xMin+119+5,yMin+ 228+5, c+10, c);
        buttonList.add(sq9);
        sq9.setBounds(xMin+228+5,yMin+ 228+5, c, c);
        /***
        int buttonSize = 100;
        int spacing = 10;
        for (int i = 0; i < 9; i++) {
        JButton button = new JButton();
        int x = xMin + (i % 3) * (buttonSize + spacing);
        int y = yMin + (i / 3) * (buttonSize + spacing);
        button.setBounds(x, y, buttonSize, buttonSize);
        buttonList.add(button);
        }
         ***/

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = 0;

            }
        }
    }
        public Grid(int num, int a,int b, int c, int d)    {
        xMin = a; 
        yMin = b; 
        gridNum = num;
        buttonList.add(sq1);
        sq1.setBounds(xMin+25, yMin+25, c, c);
        buttonList.add(sq2);
        sq2.setBounds(xMin+c+25, yMin+25, c+10, c);
        buttonList.add(sq3);
        sq3.setBounds(xMin+c+c+25,yMin+ 25, c, c);

        buttonList.add(sq4);
        sq4.setBounds(xMin+25,yMin+ c+25, c, c+10);
        buttonList.add(sq5);
        sq5.setBounds(xMin+c+25, yMin+c+25, c+10, c+10);
        buttonList.add(sq6);
        sq6.setBounds(xMin+c+c+25,yMin+ c+25, c, c+10);

        buttonList.add(sq7);
        sq7.setBounds(xMin+25, yMin+c+c+25, c, c);
        buttonList.add(sq8);
        sq8.setBounds(xMin+c+25,yMin+ c+c+25, c+10, c);
        buttonList.add(sq9);
        sq9.setBounds(xMin+c+c+25,yMin+ c+c+25, c, c);
        /***
        int buttonSize = 100;
        int spacing = 10;
        for (int i = 0; i < 9; i++) {
        JButton button = new JButton();
        int x = xMin + (i % 3) * (buttonSize + spacing);
        int y = yMin + (i / 3) * (buttonSize + spacing);
        button.setBounds(x, y, buttonSize, buttonSize);
        buttonList.add(button);
        }
         ***/

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = 0;

            }
        }
    }

    public ArrayList<JButton> getButtons() {
        return buttonList;
    }

    public void setGridState (JButton button, int value) {
        if (button.equals(sq1)){
            grid[0][0]=value; 
        }
        if (button.equals(sq2)){
            grid[0][1]=value; 
        }
        if (button.equals(sq3)){
            grid[0][2]=value; 
        }
        if (button.equals(sq4)){
            grid[1][0]=value; 
        }
        if (button.equals(sq5)){
            grid[1][1]=value; 
        }
        if (button.equals(sq6)){
            grid[1][2]=value; 
        }
        if (button.equals(sq7)){
            grid[2][0]=value; 
        }
        if (button.equals(sq8)){
            grid[2][1]=value; 
        }
        if (button.equals(sq9)){
            grid[2][2]=value; 
        }

    }

    public void setGridState (int sq, int value){
        if (sq==1){
            grid[0][0]=value; 
        }
        if ((sq==2)){
            grid[0][1]=value; 
        }
        if (sq==3){
            grid[0][2]=value; 
        }
        if (sq==4){
            grid[1][0]=value; 
        }
        if (sq==5){
            grid[1][1]=value; 
        }
        if (sq==6){
            grid[1][2]=value; 
        }
        if (sq==7){
            grid[2][0]=value; 
        }
        if (sq==8){
            grid[2][1]=value; 
        }
        if (sq==9){
            grid[2][2]=value; 
        }

    }

    public boolean checkWin(int player){

        //check rows
        for (int row = 0; row <=2; row++){
            if ((grid[row][0] == player) && (grid[row][1] == player) && (grid[row][2] == player)) {
                return true;
            }
        }
        //check columns
        for (int col = 0; col <=2; col++){
            if ((grid[0][col] == player) && (grid[1][col] == player) && (grid[2][col] == player)) {
                return true;
            }
        }
        // check diagonals
        if((grid[0][0] == player) && (grid[1][1] == player) && (grid[2][2] == player)) {
            return true;

        }
        if((grid[2][0] == player) && (grid[1][1] == player) && (grid[0][2] == player)) {
            return true;

        }
        return false; 
    }

    public void gridWon() {
        for (int row = 0; row <= 2; row++){
            for (int col = 0; col <= 2; col++){
                grid[row][col] = 3;

            }
        }
        for (JButton button : buttonList){
            button.setVisible(false);
        }
    }

    public boolean checkDraw(){
        for (int row = 0; row <= 2; row++){
            for (int col = 0; col <= 2; col++){
                if ((grid[row][col] ==0) || (grid[row][col] ==3)){
                    return false; 
                }
            }
        }
        return true; 
    }
    public boolean checkDraw(int hi){
        for (int row = 0; row <= 2; row++){
            for (int col = 0; col <= 2; col++){
                if ((grid[row][col] ==0) || (checkWin(1) || (checkWin(2)))){
                    return false; 
                }
            }
        }
        return true; 
    }
    public void gridDraw() {
        for (int row = 0; row <= 2; row++){
            for (int col = 0; col <= 2; col++){
                grid[row][col] = 4;

            }
        }
        for (JButton button : buttonList){
            button.setVisible(false);
        }
    }

    public int getGridNum(){
        return gridNum;
    }
    public int getGridRow(){
        if (gridNum >6){
            return 2;
        }
        else if (gridNum >3){
            return 1; 
        }
        else {
            return 0; 
        }
    }
    public int getGridCol(){
        if ((gridNum ==1) || (gridNum==4) || (gridNum ==7)){
            return 0;
        }
        if ((gridNum ==2) || (gridNum==5) || (gridNum ==8)){
            return 1;
        }
        if ((gridNum ==3) || (gridNum==6) || (gridNum ==9)){
            return 2;
        }
        return 8; 
    }

    public int [][] getGridState (){
        return grid; 
    }
    
}
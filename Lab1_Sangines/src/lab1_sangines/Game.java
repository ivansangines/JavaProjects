/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_sangines;

/**
 *
 * @author Usuario
 */
public class Game {

    private String word;
    private char yPos;
    private int iPos;
    private char direction;
    private String clue;
    private int pos;

    public Game() {
        word = " ";
        iPos = 0;
        yPos = 'c';
        direction = 'd';
        clue = " ";
        pos=0;
    }

    public Game(String word, char y, int i, char p, String c, int pos) {
        this.word = word;
        this.yPos = y;
        this.iPos = i;
        this.direction = p;
        this.clue = c;
        this.pos=pos;

    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getiPos() {
        return iPos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setiPos(int iPos) {
        this.iPos = iPos;
    }

    public char getyPos() {
        return yPos;
    }

    public void setyPos(char yPos) {
        this.yPos = yPos;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    @Override
    public String toString() {
        return this.word + "\n" + this.iPos + "\n" + this.yPos + "\n" + this.direction + "\n" + this.clue + "\n" + this.pos + "\n";
    }

}



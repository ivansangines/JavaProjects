/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MazeClass {

    private int[][] maze;
    private int size, start, end;
    private Random rand;
    private ArrayList arrayList = new ArrayList();

    public MazeClass() {
        this(15);
        //this.maze = new char[size][size];
    }

    public MazeClass(int size) {
        rand = new Random();
        this.size = size;
        this.maze = new int[size][size];
        generateMaze();
    }

    public void generateMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (i == 0 || j == 0 || i == (size - 1) || j == (size - 1)) {
                    maze[i][j] = 1; // wall
                } else {
                    maze[i][j] = rand.nextInt(2);// wall or path
                }
            }
        }
        start = rand.nextInt(size - 2) + 1;
        end = rand.nextInt(size - 2) + 1;
        maze[start][0] = 2;
        maze[end][size - 1] = 0;
        printMaze();
        move(start, 0, maze);

    }

    public void printMaze() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (maze[i][j] == 2) {
                    System.out.print("X\t");
                } else {
                    if (maze[i][j] == 1) {
                        System.out.print((char) (169) + "\t");
                    } else if (maze[i][j] == 3){
                        System.out.print("0\t");
                    }else{
                        System.out.print(".\t");
                    }
                }
            }
            System.out.println("");

        }

    }

    public boolean inicio(int x, int y) {
        if (x == start && y == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fin(int x, int y) {
        if (x == end && y == (size - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public void move(int x, int y, int[][] maze) {
        System.out.print("Keep going? (y/n) ");
        Scanner in = new Scanner(System.in);
        String order = in.next();
        if (order.equalsIgnoreCase("y")) {
            if (maze[x + 1][y] == 0) {//checking down
                maze[x + 1][y] = 2;
                printMaze();

                if (inicio(x + 1, y)) {
                    System.out.println("Sorry!!");
                    System.exit(1);
                }
                if (fin(x + 1, y)) {
                    System.out.println("Congrats!!");
                    System.exit(1);
                }
                move(x + 1, y, maze);
            }else if(maze [x][y+1]==0){ //Checking right
                maze[x][y+1] = 2;
                printMaze();

                if (inicio(x, y+1)) {
                    System.out.println("Sorry!!");
                    System.exit(1);
                }
                if (fin(x, y+1)) {
                    System.out.println("Congrats!!");
                    System.exit(1);
                }
                move(x, y+1, maze);
            }else if( maze [x-1][y]==0){ //Checking up
                maze[x - 1][y] = 2;
                printMaze();

                if (inicio(x - 1, y)) {
                    System.out.println("Sorry!!");
                    System.exit(1);
                }
                if (fin(x - 1, y)) {
                    System.out.println("Congrats!!");
                    System.exit(1);
                }
                move(x - 1, y, maze);
            }else if ( maze [x][y-1]==0){ //Checking left
                maze[x][y-1] = 2;
                printMaze();

                if (inicio(x, y-1)) {
                    System.out.println("Sorry!!");
                    System.exit(1);
                }
                if (fin(x, y-1)) {
                    System.out.println("Congrats!!");
                    System.exit(1);
                }
                move(x, y-1, maze);
            }else{
                maze [x][y]=3;
                if (maze[x+1][y]==2){ //Checking down
                    printMaze();
                    if (inicio(x+1,y)){
                        System.out.println("Sorry!!");
                        System.exit(1);
                    }
                    move(x+1, y, maze);
                }else if (maze[x][y+1]==2){ //Checking right
                    printMaze();
                    if(inicio(x,y+1)){
                        System.out.println("Sorry!!");
                        System.exit(1);
                    }
                    move(x, y+1, maze);
                }else if (maze[x-1][y]==2){ //Checking up
                    printMaze();
                    if(inicio(x-1,y)){
                        System.out.println("Sorry!!");
                        System.exit(1);
                    }
                    move(x-1, y, maze);
                }else if (maze[x][y-1]==2){ //Checking left
                    printMaze();
                    if(inicio(x,y-1)){
                        System.out.println("Sorry!!");
                        System.exit(1);
                    }
                    move(x, y-1, maze);
                }else{
                    System.out.println("JOODER TIO!");
                    System.exit(1);
                }
            }
        }

    }
}


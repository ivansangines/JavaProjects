
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Graph {

    static int[][] Matrix;//reference to a 2d array
    static boolean[] visited;
    static int vCount;

    public static void main(String[] args) throws IOException, Exception {

        menu();

    }

    public static void menu() throws FileNotFoundException, Exception {
        String frame = JOptionPane.showInputDialog(null, "Choose between:\n 1.if you have a file.\n 2.if you want to input manually.\n 3. Quit.");
        if (frame == null) {
            System.exit(0);
        }
        int option_num = Integer.parseInt(frame);

        if (option_num == 1) {
            String file = JOptionPane.showInputDialog("Choose between:\n 1. Graph\n 2. Grafico");
            int choice = Integer.parseInt(file);

            if (choice == 1) {
                read("graph.txt");
                options();

            } else if (choice == 2) {
                read("grafico");
                options();
            } else {
                JOptionPane.showMessageDialog(null, "Input 1 or 2");
                menu();
            }

        } else if (option_num == 2) {
            noRead();
            options();
        } else if (option_num == 3) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Input 1 or 2");
            menu();

        }

    }

    public static void options() throws FileNotFoundException, Exception {
        visited = new boolean[Matrix.length];
        String frame = JOptionPane.showInputDialog(null, "1.Solve for DFS.\n 2.Solve for BFS.\n 3. Quit.");
        if (frame == null) {
            System.exit(0);
        }
        int choice = Integer.parseInt(frame);

        if (choice == 1) {
            frame = JOptionPane.showInputDialog(null, "Enter the starting vertex:");
            if (frame == null) {
                System.exit(0);
            }
            int ver = Integer.parseInt(frame);
            dfs(ver-1, Matrix, visited);

        }
        else if (choice == 2) {
            frame = JOptionPane.showInputDialog(null, "Enter the starting vertex:");
            if (frame == null) {
                System.exit(0);
            }
            int ver = Integer.parseInt(frame);
            bfs(ver);

        } else if (choice == 3) {
            System.exit(0);
        }else {
            JOptionPane.showMessageDialog(null, "Input 1, 2 or 3");
            options();

        }

    }

    public static void noRead() throws FileNotFoundException, Exception {
        String vCoutString = JOptionPane.showInputDialog("How many vertices?");

        vCount = Integer.parseInt(vCoutString);//Ojo si insertamos String
        Matrix = new int[vCount][vCount];
        for (int i = 0; i < vCount; i++) {
            String neibs = JOptionPane.showInputDialog("Connections from vertex # " + (i + 1));
            String[] adjs = neibs.split(" ");
            //   System.out.println("Lenght adjs= "+ adjs.length);     
            for (int n = 0; n < adjs.length; n++) {
                int loc = Integer.parseInt(adjs[n]);
                Matrix[i][loc - 1] = 1;
            }
        }
        displayMatrix();
        System.out.println("");
        displayGraph();
        options();
//        menu();
    }

    public static void read(String file) throws FileNotFoundException, Exception {
        FileReader myFile = new FileReader(file);
        Scanner input = new Scanner(myFile);
        String line = input.nextLine();
        vCount = Integer.parseInt(line.trim());
        Matrix = new int[vCount][vCount];
        while (input.hasNextLine()) {

            for (int i = 0; i < vCount; i++) {
                String ln = input.nextLine();

                String[] adjs = ln.trim().split(",");

                for (int n = 0; n < adjs.length; n++) {
                    int loc = Integer.parseInt(adjs[n]);
                    Matrix[i][loc - 1] = 1;
                }
            }
        }
        displayMatrix();
        System.out.println("");
        displayGraph();
        options();
//        menu();

    }

    public static void displayMatrix() {
        for (int row = 0; row < Matrix.length; row++) {
            for (int col = 0; col < Matrix[row].length; col++) {
                System.out.printf("%3d", Matrix[row][col]);
            }
            System.out.println("");
        }
    }

    public static void displayGraph() {
        for (int row = 0; row < Matrix.length; row++) {
            System.out.printf("%3d ->", row + 1);
            for (int column = 0; column < Matrix[row].length; column++) {

                if (Matrix[row][column] == 1) {
                    System.out.printf("%3d ", (column + 1));
                }

            }
            System.out.println("");
        }
    }

    public static void dfs(int i, int[][] mat, boolean[] visited) {
        if (!visited[i]) {
            visited[i] = true; // Mark node as "visited"
            System.out.print((i + 1) + " ");

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && !visited[j]) {
                    dfs(j, mat, visited); // Visit node
                }
            }
        }
        //System.out.println("");
    }

//    public static void bfs(int i, int[][] mat, boolean[] visited) {
//        if (!visited[i]) {
//            visited[i] = true; // Mark node as "visited"
//            
//
//            for (int j = 0; j < mat[i].length; j++) {
//                if (mat[i][j] == 1 && !visited[j]) {
//                    dfs(j, mat, visited); // Visit node
//                }
//            }
//        }
//    }
    public static void bfs(int start) throws Exception {
        Queue q = new Queue(vCount);
        ArrayList<Integer> visit = new ArrayList();
        ArrayList<Integer> enqueued = new ArrayList();
        q.enqueue(start);
        enqueued.add(start);
        while (q.front != q.rear) { //not empty
            int temp = q.dequeue();
            enqueued.remove(new Integer(temp));
            visit.add(temp);
            for (int i = 0; i < vCount; i++) {
                if (Matrix[temp - 1][i] == 1 && visit.contains(i + 1) == false && enqueued.contains(i + 1) == false) {
                    q.enqueue(i + 1);
                    enqueued.add(i + 1);
                }
            }
        }
        System.out.print("order visited: ");
        for (int i = 0; i < visit.size() - 1; i++) {
            System.out.print(visit.get(i) + ",");
        }
        System.out.println(visit.get(visit.size() - 1)+"/n");
        menu();
    }

}

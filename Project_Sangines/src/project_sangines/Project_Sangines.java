package project_sangines;

public class Project_Sangines {

    static int global_time = 0;
    static int num_of_cars;

    //queues are the tables
    // max number of queues is max number of tables
    public static void main(String[] args) throws InterruptedException {
        //generate 10 empty tables
        Table[] tables = new Table[10];
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table();
        }

        int timer = 0;
        while (timer != 200) { // make the time bigger in order to fill all the Serevers

            Thread.sleep(1000);
            System.out.println("\n--------------------------------------------------");
            System.out.println("Global Time: " + global_time);
            System.out.println("Timer: " + timer);

            //do service
            for (int j = 0; j < tables.length; j++) {//for each table
                if (tables[j].getQueue() != null) {
                    tables[j].doService();
                }
            }

            //checking if the queues are full
            boolean test = true;
            for (int i = 0; i < tables.length && test; i++) {//checking to see if all queues are full or null
                if (tables[i].getQueue() == null || tables[i].getQueue().isFull()) {//if the table is full or is not initialized
                    //do nothing

                } else {//if one is found that is initialized and not filled, break out
                    test = false;
                }
            }

            if (test) {//if we did not find any queues that are not filled (ie: table is full)
                int counter = 0;
                boolean found = false;
                while (!found) {//until we find the next possible queue to open
                    if (tables[counter].getQueue() == null) {//if the queue at table[counter] = null:
                        System.out.printf("Table full. New table opened. Timer reset to 0.\n", counter);
                        timer = 0;
                        Queue queue = new Queue(5);//set up a new queue
                        tables[counter].setQueue(queue);
                        found = true;//break out of loop
                    } else {
                        counter++;//else increment counter
                    }
                }
                int temp = generateServiceTime(100);
                if (temp < 20) { // costumer arrives
                    int num = generateServiceTime(100);
                    Customer cus = new Customer();

                    if (num < 50) {
                        cus = new Customer("Tio", global_time, 15);
                    } else if (num < 70) {
                        cus = new Customer("Ivan", global_time, 25);
                    } else if (num < 90) {
                        cus = new Customer("Matsu", global_time, 35);
                    } else {
                        cus = new Customer("Dani", global_time, 40);
                    }

                    tables[counter].setCos(cus);
                }
            } else {

                //generate costumers
                int temp = generateServiceTime(100);
                if (temp < 20) { // costumer arrives
                    int num = generateServiceTime(100);
                    Customer cos = new Customer();
                    num_of_cars++;
                    if (num < 50) {
                        cos = new Customer("Tio", global_time, 15);
                    } else if (num < 70) {
                        cos = new Customer("Ivan", global_time, 28);
                    } else if (num < 90) {
                        cos = new Customer("Matsu", global_time, 35);
                    } else {
                        cos = new Customer("Dani", global_time, 40);
                    }

                    int min = tables[0].getQueue().getElements();
                    int pos = 0;
                    for (int j = 1; j < tables.length; j++) {//for each table
                        if (tables[j].getQueue() != null && tables[j].getQueue().getElements() < min) { // to find the queue that has the less cars
                            min = tables[j].getQueue().getElements();
                            pos = j;
                        }
                    }

                    if (tables[pos].isEmpty()) {
                        tables[pos].setCos(cos);
                    } else {//else place the client in the queue
                        tables[pos].getQueue().enqueue(cos);
                    }

                    System.out.println("Client " + cos.getName() + " was created and placed in the table with the employee " + (char) (pos + 65));
                }
            }

            //end time printing
            for (int i = 0; i < tables.length; i++) {

                if (tables[i].getCos() == null) {
                    System.out.println("Server " + (char) (i + 65) + ": is currently not working.");
                } else {
                    System.out.println("Server " + (char) (i + 65) + " is working on " + tables[i].getCos().getName().toString() + " who finishes in " + tables[i].getCos().getServiceTime());
                    System.out.println("Server " + (char) (i + 65) + " queue size = " + tables[i].getQueue().getElements());
                }

            }
            timer++;
            global_time++;

        }

    }

    public static int generateServiceTime(int num) {

        return (int) (System.nanoTime() % num);

    }
}

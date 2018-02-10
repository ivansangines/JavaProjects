
package allocation;


public class Allocation {

 
    public static void main(String[] args) {
        int[] arr = new int[7];
        HeapManager m = new HeapManager(arr);
        int p1 = m.allocate(2);
        int p2 = m.allocate(1);
        int p3 = m.allocate(1);
        m.deallocate(p1);
        m.deallocate(p3);
        int p4 = m.allocate(1);
        int p5 = m.allocate(2);
               
        m.printArray(arr);

    }

}

package allocation;

public class HeapManager {

    static private final int NULL = -1; // our null link
    public int[] memory; // the memory we manage
    private int freeStart; // start of the free list

    /**
     * HeapManager constructor.
     *
     * @param initialMemory the int[] of memory to manage
     */
    public HeapManager(int[] initialMemory) {
        memory = initialMemory;
        memory[0] = memory.length; // one big free block
        memory[1] = NULL; // free list ends with it
        freeStart = 0; // free list starts with it
    }

    /**
     * Allocate a block and return its address.
     *
     * @param requestSize int size of block, > 0
     * @return block address
     * @throws OutOfMemoryError if no block big enough
     */
    public int allocate(int requestSize) {
        int size = requestSize + 1; // size including header

        // Do first-fit search: linear search of the free 
        // list for the first block of sufficient size.
        int p = freeStart; // head of free list
        int lag = NULL;
        while (p != NULL && memory[p] < size) {
            lag = p; // lag is previous p
            p = memory[p + 1]; // link to next block
        }
        /*int smallest = memory[p];
        int smaller = memory[p];
        int index = p;
        while (size < smallest) {
            p = memory[p + 1];
            if (p == -1) {
                break;
            } else {

                smallest = memory[p];
                if (smallest == size) {
                    break;
                } else if (smallest < smaller) {
                    if (smallest < size) {
                        smallest = smaller;
                    } else {
                        smaller = smallest;
                        index = p;
                    }
                }
            }

        }
        p = index;*/
        if (p == NULL) // no block large enough
        {
            throw new OutOfMemoryError();
        }
        int nextFree = memory[p + 1]; // block after p

        // Now p is the index of a block of sufficient size,
        // lag is the index of p's predecessor in the
        // free list, or NULL, and nextFree is the index of
        // p's successor in the free list, or NULL.
        // If the block has more space than we need, carve
        // out what we need from the front and return the
        // unused end part to the free list.
        int unused = memory[p] - size; // extra space in block
        if (unused > 1) { // if more than a header's worth
            nextFree = p + size; // index of the unused piece
            memory[nextFree] = unused; // fill in size 
            memory[nextFree + 1] = memory[p + 1]; // fill in link
            memory[p] = size; // reduce p's size accordingly
        }

        // Link out the block we are allocating and done.
        if (lag == NULL) {
            freeStart = nextFree;
        } else {
            memory[lag + 1] = nextFree;
        }
        return p + 1; // index of useable word (after header)
    }

    /**
     * Deallocate an allocated block. This works only if the block address is
     * one that was returned by allocate and has not yet been deallocated.
     *
     * @param address int address of the block
     */
    public void deallocate(int address) {
        int addr = address - 1;
        memory[addr + 1] = freeStart;
        freeStart = addr;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("| " + array[i] + " |");
            System.out.println("------");

        }
    }
}

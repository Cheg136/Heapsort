import java.util.Random;

public class Heap
{
    public void heapSort(int array[]) 
    {
        int arrayLength = array.length;

        for (int i = arrayLength / 2 - 1; i >= 0; i--)
            heapify(array, arrayLength, i);

        for (int i = arrayLength - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    void heapify(int array[], int arrayLength, int index) 
    {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < arrayLength && array[leftChild] > array[largest])
            largest = leftChild;

        if (rightChild < arrayLength && array[rightChild] > array[largest])
            largest = rightChild;

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            heapify(array, arrayLength, largest);
        }
    }

    static void printArray(int array[]) 
    {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) 
    {
        int inputArray[] = new int[100];
        Random rand = new Random();
        for (int i = 0; i < inputArray.length; i++)
        {
        	inputArray[i] = rand.nextInt(1000);
        }
        int arrayLength = inputArray.length;
        System.out.println("Unsorted array:");
        printArray(inputArray);

        Heap heapSort = new Heap();

        long startTime = System.nanoTime();
        heapSort.heapSort(inputArray);
        long endTime = System.nanoTime();

        long timeTaken = endTime - startTime;

        System.out.println("Sorted array:");
        printArray(inputArray);
        System.out.println("Time taken by HeapSort: " + timeTaken + " nanoseconds");
    }
}

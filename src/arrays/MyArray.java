package arrays;

public class MyArray {

    private int[] arr;
    private int numElements;

    MyArray(int size) {
        this.numElements = 0;
        arr = new int[size];
    }

    int find(int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
            if (i == numElements) {
                break;
            }
        }
        return 0;
    }

    void insert(int val) {
        if (numElements != arr.length) {
            arr[numElements] = val;
            numElements++;
        } else {
            throw new RuntimeException("Max Array Capacity Exceeded");
        }
    }

    boolean delete(int val) {
        return false;
    }

    void display() {

    }

    void binarySearch() {

    }

    void sort() {

    }
}

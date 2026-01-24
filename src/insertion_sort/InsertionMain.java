package insertion_sort;

public class InsertionMain {
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The element we are currently positioning
            System.out.println("I: "+ i);
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; // Place the key in its correct location
        }
    }

    static void main(String[] args) {
        InsertionMain insertion = new InsertionMain();
        int[] arr = {53,44,39,27,11};
        insertion.insertionSort(arr);

        for(int value:arr){
            System.out.println(value);
        }
    }
}

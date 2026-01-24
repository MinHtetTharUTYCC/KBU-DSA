package selection_sort;

public class SelectionMain {
    public void selectionSort(int[] arr){
        int n=arr.length;
        for (int i = 0; i < n-1; i++) {
            // current minimum element index
            int minIndex = i;
            System.out.println("Round:        "+ i);

            for (int j = i+1; j < n; j++) {
                System.out.println("nested: "+ j);
                //find the index of the minimum element
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            //swap the minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }
    static void main(String[] args) {
        SelectionMain selection = new SelectionMain();
        int[] arr = {53,44,39,27,11};
        selection.selectionSort(arr);

        for(int value:arr){
            System.out.println(value);
        }
    }
}

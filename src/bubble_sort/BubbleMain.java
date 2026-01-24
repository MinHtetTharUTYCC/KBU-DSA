package bubble_sort;

public class BubbleMain {
    public void bubbleSort(int arr[]){
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
        System.out.println("I: "+ i);
        for (int j = 0; j < n-i-1; j++) {
            System.out.println("J value: "+ j);
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                System.out.println("Swapped");
                for(int k:arr){
                    System.out.println(k);
                }
            }
        }
    }
    }

    static void main(String[] args) {
        BubbleMain bubble = new BubbleMain();
        int[] arr = {53,44,39,27,11};
        bubble.bubbleSort(arr);

        for(int i:arr){
            System.out.println(i);
        }
    }
}

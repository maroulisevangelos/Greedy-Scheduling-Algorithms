import java.io.*;
public class Sort {
    //fuction to swap two elements
    static void swap(Task[] arr, int i, int j) {
        Task temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    //pivot=last element
    static int partition(Task[] arr, int low, int high){
        Task pivot = arr[high];
        int i = (low -1);
        for (int j = low; j <= high - 1; j++){
            if(arr[j].getTime() > pivot.getTime()){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    }

    static void quickSort(Task[] arr, int low, int high){
        if (low<high){
            int pi = partition(arr, low, high);
            quickSort(arr,low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

//    static void printArray(Task[] arr, int size){
//        for(int i = 0; i<size; i++){
//            System.out.print(arr[i] + " ");
//            System.out.println();
//        }
//    }


}

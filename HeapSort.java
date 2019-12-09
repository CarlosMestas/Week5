public class HeapSort implements IAlgorithm{

    static int[] arrayTest;
    
    public void sort(int arr[]){ 
        int n = arr.length; 
        for (int i = n / 2 - 1 ; i >= 0 ; i--){ 
            heapify(arr, n, i); 
        }
        for (int i = n - 1 ; i >= 0 ; i--){ 
            swap(arr,0,i);
            heapify(arr, i, 0); 
        } 
    } 

    public void heapify(int arr[], int n, int i) { 
        int largest = i; 
        int l = 2 * i + 1;  
        int r = 2 * i + 2; 
  
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
        if (largest != i){ 
            swap(arr,i,largest);
            heapify(arr, n, largest); 
        } 
    } 
    
    public void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public String description(){
        return "HeapSort";
    }

    public boolean run(int[] data){
        sort(data);
        return true;
    }
}
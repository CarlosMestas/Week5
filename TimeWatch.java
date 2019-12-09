import java.lang.*;
import java.io.*;
import java.util.*;
public class TimeWatch {
    public static void main(String[] args) {
		long start_time; 
		long nano_time_start;

        long end_time = System.currentTimeMillis();
		long nano_time_end = System.nanoTime();
        
        TimeWatch tw = new TimeWatch();

 
        try{
            FileWriter fv = new FileWriter("100000QSI.csv",true);
            BufferedWriter bw = new BufferedWriter(fv);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.println("ite,time_1,time_2,ans");
            
            /*
            for(int i = 1 ; i <= 100000 ; i++){
                start_time = System.currentTimeMillis();
                nano_time_start= System.nanoTime();
                tw.timeWatchBoth(i);
 //               double test = new AlgorithmClosestPair().test2();
                System.out.print("\n" + (i) );
                end_time = System.currentTimeMillis();
                nano_time_end = System.nanoTime();
                System.out.print("\t\t\t" + (end_time - start_time)/1000F);
                System.out.print("\t\t\t" + (nano_time_end - nano_time_start)/1000000000F);    
  //              System.out.print("\t\t\t" + test);
                pw.println((i+1)+","+(end_time - start_time)/1000F+","+
                (nano_time_end - nano_time_start)/1000000000F
                //+","+test
                );           
            }
            */
            for(int i = 1 ; i <= 100000 ; i++){
                int[] myArray = new int[i];
                tw.generateInverse(myArray);
                tw.timeWatchQuickSort(myArray);

                start_time = System.currentTimeMillis();
                nano_time_start= System.nanoTime();
                
 //               tw.timeWatchBoth(i);
 //               double test = new AlgorithmClosestPair().test2();
                System.out.print("\n" + (i) );
                end_time = System.currentTimeMillis();
                nano_time_end = System.nanoTime();
                System.out.print("\t\t\t" + (end_time - start_time)/1000F);
                System.out.print("\t\t\t" + (nano_time_end - nano_time_start)/1000000000F);    
  //              System.out.print("\t\t\t" + test);
                pw.println((i+1)+","+(end_time - start_time)/1000F+","+
                (nano_time_end - nano_time_start)/1000000000F
                //+","+test
                );           
            }

            pw.flush();
            pw.close();
        }
        catch(Exception E){
            System.out.println("No funciono");
        }
        
        
    }

    public void timeWatchBoth(int n){
        int[] myArray = new int[n];
        generateWithOutRepetition(myArray);
        timeWatchHeapSort(myArray);
    } 

    public void timeWatchHeapSort(int[] array){
  //      printArray(array);
        HeapSort heapSort = new HeapSort();
        heapSort.run(array);
 //       printArray(array);

        
    }

    public void timeWatchQuickSort(int[] array){
  //      printArray(array);
        QuickSort quickSort = new QuickSort();
        quickSort.run(array);
 //       printArray(array);

        
    }

    public void timeWatchMergeSort(int[] array){
  //      printArray(array);
        MergeSort mergeSort = new MergeSort();
        mergeSort.run(array);
 //       printArray(array);

        
    }


    public void generateNearlySorted(int[] array){
        int rnd;
        for(int i = 0 ; i < array.length ; i++){
            rnd = (int) Math.floor(Math.random() * (i + 3) + i);;
            array[i] = rnd;
        }        
    }

    public void generateWithRepetition(int[] array){
        int rnd;
        for(int i = 0 ; i < array.length ; i++){
            rnd = (int) Math.floor(Math.random() * (array.length) + 1);;
            array[i] = rnd;
        }        
    }

    public void generateWithOutRepetition(int[] array){
        int pos;
        int maxRandom = array.length;
        Stack <Integer> numbers = new Stack <Integer> ();
        for (int i = 0; i < array.length ; i++) {
            pos = (int) Math.floor(Math.random() * maxRandom ) + 1;
            while (numbers.contains(pos)) {
                pos = (int) Math.floor(Math.random() * maxRandom )+ 1;
            }
            numbers.push(pos);
        }    
        for(int i = 0 ; i < numbers.size() ; i++){
            array[i] = numbers.get(i);          
        }       
    }

    public void generateInverse(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            array[i] = array.length - i;    
        }        
    }

    public void printArray(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print("\n" + array[i]);
        }
    }

}
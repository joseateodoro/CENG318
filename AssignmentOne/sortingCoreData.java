import java.util.Random;

public class sortingCoreData {
    public static void main(String[] args) {
        
        int[] coreData = new int[1000000];
        
        int[] insertionTest = new int[1000];
        int[] selectionTest = new int[1000];
        int[] mergeTest = new int[1000];
        int[] quickTest = new int[1000];
        
        for(int i = 0; i < coreData.length; i++) {
            coreData[i] = new Random().nextInt(3000000);
        }

        for(int i = 0; i < 1000; i++) {
            insertionTest[i] = coreData[i];
            selectionTest[i] = coreData[i];
            mergeTest[i] = coreData[i];
            quickTest[i] = coreData[i];
        }

        long start = System.nanoTime();
        insertionSort(insertionTest);
        selectionSort(selectionTest);
        mergeTest(mergeTest);
        quickTest(quickTest);
        long end = System.nanoTime();
        long timeTaken = end - start;
  
        System.out.println("The Amount Of Time It Took To Sort In NanoSeconds:" + timeTaken);
    }

    //insertion sort
    void insertionSort(int[] insertionTest, int numItems) {
        for (int startPoint=1; startPoint<numItems;startPoint++) {
            int temp = insertionTest[startPoint];
            int presLoc = startPoint - 1;
            while(presLoc>=0 && insertionTest[presLoc]>temp) {
                insertionTest[presLoc+1] = insertionTest[presLoc]; 
                presLoc--;
            } 
            insertionTest[presLoc+1] = temp; 
        }
    }

    //selection sort
    public void selectionSort(int[] selectionTest, int numItems){
        for (int startPoint=0;startPoint<numItems-1;startPoint++){
          int smallestLoc = startPoint;
          for (int i=smallestLoc+1;i<numItems;i++){
            if (selectionTest[i] < selectionTest[smallestLoc]){
              smallestLoc=i;
            }   
          }
          int temp = selectionTest[startPoint];
          selectionTest[startPoint] = selectionTest[smallestLoc];
          selectionTest[smallestLoc] = temp;
        }    
    }

     //merge sort
     public void mergeSort(int[] mergeTest){
        mergeSortWorker(0, mergeTest.length);
      }

      public void mergeSortWorker(int lo, int upper) {
        int md;
        if(lo < upper){
            md = (lo + upper) / 2;
            mergeSortWorker(lo, md);
            mergeSortWorker(md+1, upper);
            mergeTogether(lo, md, upper);
        }
      }

      public void mergeTogether(int lo, int md, int hi) {
          int i, j, k;
          int[] temp = new int[hi - lo + 1];
          i = lo;
          j = md + 1;
          k = 0;

          while(i<=md && k<=hi) {
            if(mergeTest[i]<mergeTest[j]) {
                temp[k] = mergeTest[i];
                i++;
            }
            else {
                temp[k] = mergeTest[j];
                j++;
            }
            k++;
          }
          while(i<=md) {
              temp[k] = mergeTest[i];
              i++;
              k++;
          }
          while(j<=hi) {
              temp[k] = mergeTest[j];
              j++;
              k++;
          }
    }

    /*
    //quick sort
    public void quickSort(int lo, int hi) {
        quickSortWorker(0, quickTest.length);
      }

      public void quickSortWorker(int lo, int hi) {
        if(lo < hi) {
            int pivot = partition(lo, hi);
            quickSortWorker(lo, pivot-1);
            quickSortWorker(pivot+1, hi);
          }
      }

      int partition(int lo, int hi) {
          int x = lo - 1;
          int pivot = quickTest[hi];
          for(int i=lo; i<=hi; i++) {
            if(quickTest[i] < pivot) {
                x++;
                int temp = quickTest[i];
                quickTest[i] = quickTest[x];
                quickTest[x] = temp;
            }
          }
          int temp = quickTest[x + 1];
          quickTest[x + 1] = quickTest[hi];
          quickTest[hi] = temp;
          return x + 1;
      }
      */
}
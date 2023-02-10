import java.util.Random;

public class sortingCoreData {
    public static void main(String[] {
        
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
    }
}
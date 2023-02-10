public class quadHashTable {
    private String table[];
    private int tableSize;
    int numItems;
    private double loadFactor;
    
    public quadHashTable(int max,double loadFactor){
        table = new String[max];
        tableSize = max;
        this.loadFactor=loadFactor;
        numItems=0;
    }
    
    private int hashFunction(String key){
        int value=0,weight=1;
        for (int x=0;x<key.length();x++){
            value += (key.charAt(x)-'a'+1)*weight;
            weight++;
        }      
        return value%tableSize;
    }
    
    public void add (String word){
        if (numItems/tableSize <loadFactor){
            int collision=0;
            int loc =hashFunction(word);
            System.out.println(word+" hashes to location "+loc);
            while (table[loc]!=null && table[loc].compareTo("--DEL--")!=0){
                ///loc =(loc +1) % tableSize;
                collision++;
                loc = (loc + collision * collision)%tableSize;
            }
            table[loc]=word;
            numItems++;
        }
    }
    
    public int search (String key){
        int loc = hashFunction(key);
        int collision=0;
        while (table[loc]!=null && table[loc].compareTo(key)!=0){
                collision++;
                loc = (loc + collision * collision)%tableSize;
        }
        if (table[loc]==null)
            return-1;
        return loc;
    }
    
    public void delete(String key){
        int loc = hashFunction(key);
        int collision=0;
        while (table[loc]!=null && table[loc].compareTo(key)!=0){
                collision++;
                loc = (loc + collision * collision)%tableSize;
        }
        if (table[loc]!=null){
            table[loc]="--DEL--";
            numItems--;
        } 
    }
    
    public void printTable(){
        System.out.println("--Table Values--");
        for (int x=0;x<tableSize;x++){
            if(table[x]==null){
                System.out.println("Empty");
            }else{
                System.out.println(table[x]);
            }
        }
    }    
}

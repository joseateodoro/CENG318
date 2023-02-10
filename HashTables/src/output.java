public class output {
    public static void main(String[] args) {
        quadHashTable h1 = new quadHashTable(14,0.8);
        h1.add("apple");
        h1.add("pear");
        h1.add("zoo");
        h1.add("aa");
        h1.add("rhododendron");
        h1.add("chair");
        h1.add("dog");
        h1.printTable();
        h1.delete("pear");
        System.out.println("_______________");
        h1.printTable();
        System.out.println("pear found at location: "+h1.search("pear"));
        System.out.println("zoo found at location: "+h1.search("zoo"));
        h1.add("pear");
        System.out.println("_______________");
        h1.printTable();
}
}

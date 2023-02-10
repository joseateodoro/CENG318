/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameshop;

import java.util.Scanner;

/**
 *
 * @author Jose Antonio Teodoro N01384776 
 *         Jonathan Alexandris N01352690
 */
public class GameShop {

    public static int getInteger(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.nextLine(); // clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextInt();
    }

    public static double getDouble(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            sc.nextLine(); // clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextDouble();
    }

    public static void viewMenu(BinaryTree Bt, Backpack bk, Scanner sc, Player p) {
        String input;
        while (true) {
            System.out.println("***********WELCOME TO THE SHOP MENU*********");
            System.out.println("1) Add Items to the shop");
            System.out.println("2) Delete Items from the shop");
            System.out.println("3) Buy From The Shop");
            System.out.println("4) View Backpack");
            System.out.println("5) View Player");
            System.out.println("***********Enter 'exit' To Leave Program*********");
            input = sc.next();
            switch (input) {
                case "1":
                    addWeapons(Bt, sc);
                    break;
                case "2":
                    deleteWeapon(Bt, sc);
                    break;
                case "3":
                    showRoom(Bt, bk, sc, p); 
                    break;
                case "4":
                    bk.printBackpack();
                    break;
                case "5":
                    p.printCharacter();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input, Please Try Again:");
            }
        }
    }

    public static void addWeapons(BinaryTree Bt, Scanner sc) {
        System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
        String weaponName;
        int weaponRange;
        int weaponDamage;
        double weaponWeight;
        double weaponCost;
        int quantity;
        Bt.inOrderVisitPrint(Bt.root);
        System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
        weaponName = sc.next();
        while (weaponName.compareTo("end") != 0) {
            weaponRange = getInteger(sc, "Please enter the Range of the Weapon (0-10):");
            weaponDamage = getInteger(sc, "Please enter the Damage of the Weapon:");
            weaponWeight = getDouble(sc, "Please enter the Weight of the Weapon (in pounds):");
            weaponCost = getDouble(sc, "Please enter the Cost of the Weapon:");
            Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
            quantity = getInteger(sc, "Please enter the quantity in stock:");
            Bt.insert(w, quantity);
            System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
            weaponName = sc.next();
        }
    }

    // DEBUG
    public static void deleteWeapon(BinaryTree Bt, Scanner sc) {
        System.out.println("***********WELCOME TO THE WEAPON DELETION MENU*********");
        Bt.inOrderVisitPrint(Bt.root);
        System.out.println("Please enter the a Weapon you would like to DELETE out of the shop ('end' to quit):");
        String weaponDel;
        weaponDel = sc.next();
        while (weaponDel.compareTo("end") != 0) {
            Bt.deleteItem(weaponDel);
            Bt.inOrderVisitPrint(Bt.root);
            System.out.print("Please enter the NAME of another Weapon to DELETE out of the shop('end' to quit):");
            weaponDel = sc.next();
        }
    }

    public static void showRoom(BinaryTree Bt, Backpack b, Scanner sc, Player p) {
        String choice;
        System.out.println("WELCOME TO THE SHOWROOM!!!!");
        System.out.println("You have " + p.money + " money.");
        Bt.inOrderVisitPrint(Bt.root);
        System.out.println("Please select a weapon to buy('end' to quit):");
        choice = sc.next();
        while (choice.compareTo("end") != 0 && !p.inventoryFull()) {
            ShopItem si = Bt.get(choice);
            if (si != null) {
                if (si.item.cost > p.money) {
                    System.out.println("Insufficient funds to buy " + si.item.weaponName);
                } else {
                    // calling max weight methods before purchase
                    if (p.backpack.checkMaxWeight(si) == true) {
                        BNode key = new BNode(si);
                        b.addLast(key);
                        p.buy(key);
                        p.withdraw(si.item.cost);
                        si.numberInStock--;
                        System.out.println("Item" + choice + "was purchased");
                    } else {
                        System.out.println("can not purchase item max weight of backpack exceeded");
                    }
                } // closes else if u have enough money
            } else { // if si was not found
                System.out.println(" ** " + choice + " not found!! **");
            }
            System.out.println("Enter another item name to purchase or enter end to quit: ");
            choice = sc.next();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pname;
        System.out.println("Please enter Player name:");
        pname = sc.next();
        Player pl = new Player(pname, 45);
        BinaryTree Bt = new BinaryTree();
        Backpack bk = new Backpack();
        while(true){
            viewMenu(Bt, bk, sc, pl);
        }
    }

}

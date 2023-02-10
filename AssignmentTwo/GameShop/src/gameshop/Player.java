/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameshop;

/**
 *
 * @author Jose Antonio Teodoro N01384776 
 *         Jonathan Alexandris N01352690
 */

class Player
{
        public String name;
        //public Weapon[] backpack;
        public int numItems;
        public double money;
        public Backpack backpack; //player has property of type backpack

        public Player(String n, double m)
        {
            name = n;
            money = m;
        }

        public void buy(BNode newBNode)
        {
            System.out.println(newBNode.data.item.weaponName + " bought...");
            System.out.println();
        }

        public void withdraw(double amt)
        {
            money = money - amt;
        }

        public boolean inventoryFull()
        {
            return (numItems == 10) ;
        }


        public void printCharacter()
        {
            System.out.println(" Name:"+name+"\n Money:"+money);
            printBackpack();
        }

        public void printBackpack()
        {
             System.out.println(" "+name+", you own "+numItems+" Weapons:");
            for (int x = 0; x < numItems; x++)
            {
                // System.out.println(" "+backpack[x].weaponName);
            }
            System.out.println();
        }
    }

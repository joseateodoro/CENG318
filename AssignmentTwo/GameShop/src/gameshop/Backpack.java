
package gameshop;
    // This class should implement a backpack as a linked list
    // The backpack can hold any number of weapons as long as maxWeight is not crossed.
    // If an attempt to add a weapon to backpack is rejected due to weight
    /**
     *
     * @author Jose Antonio Teodoro N01384776 
     *         Jonathan Alexandris N01352690
     */
    class Backpack
    {
        double maxWeight;
        double presentWeight;
        private LNode head;
        
        public Backpack() {
            head = null;
        }

        public boolean checkMaxWeight(ShopItem sItem){
              double weight = getNewItemWeight(sItem);
                // traverse linked list add up all weights of backpack and new item
                 if (head == null) {
                    return true;
                    }
            LNode curr = head;
            while(curr.next != null) {
                    curr=curr.next;
                    weight += curr.data.data.item.weight;
                }

                if(weight <= maxWeight){
                        return true;
                    } else {
                        return false;
                    }
         }
        

         public double getNewItemWeight(ShopItem sitem){
                double weight = sitem.item.weight;
                ///returns the weight of the item player is buying
                return weight;
         }

        LNode addLast(BNode d) {
            LNode n = new LNode(d);
            if (head == null) {
                head = n;
                return n;
            }
            LNode curr = head;
            while(curr.next != null) {
                curr=curr.next;
            }  
            curr.next=n;
            return n;
        }

        public String printBackpack() { 
            String s="Weapon Item List: ";
            LNode current = head;
    
            while(current!=null){
                s += current.data+" ";
                current=current.next;
            }
    
            return s;
        } 
}

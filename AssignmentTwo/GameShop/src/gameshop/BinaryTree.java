package gameshop;
/**
 *
 * @author Jose Antonio Teodoro N01384776 
 *         Jonathan Alexandris N01352690
 */

public class BinaryTree {

    public BNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Weapon data, int quantity) {

        ShopItem sItem = new ShopItem(data, quantity);
        BNode newNode = new BNode(sItem);

        if (root == null) {
            root = newNode;
            return;
        }
        BNode par, curr;
        par = curr = root;

        while (curr != null) {
            par = curr;
            if (curr.data.item.weaponName.compareTo(data.weaponName) > 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (data.weaponName.compareTo(par.data.item.weaponName) < 0) {
            par.left = newNode;
        } else {
            par.right = newNode;
        }

    }

    public void inOrderVisitPrint(BNode recursiveNode) {
        BNode curr = recursiveNode;
        if (curr != null) {
            inOrderVisitPrint(curr.left);
            System.out.println("Name: " + curr.data.item.weaponName + "   Damage:" + curr.data.item.damage + "    Cost:"
                    + curr.data.item.cost + "     Quantity in stock:" + curr.data.numberInStock);
            inOrderVisitPrint(curr.right);
        }
    }

    public BNode getBNode(ShopItem choice) {
        BNode curr;
        curr = root;
         while (curr.left != null || curr.right != null) {
            if (curr.data.item.weaponName.compareTo(choice.item.weaponName) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }

            if (curr.data.item.weaponName.equalsIgnoreCase(choice.item.weaponName)) { 
                return curr;
            }
        }
        System.out.println("bnode not found");
        return null;
    }

    public ShopItem get(String choice) {
        BNode curr;
        curr = root;
         while (curr.left != null || curr.right != null) {
            if (curr.data.item.weaponName.compareTo(choice) > 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            
            if (curr.data.item.weaponName.equalsIgnoreCase(choice)) { 
                //System.out.println("The item" + curr.data.item.weaponName + "is availible");
                return curr.data;
            }
        }
        System.out.println("item you searched for wasnt found");
        return null;
        }

    public void deleteItem(String key) {
        root = deleteRecursive(root, key);
        System.out.println("ITEM DELETED!");
    }

    BNode deleteRecursive(BNode root, String key) {
        if (root == null) //case 1
            return root;
        
        //case 2
        if (key.compareTo(root.data.item.weaponName) > 0){
            root.left = deleteRecursive(root.left, key);
         }
        else if (key.compareTo(root.data.item.weaponName) < 0){
            root.right = deleteRecursive(root.right, key);
        }
            else {
                // found it
                //case 3
                if (root.left == null)
                    return root.right;
                if (root.right == null)
                    return root.left;
                BNode succ = root.right;
                while (succ.left != null) {
                    succ = succ.left;
                }
                root.data = succ.data;
                root.right = deleteRecursive(root.right, succ.data.item.weaponName);
        }
        return root;
    }

}

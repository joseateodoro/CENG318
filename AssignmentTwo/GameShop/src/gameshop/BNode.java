package gameshop;

public class BNode{
    public ShopItem data;
    public BNode left,right;

    public BNode(ShopItem data){
        this.data = data;
        this.left = this.right = null;
    }

}
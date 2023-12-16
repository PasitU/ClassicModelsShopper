package int204.prefin.jpapractice.models;

import int204.prefin.jpapractice.models.entities.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartItem {
    private Product product;
    private int quantity;
    private double percentDiscount;
    public CartItem(Product product){
        this.product = product;
        this.quantity = 1;
        this.percentDiscount = 0.00d;
    }
    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        this.percentDiscount = 0.00d;
    }
    public CartItem(Product product, int quantity, double percentDiscount){
        this.product = product;
        this.quantity = quantity;
        this.percentDiscount = percentDiscount;
    }

    public double getPrice(){
        return this.product.getMSRP();
    }

    public double getTotalPrice(){
        return getPrice()*this.quantity - this.percentDiscount*getPrice()*this.quantity;
    }
}

package int204.prefin.jpapractice.models;

import int204.prefin.jpapractice.models.entities.Product;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Getter

@ToString
public class Cart {
    private Map<String, CartItem> cart;

    public Cart() {
        this.cart = new HashMap();
    }

    public void addItem(String key, CartItem val) {
        if (cart.get(key) == null) {
            cart.put(key, val);
        } else {
            cart.get(key).setQuantity(cart.get(key).getQuantity() + val.getQuantity());
        }
    }

    public int getTotalItems() {
        return cart.size();
    }

    public double getTotalPrice() {
        return cart.values().stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public int getTotalQuantity() {
        return cart.values().stream().mapToInt(CartItem::getQuantity).sum();
    }
    public Collection<CartItem> getAllItem() {
        return Collections.unmodifiableCollection(cart.values());
    }
    public void removeItem(String code) {
        cart.remove(code);
    }
    public void clear(){
        cart.clear();
    }

    public CartItem getItem(String key){
        if(cart.get(key) != null){
            return cart.get(key);
        }
        return null;
    }
}

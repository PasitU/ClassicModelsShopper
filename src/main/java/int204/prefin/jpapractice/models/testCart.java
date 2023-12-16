package int204.prefin.jpapractice.models;

import int204.prefin.jpapractice.models.entities.Product;
import int204.prefin.jpapractice.models.repositories.ProductRepository;

public class testCart {
    public static void main(String[] args) {
        Cart cart = new Cart();
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.findProduct("S10_1678");
        cart.addItem(product.getProductCode(), new CartItem(product,5));
        cart.addItem(product.getProductCode(), new CartItem(product,5));
        product = productRepository.findProduct("S12_3380");
        cart.addItem(product.getProductCode(), new CartItem(product));
        System.out.println(cart.getTotalItems());
        System.out.println(cart.getTotalQuantity());
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getAllItem());
        cart.removeItem("S10_1678");
        System.out.println(cart.getAllItem());
    }
}

package int204.prefin.jpapractice.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Setter
@Getter
@NamedQueries({
        @NamedQuery(name = "PRODUCT_GETALL", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "PRODUCT_GETTOTALPRODUCTS", query = "SELECT COUNT(*) FROM Product p")
})
public class Product {
    @Id
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    private Double MSRP;
}

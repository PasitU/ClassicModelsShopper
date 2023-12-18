package int204.prefin.jpapractice.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "CUSTOMER_GETALL", query = "SELECT c FROM Customer c"),
        @NamedQuery(name = "CUSTOMER_GETBYFULLNAME", query = "SELECT c FROM Customer c WHERE concat(contactFirstName,' ',contactLastName) like :fullname")
})
public class Customer {
    @Id
    private String customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String salesRepEmployeeNumber;
    private String creditLimit;
    private String password;
}

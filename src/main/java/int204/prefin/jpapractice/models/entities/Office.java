package int204.prefin.jpapractice.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Table(name = "offices")
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "OFFICE_GETALL", query = "SELECT o FROM Office o"),
        @NamedQuery(name = "OFFICE_FINDBYCODE", query = "SELECT o FROM Office o WHERE o.officeCode = :officeCode")
})
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "officeCode")
    private List<Employee> employeeList;
}

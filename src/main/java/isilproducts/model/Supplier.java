package isilproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Supplier {
    private String ruc;
    private String name;
    private String contactEmail;
    private String contactMobilePhone;
    private Set<Product> products;

    public Supplier(String ruc, String name, String contactEmail, String contactMobilePhone) {
        this.ruc = ruc;
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactMobilePhone = contactMobilePhone;
    }
}

package isilproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
    private String sku;
    private String name;
    private Integer stock;
    private Double price;

}

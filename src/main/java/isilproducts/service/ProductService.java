package isilproducts.service;

import isilproducts.model.Product;
import isilproducts.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductService {
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product("u0001", "lavadora", 20, 49.50),
                    new Product("u0002", "secadora", 15, 25.00)
            )
    );
    public List<Product> getAll(){
        return products;
    }
    public void saveProduct(Product product) {
        products.add(product);
    }
    public void deleteProduct(String sku) {
        Product currentProduct = findById(sku);
        products.remove(currentProduct);
    }
    public void updateProduct(Product product) {
        Product currrentProduct = findById(product.getSku());
        int index = products.indexOf(currrentProduct);
        product.setSku(currrentProduct.getSku());
        products.set(index, product);
    }
    public Product findById(String sku) {
        Product product = products.stream()
                .filter(s -> s.getSku().equalsIgnoreCase(sku))
                .findFirst()
                .orElseGet(null);
        return product;
    }
}

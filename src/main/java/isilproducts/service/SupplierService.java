package isilproducts.service;

import isilproducts.model.Product;
import isilproducts.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SupplierService {
    Set<Product> p1 = new HashSet<>(Arrays.asList(new Product("u0001", "focos de luz", 20, 49.50)));
    Set<Product> p2 = new HashSet<>(Arrays.asList(new Product("u0002", "secadora", 15, 75.00)));
    List<Supplier> suppliers = new ArrayList<>(
            Arrays.asList(
                    new Supplier("20103795631", "Electro Oriente", "contact@elor.com", "065225133", p1),
                    new Supplier("13589453684", "Phillips", "contact@phillips.com", "014221325", p2)
            )
    );
    public List<Supplier> getAll(){
        return suppliers;
    }
    public void saveSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }
    public void deleteSupplier(String ruc) {
        Supplier currentSupplier = findById(ruc);
        suppliers.remove(currentSupplier);
    }
    public void updateSupplier(Supplier supplier) {
        Supplier currrentSupplier = findById(supplier.getRuc());
        int index = suppliers.indexOf(currrentSupplier);
        supplier.setRuc(currrentSupplier.getRuc());
        suppliers.set(index, supplier);
    }
    public Supplier findById(String ruc) {
        Supplier supplier = suppliers.stream()
                .filter(s -> s.getRuc().equalsIgnoreCase(ruc))
                .findFirst()
                .orElseGet(null);
        return supplier;
    }
}

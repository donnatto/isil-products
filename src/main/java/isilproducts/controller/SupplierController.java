package isilproducts.controller;

import isilproducts.model.Supplier;
import isilproducts.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    SupplierService suppliersService;

    @GetMapping("/suppliers")
    public String getSupplierList(Model model) {
        // List
        List<Supplier> suppliers =suppliersService.getAll();
        model.addAttribute("suppliers", suppliers);
        return "suppliers";
    }

    @GetMapping("/suppliers/add")
    public String addSupplier(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier-add";
    }

    @GetMapping("/suppliers/edit/{ruc}")
    public String editSupplier(@PathVariable String ruc, Model model) {
        // Find supplier
        model.addAttribute("supplier", suppliersService.findById(ruc));
        // Edit page redirect
        return "supplier-edit";
    }

    @PostMapping("/suppliers/save")
    public String saveSupplier(Supplier supplier) {
        // Save
        suppliersService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @PostMapping("/suppliers/saveedit")
    public String saveEdit(Supplier supplier) {
        // Save
        suppliersService.updateSupplier(supplier);
        // List
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/delete/{ruc}")
    public String deleteSupplier(@PathVariable String ruc) {
        // Delete
        suppliersService.deleteSupplier(ruc);
        // Redirect
        return "redirect:/suppliers";
    }
}

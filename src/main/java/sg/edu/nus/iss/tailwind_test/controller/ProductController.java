package sg.edu.nus.iss.tailwind_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.tailwind_test.model.Product;
import sg.edu.nus.iss.tailwind_test.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService pdtService;

    @GetMapping()
    public String getProducts(Model model) {
        List<Product> productsList = pdtService.getProductsList();
        // System.out.println(productsList.get(0).getId());
        model.addAttribute("products", productsList);

        return "products";
    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable String id) {
        // System.out.println(id);
        Product productFound = pdtService.findById(id);

        // if (productFound.getQuantity() == 0){
        //     ObjectError error = new ObjectError("negQty", "The product you wish to buy is sold out!");
        //     result.addError(error);
        //     return "redirect:/products";
        // }
        pdtService.saveProductfile(productFound);

        return "redirect:/products";
    }
    
    
}

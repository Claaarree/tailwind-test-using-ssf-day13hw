package sg.edu.nus.iss.tailwind_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.tailwind_test.model.Product;
import sg.edu.nus.iss.tailwind_test.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository pdtRepo;

    public List<Product> getProductsList() {
        return pdtRepo.getProductsList();
    }

    public Product findById(String id){
        return pdtRepo.findById(id);
    }

    public void saveProductfile(Product productFound){
        productFound.setSold(productFound.getSold() + 1);
        productFound.setQuantity(productFound.getQuantity() - 1);
        pdtRepo.saveProductfile();
    }
}

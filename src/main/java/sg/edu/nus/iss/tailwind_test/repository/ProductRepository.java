package sg.edu.nus.iss.tailwind_test.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.tailwind_test.model.Product;
import sg.edu.nus.iss.tailwind_test.utility.FileManager;

@Repository
public class ProductRepository {
    private List<Product> productsList;

    public List<Product> getProductsList(){
        productsList = FileManager.readProductFile();
        return productsList;
    }

    public Product findById(String id){
        // System.out.println("in findbyid pdtrepo");

        Product productFound = null;
        for (Product p : productsList) {
            // System.out.println(p.getId());
            if (p.getId().equals(id)) {
                productFound = p;
            }
        }
        return productFound;
    }

    public void saveProductfile() {
        FileManager.saveProductfile(productsList);
    }
}

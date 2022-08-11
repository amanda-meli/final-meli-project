package meli.dh.com.finalmeliproject.service.product;

import meli.dh.com.finalmeliproject.dto.ProductDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import meli.dh.com.finalmeliproject.service.buyer.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepo repo;

    @Autowired
    private IBuyerService buyerService;

    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return repo.saveAll(products);
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = repo.findAll();

        if (products.size() == 0) {
            throw new NotFoundExceptionImp("Dont exist products");
        }

        return products;
    }


    public Product checkStock(String id) {
        Product product = repo.findById(id);

        if (product == null) {
            throw new NotFoundExceptionImp("Product not found");
        }

        return product;
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        List<Product> productsByCategory =  repo.findAll().stream()
                .filter(product -> product.getCategory().getCategoryName().equals(category))
                .collect(Collectors.toList());

        if (productsByCategory.isEmpty()){
            throw new NotFoundExceptionImp("Category not found.");
        }
        return productsByCategory;
    }


}
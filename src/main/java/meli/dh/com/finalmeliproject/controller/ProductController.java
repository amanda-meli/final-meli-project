package meli.dh.com.finalmeliproject.controller;

import com.sun.istack.Nullable;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /***
     * Retorna todos os produtos
     * @return todos os produtos disponíveis
     */
    @GetMapping
    public ResponseEntity<List<Product>> findProductsList(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/check-stock/{id}")
    public ResponseEntity<Integer> checkStock(@PathVariable String id){
        return new ResponseEntity<>(productService.checkStock(id).getQuantity(),HttpStatus.OK);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Product>> listingProductsByCategory (@RequestParam @Nullable String category){
        List<Product> productsByCategory = productService.findProductsByCategory(category);
        return ResponseEntity.ok().body(productsByCategory);
    }
}

package nt.WareHouse.RestController;

import lombok.RequiredArgsConstructor;
import nt.WareHouse.Dao.Product;
import nt.WareHouse.Dto.ProductDto;
import nt.WareHouse.Dto.ResponseDto;
import nt.WareHouse.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addProduct")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productServise;

    @PostMapping("/input")
    public ResponseDto addProduct(@RequestBody ProductDto productDto){
        return productServise.addProduct(productDto);
    }

    @PostMapping("/get-all")
    public ResponseDto<Page<ProductDto>> getAllProduct(@RequestParam Integer size, @RequestParam Integer page){
        return productServise.getAllProducts(size, page);
    }

    @GetMapping("/byProductId/{productId}")
    public List<Product> getByproductId(@PathVariable Integer productId) {
        return productServise.getByproductId(productId);
    }

    @PutMapping("/{id}")
    public ResponseDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return productServise.updateProduct(id, productDto);
    }


    @DeleteMapping("/{id}")
    public ResponseDto deleteProductById(@PathVariable Integer id) {
        return productServise.deleteProductById(id);
    }
}

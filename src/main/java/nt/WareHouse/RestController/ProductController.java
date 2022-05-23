package nt.WareHouse.RestController;

import lombok.RequiredArgsConstructor;
import nt.WareHouse.Dao.Product;
import nt.WareHouse.Dto.ProductDto;
import nt.WareHouse.Dto.ResponseDto;
import nt.WareHouse.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addProduct")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productServise;

    @PostMapping("/input")
    public ResponseDto addProduct(@RequestBody ProductDto productDto){
        return productServise.addProduct(productDto);
    }

    @GetMapping("/get-all")
    public ResponseDto<Page<ProductDto>> getAllProduct(@RequestParam Integer size, @RequestParam Integer page){
        return productServise.getAllProducts(size, page);
    }

    @GetMapping("/byProductId/{productId}")
    public ResponseDto<Product> getByproductId(@PathVariable Integer productId) {
        return productServise.getByproductId(productId);
    }

    @PutMapping("update/{id}")
    public ResponseDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return productServise.updateProduct(id, productDto);
    }

    @GetMapping("/get-all-via-param")
    public ResponseDto<?> getAllViaParam(@RequestParam MultiValueMap<String, String> params){
        return productServise.getViaParam(params);
    }

    @DeleteMapping("delete/{id}")
    public ResponseDto deleteProductById(@PathVariable Integer id) {
        return productServise.deleteProductById(id);
    }
}

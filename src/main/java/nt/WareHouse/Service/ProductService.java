package nt.WareHouse.Service;

import lombok.RequiredArgsConstructor;
import nt.WareHouse.Dao.Product;
import nt.WareHouse.Dto.ProductDto;
import nt.WareHouse.Dto.ResponseDto;
import nt.WareHouse.Mapping.ProductMapping;
import nt.WareHouse.Repository.ProductRepository;
import nt.WareHouse.Repository.implement.ProductRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;
    public final ProductRepositoryImpl productRepositoryimpl;

    public ResponseDto addProduct(ProductDto productDto) {
        return new ResponseDto(true, 0,"Maxsulot qo'shildi", productRepository.save(ProductMapping.toEntity(productDto)));
    }

    public ResponseDto<Page<ProductDto>> getAllProducts(Integer size, Integer page){
        PageRequest pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);
        if (!products.isEmpty()){
            List<ProductDto> response = new ArrayList<>();
            for (Product product: products){
                response.add(ProductMapping.toDto(product));
            }

            Page<ProductDto> result = new PageImpl(response, products.getPageable(), products.getTotalElements());
            return new ResponseDto<>(true, 0, "OK", result);
        }

        return new ResponseDto<>(false, -1, "ERROR", null);
    };

    public ResponseDto<Product> getByproductId(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        if (!optional.isPresent()){
            return new ResponseDto<>(false,-1,"Error",null);
        }
        Product product = optional.get();
        return new ResponseDto<>(true, 0, "OK", product);
    }

    public ResponseDto<ProductDto> updateProduct(Integer id, ProductDto productDto) {
        try {
            Optional<Product> products = productRepository.findById(id);
            if (products.isEmpty()){
                return new ResponseDto<>(false, -3, "Bu ID ga mos malumotlar mavjud emas", null);
            }
             Product product = products.get();
            ProductMapping.setEntity(product, productDto);

            productRepository.save(product);

            return new ResponseDto(true, 0, "OK", product);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto<>(false, -1, e.getMessage(), null);
        }
    }

    public ResponseDto deleteProductById(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()){
            return new ResponseDto(false, -3,"Mahsulot topilmadi", null);
        }
        Product product = optional.get();
        productRepository.delete(product);
        return new ResponseDto(true,0,"O'chirildi", product);
    }

    public ResponseDto<?> getViaParam(MultiValueMap<String, String> params) {
        Optional<?> optionalProducts = productRepositoryimpl.getProductsViaParam(params);

        if(!optionalProducts.isPresent()){
            return new ResponseDto<>(false, -1, "Bunday ma'lumot mavjud emas",null);
        }
        else return new ResponseDto<>(true, 0, "Siz qidirgan ma'lumotlarga " +
                "mos ma'lumotlar topildi",optionalProducts);
    }
}

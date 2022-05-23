package nt.WareHouse.Mapping;

import nt.WareHouse.Dao.Product;
import nt.WareHouse.Dto.ProductDto;

public class ProductMapping {
    public static Product toEntity(ProductDto productDto){
        return  new Product(productDto.getId(),
                productDto.getName(),
                productDto.getGrade(),
                productDto.getType(),
                productDto.getPrice(),
                productDto.getExpiredate(),
                productDto.getWarehouse(),
                productDto.getQuantity(),
                productDto.getSupplierindex());
    }

    public static ProductDto toDto(Product product){
        ProductDto productDto = new ProductDto(product.getId(),
                product.getName(),
                product.getWareHause(),
                product.getPrice(),
                product.getExpireDate(),
                product.getType(),
                product.getGrade(),
                product.getQuantity(),
                product.getSupplierIndex());
        return productDto;
    }

    public static void setEntity(Product product, ProductDto productDto){
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setType(productDto.getType());
        product.setWareHause(productDto.getWarehouse());
        product.setQuantity(productDto.getQuantity());
        product.setSupplierIndex(productDto.getSupplierindex());
        product.setExpireDate(productDto.getExpiredate());
        product.setGrade(productDto.getGrade());
    }
}

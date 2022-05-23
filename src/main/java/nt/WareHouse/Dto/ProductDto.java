package nt.WareHouse.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProductDto {

    private Integer id;

    private String name;

    private String warehouse;

    private double price;

    private Date expiredate;

    private String type;

    private String grade;

    private double quantity;

    private Integer supplierindex;

    public ProductDto(Integer id, String name, String warehouse, double price, Date expiredate, String type, String grade, double quantity, Integer supplierindex) {
        this.id = id;
        this.name = name;
        this.warehouse = warehouse;
        this.price = price;
        this.expiredate = expiredate;
        this.type = type;
        this.grade = grade;
        this.quantity = quantity;
        this.supplierindex = supplierindex;
    }
}

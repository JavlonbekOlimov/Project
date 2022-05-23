package nt.WareHouse.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    @NonNull
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private String grade;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "ware_house")
    private String wareHause;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "supplier_index")
    private Integer supplierIndex;

    public Product(Integer id, String name, String grade, String type, double price, Date expireDate, String wareHause, double quantity, Integer supplierIndex) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.type = type;
        this.price = price;
        this.expireDate = expireDate;
        this.wareHause = wareHause;
        this.quantity = quantity;
        this.supplierIndex = supplierIndex;
    }
}

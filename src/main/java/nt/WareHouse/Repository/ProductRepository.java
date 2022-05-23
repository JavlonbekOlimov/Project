package nt.WareHouse.Repository;

import nt.WareHouse.Dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

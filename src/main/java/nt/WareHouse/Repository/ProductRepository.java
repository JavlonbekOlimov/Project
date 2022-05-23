package nt.WareHouse.Repository;

import nt.WareHouse.Dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByIdAndActiveTrue(Integer id);
}

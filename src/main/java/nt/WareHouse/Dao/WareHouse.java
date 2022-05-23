package nt.WareHouse.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WareHouse {

    @Id
    @GeneratedValue(generator = "warehouse_id_seq")
    @SequenceGenerator(name = "warehouse_id_seq", sequenceName = "warehouse_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

}

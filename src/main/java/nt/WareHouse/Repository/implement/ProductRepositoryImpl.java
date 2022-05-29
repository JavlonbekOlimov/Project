package nt.WareHouse.Repository.implement;

import lombok.RequiredArgsConstructor;
import nt.WareHouse.Dao.Product;
import nt.WareHouse.Helper.NumberHelper;
import nt.WareHouse.Helper.StringHelper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl {

    private final EntityManager entityManager;

    public Optional<?> getProductsViaParam(MultiValueMap<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder(" where 1=1");
        queryParams(params, queryBuilder);

        Integer size = NumberHelper.toInt(params.getFirst("size"));
        Integer page = NumberHelper.toInt(params.getFirst("page"));

        boolean isPageable = StringHelper.isValidInt(params.getFirst("size"))
                && StringHelper.isValidInt(params.getFirst("page"));

        if (isPageable) {
            queryBuilder.append(" limit :size offset :page");
        }

        String queryStr = "select * from product " + queryBuilder;
        Query query = entityManager.createNativeQuery(queryStr, Product.class);
        queryValues(params, query);

        if (isPageable) {
            query.setParameter("size", size);
            query.setParameter("page", size * page);
        }

        List<Product> productList = query.getResultList();

        if (isPageable) {
            return Optional.of(new PageImpl<>(productList, PageRequest.of(page, size), productList.size()));
        }

        return Optional.of(productList);
    }

    private void queryValues(MultiValueMap<String, String> params, Query query) {
        if (StringHelper.isValidInt(params.getFirst("id"))) {
            query.setParameter("id", NumberHelper.toInt(params.getFirst("id")));
        }
        if (StringHelper.isValid(params.getFirst("name"))) {
            query.setParameter("name", params.getFirst("name"));
        }
        if (StringHelper.isValid(params.getFirst("ware_house"))) {
            query.setParameter("ware_house", params.getFirst("ware_house"));
        }
        if (StringHelper.isValidDouble(params.getFirst("price"))) {
            query.setParameter("price", NumberHelper.toDouble(params.getFirst("price")));
        }
    }

    private void queryParams(MultiValueMap<String, String> params, StringBuilder queryBuilder) {
        if (StringHelper.isValid(params.getFirst("id"))) {
            queryBuilder.append(" AND id = :id");
        }
        if (StringHelper.isValid(params.getFirst("name"))) {
            queryBuilder.append(" AND name like :name");
        }
        if (StringHelper.isValid(params.getFirst("ware_house"))) {
            queryBuilder.append(" AND ware_house like :ware_house");
        }
        if (StringHelper.isValid(params.getFirst("price"))) {
            queryBuilder.append(" AND price = :price");
        }
    }
}

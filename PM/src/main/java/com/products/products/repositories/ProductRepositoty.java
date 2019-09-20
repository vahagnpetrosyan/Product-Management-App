package com.products.products.repositories;

import com.products.products.entities.ProductEntity;
import com.products.products.utils.SqlStatementReader;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoty {

    private static SqlStatementReader sqlStatementReader = SqlStatementReader.from("queries/queries_product");

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void update(ProductEntity productEntity){
        final String sqlStmt = sqlStatementReader.getStatement("sqlquery.update");

        jdbcTemplate.update(sqlStmt, productEntity.getProductName(), productEntity.getProductCode(),
                                    productEntity.getReleaseDate(), productEntity.getDescription(),
                                    productEntity.getPrice(), productEntity.getStarRating(),
                                    productEntity.getImageUrl(), new Timestamp(System.currentTimeMillis()),
                                    productEntity.getId());
    }

    public ProductEntity create(ProductEntity productEntity){
        final String sqlStmt = sqlStatementReader.getStatement("sqlquery.create");

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(productEntity);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sqlStmt, fileParameters, keyHolder);
        productEntity.setId((Integer) keyHolder.getKeys().get("id"));
        return productEntity;
    }

    public void delete(Integer id){
        final String sqlStmt = sqlStatementReader.getStatement("sqlquery.delete");

        jdbcTemplate.update(sqlStmt, id);
    }

    public List<ProductEntity> findAll(){
        final String sqlStmt = sqlStatementReader.getStatement("sqlquery.select.all");

        return jdbcTemplate.query(sqlStmt, (rs, rowNum) -> new ProductEntity(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("code"),
                rs.getDate("release_date"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getDouble("rating"),
                rs.getString("image_url"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")
        ));
    }

    public ProductEntity findOneById(Integer id){
        final String sqlStmt = sqlStatementReader.getStatement("sqlquery.select.one");

        return jdbcTemplate.queryForObject(sqlStmt, new Object[]{id}, (rs,  rowNum) -> new ProductEntity(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("code"),
                rs.getDate("release_date"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getDouble("rating"),
                rs.getString("image_url"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")
        ));
    }
}

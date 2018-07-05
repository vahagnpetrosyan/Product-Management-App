package com.products.products.repositories;

import com.products.products.entities.ProductEntity;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void update(ProductEntity productEntity){
        final String sqlStmt = "UPDATE products set updated_at=DEFAULT where id=?";
        jdbcTemplate.update(sqlStmt, productEntity.getId());

        this.updateName(productEntity);
        this.updateCode(productEntity);
        this.updateReleaseDate(productEntity);
        this.updateDescription(productEntity);
        this.updatePrice(productEntity);
        this.updateRating(productEntity);
        this.updateImageUrl(productEntity);
    }

    public ProductEntity create(ProductEntity productEntity){
        final String sqlStmt =
                "INSERT INTO products (name, code, release_date, description, price, rating, image_url, created_at, updated_at)"
                + " VALUES (:productName, :productCode, :releaseDate, :description, :price, :starRating, :imageUrl, :createdAt, :updatedAt)";

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(productEntity);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sqlStmt, fileParameters, keyHolder);
        productEntity.setId((Integer) keyHolder.getKeys().get("id"));
        return productEntity;
    }

    public void delete(Integer id){
        final String sqlStmt = "DELETE FROM products where id = ?";

        jdbcTemplate.update(sqlStmt, id);
    }

    public List<ProductEntity> findAll(){
        final String sqlStmt = "SELECT * FROM products";

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
        final String sqlStmt = "SELECT * FROM products where id = ?";

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

    private void updateName(ProductEntity productEntity){
        if(productEntity.getProductName() == null){
            return;
        }
        final String sqlStmt = "UPDATE products SET name = ? where id = ?";

        jdbcTemplate.update(sqlStmt, productEntity.getProductName(), productEntity.getId());
    }

    private void updateCode(ProductEntity productEntity){
        if(productEntity.getProductCode() == null){
            return;
        }
        final String sqlStmt = "UPDATE products set code=? where id=?";

        jdbcTemplate.update(sqlStmt, productEntity.getProductCode(), productEntity.getId());
    }

    private void updateReleaseDate(ProductEntity productEntity){
        if(productEntity.getReleaseDate() == null){
            return;
        }
        final String sqlStmt = "UPDATE products set release_date=? where id=?";

        jdbcTemplate.update(sqlStmt, productEntity.getReleaseDate(), productEntity.getId());
    }

    private void updateDescription(ProductEntity productEntity){
        if(productEntity.getDescription() == null){
            return;
        }
        final String sqlStmt = "UPDATE products set description=? where id=?";

        jdbcTemplate.update(sqlStmt, productEntity.getDescription(), productEntity.getId());
    }

    private void updatePrice(ProductEntity productEntity){
        if(productEntity.getPrice() == null){
            return;
        }
        final String sqlStmt = "UPDATE products set price=? where id=?";

        jdbcTemplate.update(sqlStmt, productEntity.getPrice(), productEntity.getId());
    }

    private void updateRating(ProductEntity productEntity){
        if(productEntity.getStarRating() == null){
            return;
        }

        final String sqlStmt = "UPDATE products set rating=? where id=?";

        jdbcTemplate.update(sqlStmt, productEntity.getStarRating(), productEntity.getId());
    }

    private void updateImageUrl(ProductEntity productEntity){
        if(productEntity.getImageUrl() == null){
            return;
        }

        final String sqlStmt = "UPDATE products set image_url=? where id=?";

        jdbcTemplate.update(sqlStmt, productEntity.getImageUrl(), productEntity.getId());
    }
}

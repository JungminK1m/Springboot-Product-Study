package shop.mtcoding.productapp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {

    public List<Product> findAll();

    public Product findById(Integer id);

    public int insert(Product product);

    public int update(Product product);

    public int deleteById(Integer id);

}

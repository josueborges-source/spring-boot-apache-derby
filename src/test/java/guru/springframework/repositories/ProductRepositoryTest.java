package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final String PRODUCT_DESCRIPTION = "a cool product";
    private static final String IMAGE_URL = "http://an-imageurl.com/image1.jpg";

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        // Configurações iniciais, caso necessário
    }

    @Test
    public void testPersistence() {
        //given
        Product product = new Product();
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setImageUrl(IMAGE_URL);
        product.setPrice(BIG_DECIMAL_100);

        //when
        productRepository.save(product);

        //then
        Assertions.assertNotNull(product.getId());
        Optional<Product> newProductOptional = productRepository.findById(product.getId());
        Assertions.assertTrue(newProductOptional.isPresent());

        Product newProduct = newProductOptional.get();
        Assertions.assertEquals(1L, newProduct.getId());
        Assertions.assertEquals(PRODUCT_DESCRIPTION, newProduct.getDescription());
        Assertions.assertEquals(0, BIG_DECIMAL_100.compareTo(newProduct.getPrice()));
        Assertions.assertEquals(IMAGE_URL, newProduct.getImageUrl());
    }
}

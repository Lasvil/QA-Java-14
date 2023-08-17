import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(11, "Хлеб", 50);
    Product product2 = new Product(54, "Масло", 100);
    Product product3 = new Product(23, "Мыло", 60);
    Product product4 = new Product(64, "Винтик", 5);
    Product product5 = new Product(13, "Шпунтик", 2);
    Product product6 = new Product(1, "Свинья", 1000000);


    @Test
    public void removeExistProduct() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(54);

        repo.findAll();

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void removeNotExistProduct() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(54444));


    }
}

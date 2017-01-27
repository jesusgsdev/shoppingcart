import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import org.junit.Test;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class BasicUsageTest {

    @Test
    public void createProduct(){
        String product = "Pizza,14.40";

        String[] productArray = product.split(",");

        String name = productArray[0].trim();
        Double price = Double.valueOf(productArray[1].trim());

        Product p = new Product(name, price);

        assert(p != null);
        assert(p.getName().equals(name));
        assert(p.getPrice().equals(price));
    }


    @Test
    public void createProductByString(){
        String product = "Pizza,14.40";

        Product p = new Product(product);

        assert(p != null);
        assert(p.getName() != null);
        assert(p.getPrice() != null);
    }


    @Test
    public void createEmptyCart(){
        Cart cart = new Cart();

        assert(cart.getProducts() != null);
        assert(cart.getProducts().isEmpty());
    }

    @Test
    public void addItemToCart(){
        Cart cart = new Cart();
        String product = "Pizza,14.40";

        Product p = new Product(product);
        cart.addProduct(p);

        assert(!cart.getProducts().isEmpty());
        assert(cart.getProducts().size() == 1);
    }

    @Test
    public void addMultipleItemsToCart(){
        Cart cart = new Cart();

        Product p1 = new Product("Pizza M,14.40");
        Product p2 = new Product("Pizza L,24.40");
        cart.addProduct(p1);
        cart.addProduct(p2);

        assert(cart.getProducts().size() == 2);
    }

    @Test
    public void addMultipleItemsToCartByNumber(){
        Cart cart = new Cart();

        Product p1 = new Product("Pizza M,14.40");
        cart.addNProduct(p1, 5);

        assert(cart.getProducts().size() == 5);
    }

    @Test
    public void getTotalFromCartTwoItems(){
        Cart cart = new Cart();
        Product p1 = new Product("Pizza M,14.40");
        Product p2 = new Product("Pizza L,24.40");
        cart.addProduct(p1);
        cart.addProduct(p2);

        assert(cart.getTotal().equals(38.80));
    }

    @Test
    public void getTotalFromCartMultipleItems(){
        Cart cart = new Cart();
        Product p1 = new Product("Pizza M,14.40");
        cart.addNProduct(p1 ,10);

        assert(cart.getTotal().equals(144.00));
    }

}

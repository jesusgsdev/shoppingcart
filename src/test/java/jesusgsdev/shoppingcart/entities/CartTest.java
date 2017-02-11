package jesusgsdev.shoppingcart.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by jesgarsal on 11/02/17.
 */
public class CartTest {

    @Test
    public void when_CreateEmptyCart_Then_ProductsAreEmptyAndTotalIsZero(){
        Cart cart = new Cart();

        Assert.assertNotNull(cart.getProducts());
        assertThat(cart.getProducts(), is(empty()));
        assertThat(cart.getTotal(), is(new Double(0)));
    }

    @Test
    public void when_AddOneItemToTheCart_Then_NumberOfProductsIsOneAndTotalIsUpdated(){
        Cart cart = new Cart();
        Product p = Product.newProduct().name("Pizza").price(14.40).build();
        cart.addProduct(p);

        assertThat(cart.getProducts(), is(not(empty())));
        assertThat(cart.getProducts(), hasSize(1));
        assertThat(cart.getTotal(), is(new Double(14.40)));

    }

    @Test
    public void when_AddMoreThanOneItemsToTheCart_Then_NumberOfProductsIsOneAndTotalIsUpdated(){
        Cart cart = new Cart();
        Integer amount = 5;
        Double price = 14.40;

        Product p1 = Product.newProduct().name("Pizza M").price(price).build();
        cart.addNProducts(p1, amount);

        assertThat(cart.getProducts(), hasSize(amount));
        assertThat(cart.getTotal(), is(new Double(price * amount)));

    }

    @Test
    public void when_CartWithItemsOutput_Then_ListOfItemsAndTotalsIsOut(){
        Cart cart = new Cart();
        Integer amount = 5;
        Double price = 14.40;

        Product p1 = Product.newProduct().name("Pizza M").price(price).build();
        cart.addNProducts(p1, amount);

        String expectedOutput = "Cart{" +
                "products=" + cart.getProducts() +
                ", total=" + cart.getTotal() +
                '}';

        assertThat(cart.toString(), is(expectedOutput));
    }

    @Test
    public void when_TwoCartsAreCreated_Then_BothHaveDifferentEqualsAndHashcode(){
        Cart cart = new Cart();
        Product p = Product.newProduct().name("Pizza").price(14.40).build();
        cart.addProduct(p);

        Cart cart2 = new Cart();
        Product p2 = Product.newProduct().name("Pizza").price(14.40).build();
        cart2.addProduct(p2);

        assertFalse(cart.equals(cart2));
        assertNotEquals(cart.hashCode(), cart2.hashCode());
    }

}

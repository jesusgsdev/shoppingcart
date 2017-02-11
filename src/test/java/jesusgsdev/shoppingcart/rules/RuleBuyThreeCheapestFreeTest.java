package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyThreeCheapestFreeTest {

    private Product p1,p2,p3,p4,p5,p6,p7;
    private ShoppingRule ruleBuyThreeCheapestFree;

    @Before
    public void before(){
        ruleBuyThreeCheapestFree = new RuleBuyThreeCheapestFree();

        p1 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();
        p2 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();
        p3 = Product.newProduct().name("Mango Juice 2L").price(5.5).build();
        p4 = Product.newProduct().name("Mango Juice 3L").price(7.5).build();
        p5 = Product.newProduct().name("Mango Juice 3L").price(7.5).build();
        p6 = Product.newProduct().name("Mango Juice 5L").price(9.5).build();
        p7 = Product.newProduct().name("Mango Juice 5L").price(9.5).build();

        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> p.setRule(ruleBuyThreeCheapestFree));
    }

    @Test
    public void when_CartWithThreeItems_Then_TheCheapestIsFree() {
        Cart cart = new Cart();
        Stream.of(p1,p2,p3).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreeCheapestFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertNotEquals(totalBefore, totalAfter);
        assertThat(totalAfter, is(new Double (9)));
    }


    @Test
    public void when_CartWithTwoItems_Then_TheThePriceDoesNotChange() {
        Cart cart = new Cart();
        Stream.of(p1,p2).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreeCheapestFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertEquals(totalBefore, totalAfter);
        assertThat(totalAfter, is(new Double (7)));
    }

    @Test
    public void when_CartWithSevenItems_Then_TheTwoCheapestAreFree() {
        Cart cart = new Cart();
        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreeCheapestFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertNotEquals(totalBefore, totalAfter);
        assertThat(totalAfter, is(new Double (39.5)));
    }
}

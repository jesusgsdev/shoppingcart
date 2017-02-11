package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyThreePayTwoTest {

    private ShoppingRule ruleBuyThreePayTwo;
    private Product p1 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();
    private Product p2 = Product.newProduct().name("Orange Juice 1L").price(5.5).build();


    @Before
    public void before(){
        ruleBuyThreePayTwo = new RuleBuyThreePayTwo();
        p1 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();
        p2 = Product.newProduct().name("Orange Juice 1L").price(5.5).build();
    }

    @Test
    public void when_CartWithThreeItems_Then_PayOnlyTwo() {
        Cart cart = new Cart();
        cart.addNProducts(p1, 3);

        cart.getProducts().stream().forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertNotEquals(totalBefore, totalAfter);
        assertThat(totalAfter, is(new Double (7)));
    }


    @Test
    public void when_CartWithTwoItems_Then_PayTwo() {
        Cart cart = new Cart();
        cart.addNProducts(p1, 2);

        cart.getProducts().stream().forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();


        assertEquals(totalBefore, totalAfter);
        assertThat(totalAfter, is(new Double (7)));
    }

    @Test
    public void when_CartWithFourItems_Then_PayOnlyThree() {
        Cart cart = new Cart();
        cart.addNProducts(p1, 4);

        cart.getProducts().stream().forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertNotEquals(totalBefore, totalAfter);
        assertThat(totalAfter, is(new Double (10.50)));
    }

    @Test
    public void when_CartWithSevenItemsDifferents_Then_PayOnlyFive() {
        Cart cart = new Cart();
        cart.addNProducts(p1, 3);
        cart.addNProducts(p2, 4);

        cart.getProducts().stream().forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertNotEquals(totalBefore, totalAfter);
        assertThat(totalAfter, is(new Double (23.50)));
    }


}

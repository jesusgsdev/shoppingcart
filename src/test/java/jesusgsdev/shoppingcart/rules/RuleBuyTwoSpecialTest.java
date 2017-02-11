package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyTwoSpecialTest {

    private final Double specialPrice = 2.0;
    private RuleBuyTwoSpecialPrice shoppingRule;

    @Before
    public void before(){
        shoppingRule = new RuleBuyTwoSpecialPrice(2.0);
    }

    @Test
    public void when_CartWithOneItems_Then_GetNoneAtDiscountedPrice() {
        Double productPrice = 3.5;

        Product p1 = Product.newProduct().name("Mango Juice 1L").price(productPrice).build();
        p1.setRule(shoppingRule);

        Cart cart = new Cart();
        cart.addProduct(p1);

        Double totalBefore = cart.getTotal();
        shoppingRule.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertEquals(totalBefore, totalAfter);
    }

    @Test
    public void when_CartWithTwoItems_Then_GetOneAtDiscountedPrice() {
        Integer amount = 2;
        Double productPrice = 3.5;
        Double shouldBeFinalPrice = getFinalPriceAfterDiscount(amount, specialPrice, productPrice);

        Product p1 = Product.newProduct().name("Mango Juice 1L").price(productPrice).build();

        Cart cart = new Cart();
        cart.addNProducts(p1, amount);
        cart.getProducts().stream().forEach(p -> p.setRule(shoppingRule));

        Double totalBefore = cart.getTotal();
        shoppingRule.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertNotEquals(totalBefore, totalAfter);
        assertEquals(totalAfter, shouldBeFinalPrice);
    }


    @Test
    public void when_CartWithFiveItems_Then_GetTwoAtDiscountedPrice() {
        Integer amount = 5;
        Double productPrice = 3.5;

        Double shouldBeFinalPrice = getFinalPriceAfterDiscount(amount, specialPrice, productPrice);

        Product p1 = Product.newProduct().name("Mango Juice 1L").price(productPrice).build();

        Cart cart = new Cart();
        cart.addNProducts(p1, amount);
        cart.getProducts().stream().forEach(p -> p.setRule(shoppingRule));

        Double totalBefore = cart.getTotal();
        shoppingRule.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertNotEquals(totalBefore, totalAfter);
        assertEquals(totalAfter, shouldBeFinalPrice);
    }

    private Double getFinalPriceAfterDiscount(Integer amount, Double specialPrice, Double productPrice) {
        return amount * productPrice - (amount/2) * (productPrice - specialPrice) *  1;
    }
}

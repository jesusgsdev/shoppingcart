package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleForEachNItemsXGetKItemsYFreeTest {

    @Test
    public void when_CartWithThreeItems_Then_GetsSixFree() {
        Product freeItem = Product.newProduct().name("Orange Juice 0.25L").price(0.0).build();
        ShoppingRule shoppingRule = new RuleForEachNItemsXGetKItemsYFree(1, freeItem, 2);

        Product p1 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();

        Cart cart = new Cart();
        cart.addNProducts(p1, 3);
        cart.getProducts().stream().forEach(p -> p.setRule(shoppingRule));

        Double totalBefore = cart.getTotal();
        shoppingRule.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertEquals(totalBefore, totalAfter);
        assertThat(cart.getProducts(), hasSize(9));
    }

    @Test
    public void when_CartWithFiveItems_Then_GetsTwoFree() {
        Product freeItem = Product.newProduct().name("Orange Juice 1L").price(10.0).build();
        ShoppingRule shoppingRule = new RuleForEachNItemsXGetKItemsYFree(2, freeItem, 1);

        Product p1 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();

        Cart cart = new Cart();
        cart.addNProducts(p1, 5);
        cart.getProducts().stream().forEach(p -> p.setRule(shoppingRule));

        Double totalBefore = cart.getTotal();
        shoppingRule.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assertEquals(totalBefore, totalAfter);
        assertThat(cart.getProducts(), hasSize(7));
    }

}

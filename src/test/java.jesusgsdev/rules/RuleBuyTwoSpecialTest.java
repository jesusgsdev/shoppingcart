package rules;

import org.junit.Test;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.rules.RuleBuyTwoSpecialPrice;

import java.util.stream.Stream;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyTwoSpecialTest {

    @Test
    public void cartWithOneItem() {
        RuleBuyTwoSpecialPrice ruleBuyTwoSpecialPrice = new RuleBuyTwoSpecialPrice(2.0);

        Product p1 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1).forEach(p -> p.setRule(ruleBuyTwoSpecialPrice));

        Cart cart = new Cart();
        Stream.of(p1).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyTwoSpecialPrice.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(totalBefore.equals(totalAfter));
    }

    @Test
    public void cartWithTwoItems() {
        RuleBuyTwoSpecialPrice ruleBuyTwoSpecialPrice = new RuleBuyTwoSpecialPrice(2.0);

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2).forEach(p -> p.setRule(ruleBuyTwoSpecialPrice));

        Cart cart = new Cart();
        Stream.of(p1,p2).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyTwoSpecialPrice.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(!totalBefore.equals(totalAfter));
        assert(totalAfter.equals(5.5));
    }


    @Test
    public void cartWithFiveItems() {
        RuleBuyTwoSpecialPrice ruleBuyTwoSpecialPrice = new RuleBuyTwoSpecialPrice(2.0);

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 1L", 3.5);
        Product p4 = new Product("Mango Juice 1L", 3.5);
        Product p5 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2,p3,p4,p5).forEach(p -> p.setRule(ruleBuyTwoSpecialPrice));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3,p4,p5).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyTwoSpecialPrice.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(!totalBefore.equals(totalAfter));
        assert(totalAfter.equals(14.5));
    }
}

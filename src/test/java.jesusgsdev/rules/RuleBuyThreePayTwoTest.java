package rules;

import org.junit.Test;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.rules.RuleBuyThreePayTwo;

import java.util.stream.Stream;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyThreePayTwoTest {

    @Test
    public void cartWithThreeItems() {
        RuleBuyThreePayTwo ruleBuyThreePayTwo = new RuleBuyThreePayTwo();

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2,p3).forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(!totalBefore.equals(totalAfter));
        assert(totalAfter.equals(7.0));
    }


    @Test
    public void cartWithTwoItems() {
        RuleBuyThreePayTwo ruleBuyThreePayTwo = new RuleBuyThreePayTwo();

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2).forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Cart cart = new Cart();
        Stream.of(p1,p2).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(totalBefore.equals(totalAfter));
        assert(totalAfter.equals(7.0));
    }

    @Test
    public void cartWithFourItems() {
        RuleBuyThreePayTwo ruleBuyThreePayTwo = new RuleBuyThreePayTwo();

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 1L", 3.5);
        Product p4 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2,p3,p4).forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3,p4).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(!totalBefore.equals(totalAfter));
        assert(totalAfter.equals(10.5));
    }

    @Test
    public void cartWithSevenDifferentItems() {
        RuleBuyThreePayTwo ruleBuyThreePayTwo = new RuleBuyThreePayTwo();

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 1L", 3.5);
        Product p4 = new Product("Orange Juice 1L", 5.5);
        Product p5 = new Product("Orange Juice 1L", 5.5);
        Product p6 = new Product("Orange Juice 1L", 5.5);
        Product p7 = new Product("Orange Juice 1L", 5.5);

        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> p.setRule(ruleBuyThreePayTwo));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreePayTwo.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(!totalBefore.equals(totalAfter));
        assert(totalAfter.equals(23.5));
    }
}

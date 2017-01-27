package rules;

import org.junit.Test;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.rules.RuleBuyThreeCheapestFree;

import java.util.stream.Stream;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyThreeCheapestFreeTest {

    @Test
    public void cartWithThreeItems() {
        RuleBuyThreeCheapestFree ruleBuyThreeCheapestFree = new RuleBuyThreeCheapestFree();

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 2L", 5.5);

        Stream.of(p1,p2,p3).forEach(p -> p.setRule(ruleBuyThreeCheapestFree));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreeCheapestFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(!totalBefore.equals(totalAfter));
        assert(totalAfter.equals(9.0));
    }


    @Test
    public void cartWithTwoItems() {
        RuleBuyThreeCheapestFree ruleBuyThreeCheapestFree = new RuleBuyThreeCheapestFree();

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2).forEach(p -> p.setRule(ruleBuyThreeCheapestFree));

        Cart cart = new Cart();
        Stream.of(p1,p2).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreeCheapestFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(totalBefore.equals(totalAfter));
        assert(totalAfter.equals(7.0));
    }

    @Test
    public void cartWithSevenItems() {
        RuleBuyThreeCheapestFree ruleBuyThreeCheapestFree = new RuleBuyThreeCheapestFree();

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 2L", 5.5);
        Product p4 = new Product("Mango Juice 3L", 7.5);
        Product p5 = new Product("Mango Juice 3L", 7.5);
        Product p6 = new Product("Mango Juice 5L", 9.5);
        Product p7 = new Product("Mango Juice 5L", 9.5);

        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> p.setRule(ruleBuyThreeCheapestFree));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleBuyThreeCheapestFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(!totalBefore.equals(totalAfter));
        assert(totalAfter.equals(39.5));
    }
}

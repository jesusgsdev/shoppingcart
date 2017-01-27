package rules;

import org.junit.Test;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.rules.RuleForEachNItemsXGetKItemsYFree;

import java.util.stream.Stream;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleForEachNItemsXGetKItemsYFreeTest {

    @Test
    public void cartWithThreeItems() {
        Product freeItem = new Product("Orange Juice 0.25L", 0.0);

        RuleForEachNItemsXGetKItemsYFree ruleForEachNItemsXGetKItemsYFree = new RuleForEachNItemsXGetKItemsYFree(1, freeItem, 2);

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2,p3).forEach(p -> p.setRule(ruleForEachNItemsXGetKItemsYFree));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleForEachNItemsXGetKItemsYFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(totalBefore.equals(totalAfter));
        assert(cart.getProducts().size() == 9);
    }

    @Test
    public void cartWithFiveItems() {
        Product freeItem = new Product("Orange Juice 1L", 10.0);

        RuleForEachNItemsXGetKItemsYFree ruleForEachNItemsXGetKItemsYFree = new RuleForEachNItemsXGetKItemsYFree(2, freeItem, 1);

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 1L", 3.5);
        Product p4 = new Product("Mango Juice 1L", 3.5);
        Product p5 = new Product("Mango Juice 1L", 3.5);

        Stream.of(p1,p2,p3,p4,p5).forEach(p -> p.setRule(ruleForEachNItemsXGetKItemsYFree));

        Cart cart = new Cart();
        Stream.of(p1,p2,p3,p4,p5).forEach(p -> cart.addProduct(p));

        Double totalBefore = cart.getTotal();
        ruleForEachNItemsXGetKItemsYFree.applyRule(cart);
        Double totalAfter = cart.getTotal();

        assert(totalBefore.equals(totalAfter));
        assert(cart.getProducts().size() == 7);
    }

}

package jesusgsdev.shoppingcart.helper;

import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.rules.RuleBuyThreeCheapestFree;
import jesusgsdev.shoppingcart.rules.RuleBuyThreePayTwo;
import jesusgsdev.shoppingcart.rules.RuleBuyTwoSpecialPrice;
import jesusgsdev.shoppingcart.rules.RuleForEachNItemsXGetKItemsYFree;

import java.util.stream.Stream;

/**
 * Created by jesgarsal on 24/01/17.
 */
public class CartHelper {

    public static void setProductsForRuleBuyThreeCheapestFree(RuleBuyThreeCheapestFree ruleBuyThreeCheapestFree, Cart cart){

        Product p1 = new Product("Mango Juice 1L", 3.5);
        Product p2 = new Product("Mango Juice 1L", 3.5);
        Product p3 = new Product("Mango Juice 2L", 5.5);

        Stream.of(p1,p2,p3).forEach(p -> p.setRule(ruleBuyThreeCheapestFree));

        Stream.of(p1,p2,p3).forEach(p -> cart.addProduct(p));
    }

    public static void setProductsForRuleBuyThreePayTwo(RuleBuyThreePayTwo ruleBuyThreePayTwo, Cart cart){

        Product p1 = new Product("Coke Zero 1L", 1.0);
        Product p2 = new Product("Coke Zero 1L", 1.0);
        Product p3 = new Product("Coke Zero 1L", 3.5);
        Product p4 = new Product("Coke 2L", 2.5);
        Product p5 = new Product("Coke 2L", 2.5);
        Product p6 = new Product("Coke 2L", 2.5);
        Product p7 = new Product("Coke 2L", 2.5);

        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> p.setRule(ruleBuyThreePayTwo));
        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> cart.addProduct(p));

    }

    public static void setProductsForRuleBuyTwoSpecialPrice(RuleBuyTwoSpecialPrice ruleBuyTwoSpecialPrice, Cart cart){

        Product p1 = new Product("London Pride 0.5L", 3.5);
        Product p2 = new Product("London Pride 0.5L", 3.5);
        Product p3 = new Product("London Pride 0.5L", 3.5);
        Product p4 = new Product("London Pride 0.5L", 3.5);
        Product p5 = new Product("London Pride 0.5L", 3.5);

        Stream.of(p1,p2,p3,p4,p5).forEach(p -> p.setRule(ruleBuyTwoSpecialPrice));
        Stream.of(p1,p2,p3,p4,p5).forEach(p -> cart.addProduct(p));

    }

    public static void setProductsForRuleForEachNItemsXGetKItemsYFree(RuleForEachNItemsXGetKItemsYFree ruleForEachNItemsXGetKItemsYFree, Cart cart){

        Product p1 = new Product("Champoo 1L", 3.5);
        Product p2 = new Product("Champoo 1L", 3.5);
        Product p3 = new Product("Champoo 1L", 3.5);
        Product p4 = new Product("Champoo 1L", 3.5);
        Product p5 = new Product("Champoo 1L", 3.5);

        Stream.of(p1,p2,p3,p4,p5).forEach(p -> p.setRule(ruleForEachNItemsXGetKItemsYFree));
        Stream.of(p1,p2,p3,p4,p5).forEach(p -> cart.addProduct(p));

    }

}

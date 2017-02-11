package jesusgsdev.shoppingcart.helper;

import jesusgsdev.shoppingcart.ShoppingRule;
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

    public static void setProductsForRuleBuyThreeCheapestFree(ShoppingRule ruleBuyThreeCheapestFree, Cart cart){
        Product p1 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();
        Product p2 = Product.newProduct().name("Mango Juice 1L").price(3.5).build();
        Product p3 = Product.newProduct().name("Mango Juice 2L").price(5.5).build();

        Stream.of(p1,p2,p3).forEach(p -> p.setRule(ruleBuyThreeCheapestFree));
        Stream.of(p1,p2,p3).forEach(p -> cart.addProduct(p));
    }

    public static void setProductsForRuleBuyThreePayTwo(ShoppingRule ruleBuyThreePayTwo, Cart cart){
        Product p1 = Product.newProduct().name("Coke Zero 1L").price(1.0).build();
        Product p2 = Product.newProduct().name("Coke Zero 1L").price(1.0).build();
        Product p3 = Product.newProduct().name("Coke Zero 1L").price(3.5).build();
        Product p4 = Product.newProduct().name("Coke Zero 2L").price(2.5).build();
        Product p5 = Product.newProduct().name("Coke Zero 2L").price(2.5).build();
        Product p6 = Product.newProduct().name("Coke Zero 2L").price(2.5).build();
        Product p7 = Product.newProduct().name("Coke Zero 2L").price(2.5).build();

        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> p.setRule(ruleBuyThreePayTwo));
        Stream.of(p1,p2,p3,p4,p5,p6,p7).forEach(p -> cart.addProduct(p));
    }

    public static void setProductsForRuleBuyTwoSpecialPrice(ShoppingRule ruleBuyTwoSpecialPrice, Cart cart){
        Product p1 = Product.newProduct().name("London Pride 0.5L").price(3.5).build();
        Product p2 = Product.newProduct().name("London Pride 0.5L").price(3.5).build();
        Product p3 = Product.newProduct().name("London Pride 0.5L").price(3.5).build();
        Product p4 = Product.newProduct().name("London Pride 0.5L").price(3.5).build();
        Product p5 = Product.newProduct().name("London Pride 0.5L").price(3.5).build();

        Stream.of(p1,p2,p3,p4,p5).forEach(p -> p.setRule(ruleBuyTwoSpecialPrice));
        Stream.of(p1,p2,p3,p4,p5).forEach(p -> cart.addProduct(p));
    }

    public static void setProductsForRuleForEachNItemsXGetKItemsYFree(ShoppingRule ruleForEachNItemsXGetKItemsYFree, Cart cart){
        Product p1 = Product.newProduct().name("Champoo 1L").price(3.5).build();
        Product p2 = Product.newProduct().name("Champoo 1L").price(3.5).build();
        Product p3 = Product.newProduct().name("Champoo 1L").price(3.5).build();
        Product p4 = Product.newProduct().name("Champoo 1L").price(3.5).build();
        Product p5 = Product.newProduct().name("Champoo 1L").price(3.5).build();

        Stream.of(p1,p2,p3,p4,p5).forEach(p -> p.setRule(ruleForEachNItemsXGetKItemsYFree));
        Stream.of(p1,p2,p3,p4,p5).forEach(p -> cart.addProduct(p));
    }

}

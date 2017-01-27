package jesusgsdev.shoppingcart;

import jesusgsdev.shoppingcart.helper.CartHelper;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.rules.RuleBuyThreeCheapestFree;
import jesusgsdev.shoppingcart.rules.RuleBuyThreePayTwo;
import jesusgsdev.shoppingcart.rules.RuleBuyTwoSpecialPrice;
import jesusgsdev.shoppingcart.rules.RuleForEachNItemsXGetKItemsYFree;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class Main {

    public static void main(String[] args){

        Product freeItem = new Product("Hand Washer", 0.0);

        RuleBuyThreeCheapestFree ruleBuyThreeCheapestFree = new RuleBuyThreeCheapestFree();
        RuleBuyThreePayTwo ruleBuyThreePayTwo = new RuleBuyThreePayTwo();
        RuleBuyTwoSpecialPrice ruleBuyTwoSpecialPrice = new RuleBuyTwoSpecialPrice(3.0);
        RuleForEachNItemsXGetKItemsYFree ruleForEachNItemsXGetKItemsYFree = new RuleForEachNItemsXGetKItemsYFree(2, freeItem, 1);

        Cart cart = new Cart();

        CartHelper.setProductsForRuleBuyThreeCheapestFree(ruleBuyThreeCheapestFree, cart);
        CartHelper.setProductsForRuleBuyThreePayTwo(ruleBuyThreePayTwo, cart);
        CartHelper.setProductsForRuleBuyTwoSpecialPrice(ruleBuyTwoSpecialPrice, cart);
        CartHelper.setProductsForRuleForEachNItemsXGetKItemsYFree(ruleForEachNItemsXGetKItemsYFree, cart);

        ruleBuyThreePayTwo.applyRule(cart);
        ruleBuyThreePayTwo.applyRule(cart);
        ruleBuyTwoSpecialPrice.applyRule(cart);
        ruleForEachNItemsXGetKItemsYFree.applyRule(cart);

        System.out.println(cart);
    }

}

package jesusgsdev.shoppingcart;

import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.helper.CartHelper;
import jesusgsdev.shoppingcart.rules.RuleBuyThreeCheapestFree;
import jesusgsdev.shoppingcart.rules.RuleBuyThreePayTwo;
import jesusgsdev.shoppingcart.rules.RuleBuyTwoSpecialPrice;
import jesusgsdev.shoppingcart.rules.RuleForEachNItemsXGetKItemsYFree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jesgarsal on 23/01/17.
 */
public class CheckOutTest {

    private Cart cart;

    private List<ShoppingRule> rules;

    @Before
    public void before(){
        cart = new Cart();

        Product freeItem = new Product("Hand Washer", 10.0);

        ShoppingRule ruleBuyThreeCheapestFree = new RuleBuyThreeCheapestFree();
        ShoppingRule ruleBuyThreePayTwo = new RuleBuyThreePayTwo();
        ShoppingRule ruleBuyTwoSpecialPrice = new RuleBuyTwoSpecialPrice(3.0);
        ShoppingRule ruleForEachNItemsXGetKItemsYFree = new RuleForEachNItemsXGetKItemsYFree(2, freeItem, 1);

        rules = Stream.of(ruleBuyThreeCheapestFree, ruleBuyThreePayTwo, ruleBuyTwoSpecialPrice, ruleForEachNItemsXGetKItemsYFree).collect(Collectors.toList());

        CartHelper.setProductsForRuleBuyThreeCheapestFree(ruleBuyThreeCheapestFree, cart);
        CartHelper.setProductsForRuleBuyThreePayTwo(ruleBuyThreePayTwo, cart);
        CartHelper.setProductsForRuleBuyTwoSpecialPrice(ruleBuyTwoSpecialPrice, cart);
        CartHelper.setProductsForRuleForEachNItemsXGetKItemsYFree(ruleForEachNItemsXGetKItemsYFree, cart);
    }

    @Test
    public void when_CheckoutIsExecuted(){

        for(ShoppingRule shoppingRule : rules){
            Double totalBefore = cart.getTotal();
            int elementsBefore = cart.getProducts().size();
            shoppingRule.applyRule(cart);

            if(shoppingRule instanceof RuleForEachNItemsXGetKItemsYFree){
                Assert.assertEquals(totalBefore, cart.getTotal());
            }else{
                assertNotEquals(totalBefore, cart.getTotal());
            }
            assertThat(elementsBefore, lessThan(cart.getProducts().size()));
            assertNotEquals(elementsBefore, cart.getProducts().size());
        }

        System.out.print(cart.toString());

    }



}

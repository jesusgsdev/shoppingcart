package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.entities.Cart;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleForEachNItemsXGetKItemsYFree implements ShoppingRule {

    private final String FREE_BY_BUY_N_ITEMS_X_GET_K_ITEMS_Y = " (Free by Buy N items X get K items Y)";
    private final Predicate<Product> isThisRule = p -> p.getRule().equals(this);

    private Integer n;
    private Product freeProduct;
    private Integer k;

    public RuleForEachNItemsXGetKItemsYFree(Integer n, Product freeProduct, Integer k) {
        this.n = n;
        this.freeProduct = freeProduct;
        this.k = k;
    }

    @Override
    public void applyRule(Cart cart) {
        List<Product> productList = cart.getProducts().stream().filter(RulesHelper.ruleIsNotNull.and(isThisRule)).collect(Collectors.toList());

        Integer numBaseProducts = productList.size() / n;
        Integer numBaseToAdd = numBaseProducts * k;

        freeProduct.setPrice(0.0);
        freeProduct.setName(freeProduct.getName() + FREE_BY_BUY_N_ITEMS_X_GET_K_ITEMS_Y);

        cart.addNProducts(freeProduct, numBaseToAdd);
    }

}

package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.entities.Cart;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleForEachNItemsXGetKItemsYFree implements ShoppingRule {

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

        List<Product> productList = cart.getProducts().stream().filter(p -> p.getRule()!= null && p.getRule().equals(this)).collect(Collectors.toList());

        Integer numBaseProducts = productList.size() / n;
        Integer numBaseToAdd = numBaseProducts * k;
        freeProduct.setPrice(0.0);
        freeProduct.setName(freeProduct.getName() + " (Free by Buy N items X get K items Y)");
        cart.addNProduct(freeProduct, numBaseToAdd);

    }

}

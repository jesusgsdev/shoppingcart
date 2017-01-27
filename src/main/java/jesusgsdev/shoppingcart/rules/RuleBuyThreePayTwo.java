package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Cart;
import jesusgsdev.shoppingcart.entities.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyThreePayTwo implements ShoppingRule {

    @Override
    public void applyRule(Cart cart) {

        Map<String, List<Product>> productList = cart.getProducts().stream().filter(p -> p.getRule()!= null && p.getRule().equals(this))
                .collect(Collectors.groupingBy(Product::getName));

        for(String name : productList.keySet()){
            List<Product> productsToApply = productList.get(name);

            Product pNegative = new Product(productsToApply.get(0));
            pNegative.setPrice(pNegative.getPrice() * -1.0);
            pNegative.setName(pNegative.getName() + " (Discount by Buy 3 Pay 2)");

            Integer numToProductsToAdd = productsToApply.size() / 3;
            cart.addNProduct(pNegative, numToProductsToAdd);
        }

    }
}

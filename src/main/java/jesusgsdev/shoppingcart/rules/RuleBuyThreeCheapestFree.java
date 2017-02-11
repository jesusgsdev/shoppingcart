package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.entities.Cart;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyThreeCheapestFree implements ShoppingRule {

    private final String DISCOUNT_BY_BUY_3_CHEAPEST_FREE = " (Discount by Buy 3 Cheapest Free)";
    private final Predicate<Product> isThisRule = p -> p.getRule().equals(this);

    @Override
    public void applyRule(Cart cart) {

        List<Product> productList = cart.getProducts()
                .stream()
                .filter(RulesHelper.ruleIsNotNull.and(isThisRule))
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());

        Integer numToProductsToAdd = productList.size() / 3;

        IntStream.range(0, numToProductsToAdd)
                .forEach(i -> cart.addProduct(
                        Product.newProduct()
                                .name(productList.get(i).getName() + DISCOUNT_BY_BUY_3_CHEAPEST_FREE)
                                .price(productList.get(i).getPrice() * -1.0)
                                .build()
                ));
    }
}

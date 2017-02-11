package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.entities.Cart;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyTwoSpecialPrice implements ShoppingRule {

    private final String DISCOUNT_BY_BUY_2_SPECIAL_PRICE = " (Discount by Buy 2 Special Price)";
    private final Predicate<Product> isThisRule = p -> p.getRule().equals(this);

    private Double specialPrice;

    public RuleBuyTwoSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    @Override
    public void applyRule(Cart cart) {

        Map<String, List<Product>> productList =  cart.getProducts()
                                                        .stream()
                                                        .filter(RulesHelper.ruleIsNotNull.and(isThisRule))
                                                        .collect(Collectors.groupingBy(Product::getName));

        for(String name : productList.keySet()){
            List<Product> productsToApply = productList.get(name);

            Product pNegative = new Product(productsToApply.get(0));
            Double newPrice = (pNegative.getPrice() - specialPrice ) * -1;
            pNegative.setPrice(newPrice);
            pNegative.setName(pNegative.getName() + DISCOUNT_BY_BUY_2_SPECIAL_PRICE);

            Integer numToProductsToAdd = productsToApply.size() / 2;
            cart.addNProducts(pNegative, numToProductsToAdd);
        }

    }
}

package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.entities.Cart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyTwoSpecialPrice implements ShoppingRule {

    private Double specialPrice;


    public RuleBuyTwoSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    @Override
    public void applyRule(Cart cart) {

        Map<String, List<Product>> productList = cart.getProducts().stream().filter(p -> p.getRule()!= null && p.getRule().equals(this))
                .collect(Collectors.groupingBy(Product::getName));

        for(String name : productList.keySet()){
            List<Product> productsToApply = productList.get(name);

            Product pNegative = new Product(productsToApply.get(0));
            Double newPrice = (pNegative.getPrice() - specialPrice ) * -1;
            pNegative.setPrice(newPrice);
            pNegative.setName(pNegative.getName() + " (Discount by Buy 2 Special Price)");

            Integer numToProductsToAdd = productsToApply.size() / 2;
            cart.addNProduct(pNegative, numToProductsToAdd);
        }

    }
}

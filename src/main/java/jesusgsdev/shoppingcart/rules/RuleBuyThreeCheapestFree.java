package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.ShoppingRule;
import jesusgsdev.shoppingcart.entities.Product;
import jesusgsdev.shoppingcart.entities.Cart;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by jesgarsal on 23/01/17.
 */
public class RuleBuyThreeCheapestFree implements ShoppingRule {

    @Override
    public void applyRule(Cart cart) {

        List<Product> productList = cart.getProducts().stream().filter(p -> p.getRule()!= null && p.getRule().equals(this)).sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
        Integer numToProductsToAdd = productList.size() / 3;

        IntStream.range(0, numToProductsToAdd)
                .forEach(i -> cart.addProduct(new Product(productList.get(i).getName() + " (Discount by Buy 3 Cheapest Free)", productList.get(i).getPrice() * -1.0)));
    }
}

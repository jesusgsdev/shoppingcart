package jesusgsdev.shoppingcart.rules;

import jesusgsdev.shoppingcart.entities.Product;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by jesgarsal on 11/02/17.
 */
public class RulesHelper {

    public final static Predicate<Product> ruleIsNotNull = p -> Objects.nonNull(p.getRule());

}

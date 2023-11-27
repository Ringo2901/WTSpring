package by.bsuir.aleksandrov.model.entity.phone.sorting;

import java.util.Arrays;

/**
 * @author nekit
 * @version 1.0
 */
public enum SortField {
    /**
     * Field of brand to sort
     */
    BRAND,
    /**
     * Field of model to sort
     */
    MODEL,
    /**
     * Field of display size to sort
     */
    DISPLAYSIZEINCHES,
    /**
     * Field of price to sort
     */
    PRICE;
    public static SortField getValue(String name) {
        return Arrays.stream(SortField.values())
                .filter(value -> value.name().equals(name))
                .findAny()
                .orElse(null);
    }
}

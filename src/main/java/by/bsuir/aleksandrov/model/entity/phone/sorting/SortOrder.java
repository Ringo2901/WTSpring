package by.bsuir.aleksandrov.model.entity.phone.sorting;

import java.util.Arrays;

public enum SortOrder {
    /**
     * Field of sorting order by ascending
     */
    ASC,
    /**
     * Field of sorting order by decreasing
     */
    DESC;

    public static SortOrder getValue(String name) {
        return Arrays.stream(SortOrder.values())
                .filter(value -> value.name().equals(name))
                .findAny()
                .orElse(null);
    }
}

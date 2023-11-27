package by.bsuir.aleksandrov.model.entity.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CartItem> items;
    private int cartId;
    private int totalItems;
    private BigDecimal totalCost = BigDecimal.valueOf(0);

}

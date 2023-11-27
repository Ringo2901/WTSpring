package by.bsuir.aleksandrov.model.entity.cart;



import by.bsuir.aleksandrov.model.entity.phone.Phone;

import java.io.Serializable;

public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private Phone phone;
    private int quantity;
}

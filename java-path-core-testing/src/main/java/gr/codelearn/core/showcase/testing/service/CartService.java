package gr.codelearn.core.showcase.testing.service;

import java.math.BigDecimal;
import java.util.List;

import gr.codelearn.core.showcase.testing.domain.Item;

public interface CartService {
	boolean addItem(Item item);
	boolean removeItem(Item item);
	List<Item> getCartItems();
	BigDecimal getTotalPrice();
	boolean checkout();
}

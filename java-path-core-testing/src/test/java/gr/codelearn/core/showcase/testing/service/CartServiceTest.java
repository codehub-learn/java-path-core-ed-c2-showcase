package gr.codelearn.core.showcase.testing.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import gr.codelearn.core.showcase.testing.domain.Item;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
	private CartServiceImpl cartService;
	@Mock
	private PaymentService mockedPaymentService;
	
	@BeforeEach
	void initialize() {
		cartService = new CartServiceImpl(mockedPaymentService);
		cartService.addItem(new Item("CPU",BigDecimal.valueOf(400),1));
		cartService.addItem(new Item("RAM",BigDecimal.valueOf(120),2));
	}
	
	@Test
	@DisplayName("Add correct item in cart")
	void addItem() {
		boolean result = cartService.addItem(new Item("SSD", BigDecimal.valueOf(90), 2));
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Add incorrect item in cart")
	void addItemError() {
		boolean result = cartService.addItem(new Item("SSD", BigDecimal.valueOf(90), -2));
		assertFalse(result);
	}
	
	@Test
	@DisplayName("Remove item from cart")
	void removeItem() {
		boolean result = cartService.removeItem(new Item("CPU",BigDecimal.valueOf(400),1));
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Gat all cartItems")
	void getCartItems() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("CPU",BigDecimal.valueOf(400),1));
		items.add(new Item("RAM",BigDecimal.valueOf(120),2));
		assertIterableEquals(items, cartService.getCartItems());
	}
	
	@Test
	@DisplayName("Calculate total cart price")
	void getTotalPrice() {
		assertEquals(BigDecimal.valueOf(640),cartService.getTotalPrice());
	}
	
	@Test
	@DisplayName("Checkout successfully")
	void checkout() {
		when(mockedPaymentService.getBalance()).thenReturn(BigDecimal.valueOf(650));
		boolean isCompleted = cartService.checkout();
		int numOfCartItems = cartService.getCartItems().size();
		assertAll(
				()-> assertTrue(isCompleted, "Checkout is NOT completed successfully"),
				()-> assertEquals(0,numOfCartItems,"Cart is NOT empty")
		);
		verify(mockedPaymentService).withdraw(BigDecimal.valueOf(640));
	}
	
	@Test
	@DisplayName("Checkout unsuccessfull due to insufficient balance")
	void checkoutError() {
		when(mockedPaymentService.getBalance()).thenReturn(BigDecimal.valueOf(110));
		boolean isCompleted = cartService.checkout();
		int numOfCartItems = cartService.getCartItems().size();
		assertAll(
				()-> assertFalse(isCompleted, "Checkout is completed successfully"),
				()-> assertEquals(2,numOfCartItems,"Cart is empty")
		);
		verify(mockedPaymentService, never()).withdraw(BigDecimal.valueOf(640));
	}
}

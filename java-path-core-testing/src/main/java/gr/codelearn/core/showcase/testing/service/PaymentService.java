package gr.codelearn.core.showcase.testing.service;

import java.math.BigDecimal;

public interface PaymentService {
	BigDecimal getBalance();
	boolean withdraw(BigDecimal ammount);
}

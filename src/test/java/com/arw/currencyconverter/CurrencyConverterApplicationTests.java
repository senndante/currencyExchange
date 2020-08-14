package com.arw.currencyconverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.arw.currencyconverter.controllers.AccountController;
import com.arw.currencyconverter.controllers.ConversionController;
import com.arw.currencyconverter.controllers.HistoryController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CurrencyConverterApplicationTests {

	@Autowired
	private AccountController accountController;

	@Autowired
	private ConversionController conversionController;

	@Autowired
	private HistoryController historyController;

	@Test
	void contextLoads() {
		assertThat(accountController).isNotNull();
		assertThat(conversionController).isNotNull();
		assertThat(historyController).isNotNull();
	}

}

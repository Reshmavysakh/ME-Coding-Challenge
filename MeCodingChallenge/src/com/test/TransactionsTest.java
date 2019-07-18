package com.test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.transactions.TransactionEntity;
import com.transactions.Transactions;

public class TransactionsTest {
	
	@Test
	public void TestCalculateBalance()
	{
		Transactions test_transactions= new Transactions();
		List<TransactionEntity> records_list = new ArrayList<TransactionEntity>();
		records_list=test_transactions.doReadCSVasList();
		double test_balance = test_transactions.calculateBalance("ACC334455", test_transactions.parseToDate("20/10/2018 12:00:00"), test_transactions.parseToDate("20/10/2018 19:00:00"), records_list);
		assertEquals(-35.50, test_balance);
		assertEquals(2, Transactions.count);
		
	}
}

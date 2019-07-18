package com.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.opencsv.CSVReader;

public class Transactions {
	public static int count=0;
	public static double balance = 0.0;
	
	/* This method converts an input string date value into LocalDate */
	public LocalDateTime parseToDate(String string_date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
		LocalDateTime localDatetime = LocalDateTime.parse(string_date, formatter);

		return localDatetime;
	}
	

	/* 
	 * This method Reads the input csv file and get a list of records 
	 */
	public List<TransactionEntity> doReadCSVasList()
	{
		String csvFileName = "src/transactions_data.csv";
		String[] record;
		List<TransactionEntity> list = new ArrayList<TransactionEntity>();
		try {
		Reader reader = Files.newBufferedReader(Paths.get(csvFileName));
		CSVReader csvReader = new CSVReader(reader);
		while ((record = csvReader.readNext()) != null) {
			TransactionEntity entity = new TransactionEntity();
			entity.setTransaction_ID(record[0].trim());
			entity.setFrom_AccountID(record[1].trim());
			entity.setTo_AccountID(record[2].trim());
			entity.setCreatedAt(parseToDate(record[3].trim()));
			entity.setAmount(Double.parseDouble(record[4].trim()));
			entity.setTransaction_Type(record[5].trim());
			list.add(entity);
		}
		csvReader.close();
		
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	/* this method calculates the relative balance and the number of transactions 
	 * using the given inputs and  a list of records from the csv file */
	public double calculateBalance(String Acc_Id, LocalDateTime from, LocalDateTime to, List<TransactionEntity> list) {
		
//		double balance = 0.0;
//		int count=0;
		for (TransactionEntity entity : list) {
			if (((entity.getCreatedAt().isAfter(from))|(entity.getCreatedAt().isEqual(from)) )
					&&((entity.getCreatedAt().isBefore(to))|(entity.getCreatedAt().isEqual(to))))
			{
				if (entity.getTransaction_Type().equals("PAYMENT")) {
					if (entity.getFrom_AccountID().equals(Acc_Id)) {
						count += 1;
						balance -= entity.getAmount();

					} else if (entity.getTo_AccountID().equals(Acc_Id)) {
						System.out.println(entity.getAmount());
						count += 1;
						balance += entity.getAmount();
					}

				}
				else
				{
				count+=1;
				}
			}
		}
		
		return balance;
	}

	public static void main(String[] args) {
		Transactions transactions = new Transactions();
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		LocalDateTime input_fromDateTime;
		LocalDateTime input_toDateTime;
		
		try {
			System.out.println("Enter Account ID:");
			String input_AccountId = br.readLine();
			System.out.println("Enter From Date and Time:");
			String input_fromDateTime_string = br.readLine();
			System.out.println("Enter To date and Time:");
			String input_toDateTime_string = br.readLine();
			/*
			 * passing string input datetime values to parseToDate() for converting into
			 * LocalDateTime format
			 */
			input_fromDateTime = transactions.parseToDate(input_fromDateTime_string);
			input_toDateTime = transactions.parseToDate(input_toDateTime_string);
			

			List<TransactionEntity> recordlist = new ArrayList<TransactionEntity>();
			recordlist=transactions.doReadCSVasList();
			double balance =transactions.calculateBalance(input_AccountId, input_fromDateTime, input_toDateTime, recordlist);
			
			
			
			NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
	        String relative_balance = format.format(balance);
			System.out.println("Relative balance for the given period is : " + relative_balance);
			System.out.println("Number of transactions included : " + count);

		} catch (IOException | DateTimeException e) {
			e.printStackTrace();
		}

	}

}

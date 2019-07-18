package com.transactions;

import java.time.LocalDateTime;

public class TransactionEntity {
	private String transaction_ID;
	private String from_AccountID;
	private String to_AccountID;
	private LocalDateTime createdAt;
	private double amount;
	private String transaction_Type;
	private String relatedTransaction;
	
	
	
	public TransactionEntity() {

	}
	
	public TransactionEntity(String transaction_ID, String from_AccountID, String to_AccountID, LocalDateTime createdAt,
			double amount, String transaction_Type, String relatedTransaction) {
		super();
		this.transaction_ID = transaction_ID;
		this.from_AccountID = from_AccountID;
		this.to_AccountID = to_AccountID;
		this.createdAt = createdAt;
		this.amount = amount;
		this.transaction_Type = transaction_Type;
		this.relatedTransaction = relatedTransaction;
	}
	public String getTransaction_ID() {
		return transaction_ID;
	}
	public void setTransaction_ID(String transaction_ID) {
		this.transaction_ID = transaction_ID;
	}
	public String getFrom_AccountID() {
		return from_AccountID;
	}
	public void setFrom_AccountID(String from_AccountID) {
		this.from_AccountID = from_AccountID;
	}
	public String getTo_AccountID() {
		return to_AccountID;
	}
	public void setTo_AccountID(String to_AccountID) {
		this.to_AccountID = to_AccountID;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransaction_Type() {
		return transaction_Type;
	}
	public void setTransaction_Type(String transaction_Type) {
		this.transaction_Type = transaction_Type;
	}
	public String getRelatedTransaction() {
		return relatedTransaction;
	}
	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
	@Override
	public String toString() {
		return "TransactionEntity [transaction_ID=" + transaction_ID + ", from_AccountID=" + from_AccountID
				+ ", to_AccountID=" + to_AccountID + ", createdAt=" + createdAt + ", amount=" + amount
				+ ", transaction_Type=" + transaction_Type + ", relatedTransaction=" + relatedTransaction + "]";
	}
	
	
	

}

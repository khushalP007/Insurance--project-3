package com.example.insurence.billing.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class PaymentDetailsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private String paymentMethod;

	@Override
	public String toString() {
		return "PaymentDetailsModel [id=" + id + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", bill="
				+ bill + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BillModel getBill() {
		return bill;
	}

	public void setBill(BillModel bill) {
		this.bill = bill;
	}

	@ManyToOne
	@JoinColumn(name = "bill_id")
	private BillModel bill;
}

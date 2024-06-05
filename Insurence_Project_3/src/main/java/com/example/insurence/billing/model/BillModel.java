package com.example.insurence.billing.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BillModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String customerName;
	private Double amount;
	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
	private List<PaymentDetailsModel> payments;

	@Override
	public String toString() {
		return "BillModel [bill_id=" + id + ", customerName=" + customerName + ", amount=" + amount + ", payments="
				+ payments + "]";
	}

	public int getBill_id() {
		return id;
	}

	public void setBill_id(int bill_id) {
		this.id = bill_id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public List<PaymentDetailsModel> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDetailsModel> payments) {
		this.payments = payments;
	}

	

	
}

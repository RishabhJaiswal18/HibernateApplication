package com.customer.order.review.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_order_review")
public class CustomerModel implements Serializable {

	@Id
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_address")
	private String customerAddress;

	@Column(name = "customer_order_product")
	private String customerProductOrder;

	@Column(name = "customer_contact")
	private String customerContact;

	@Column(name = "customer_rating")
	private String customerRating;

	@Column(name = "brand")
	private String brand;

	@Column(name = "product_price")
	private float productPrice;

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerProductOrder() {
		return customerProductOrder;
	}

	public void setCustomerProductOrder(String customerProductOrder) {
		this.customerProductOrder = customerProductOrder;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(String customerRating) {
		this.customerRating = customerRating;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "CustomerModel [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerProductOrder=" + customerProductOrder + ", customerContact="
				+ customerContact + ", customerRating=" + customerRating + ", brand=" + brand + ", productPrice="
				+ productPrice + "]";
	}
}

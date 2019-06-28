package com.kaushik.Megamart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Products {

	@Id
	private String id;
	private String name;
	private String description;
	private double price;
	private double discount;
	private double deliverycharge;
	private int avgrating;
	private String sellername;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getDeliverycharge() {
		return deliverycharge;
	}
	public void setDeliverycharge(double deliverycharge) {
		this.deliverycharge = deliverycharge;
	}
	public int getAvgrating() {
		return avgrating;
	}
	public void setAvgrating(int avgrating) {
		this.avgrating = avgrating;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
}

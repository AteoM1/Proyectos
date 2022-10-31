package org.funlam.migorista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
	
	@Column
    private Long idUser;
	@Column
    private String name;
	@Column
    private String category;
	@Column
    private String description;
	@Column
    private String img;
	@Column
	private Double price;
	@Column
    private String status;
	@Column
    private String contact;
	
	public Product() {
	}

	public Product(Long idProduct, Long idUser, String name, String category, String description,
			String img, Double price, String status, String contact) {
		super();
		this.idProduct = idProduct;
		this.idUser = idUser;
		this.name = name;
		this.category = category;
		this.description = description;
		this.img = img;
		this.price = price;
		this.status = status;
		this.contact = contact;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}

package org.funlam.migorista.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//DEFINITION
	@Column
	private String name;
	@Column
	private String content;
	@Column
	private String category;
	@Column
	private String img;
	@Column
	private int level;
	@Column
	private int status;
	
	
	//CONSTRUCTOR
	
	public Item(Long id, String name, String content, String category, String img, int level, int status) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.category = category;
		this.img = img;
		this.level = level;
		this.status = status;
	}
	
	//GETTERS & SETTERS

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
}
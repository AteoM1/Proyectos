package org.funlam.migorista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPost;
	
	@Column
    private Long idUser;
	@Column
	private String name;
	@Column
	private String content;
	@Column
	private String contact;
	@Column
	private String category;
	@Column
	private String img;
	@Column
	private String date;
	@Column
	private int status;
	public Post() {
		
	}
	public Post(Long idPost, Long idUser, String name, String content, String contact, String category, String img,
			String date, int status) {
		super();
		this.idPost = idPost;
		this.idUser = idUser;
		this.name = name;
		this.content = content;
		this.contact = contact;
		this.category = category;
		this.img = img;
		this.date = date;
		this.status = status;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}

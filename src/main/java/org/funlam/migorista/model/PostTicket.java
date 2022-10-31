package org.funlam.migorista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PostTickets")
public class PostTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostTicket;
	
	@Column
	private String category;
	@Column
    private Long idUser;
	@Column
    private Long idUserT;
	@Column
    private Long idPost;
	
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String subject;
	@Column
	private String content;
	@Column
	private String date;
	@Column
	private int status;
	
	public PostTicket() {
		
	}

	public PostTicket(Long idPostTicket, String category, Long idUser, Long idUserT, Long idPost, String name,
			String phone, String email, String subject, String content, String date, int status) {
		super();
		this.idPostTicket = idPostTicket;
		this.category = category;
		this.idUser = idUser;
		this.idUserT = idUserT;
		this.idPost = idPost;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.status = status;
	}

	public Long getIdPostTicket() {
		return idPostTicket;
	}

	public void setIdPostTicket(Long idPostTicket) {
		this.idPostTicket = idPostTicket;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdUserT() {
		return idUserT;
	}

	public void setIdUserT(Long idUserT) {
		this.idUserT = idUserT;
	}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
}

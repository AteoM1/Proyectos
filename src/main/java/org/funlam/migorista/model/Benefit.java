package org.funlam.migorista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benefits")
public class Benefit{
	
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
}

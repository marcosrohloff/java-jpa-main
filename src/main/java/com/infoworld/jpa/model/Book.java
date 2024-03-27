package com.infoworld.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOK")
@NamedQueries({ @NamedQuery(name = "Book.findByName", query = "SELECT b FROM Book b WHERE b.name = :name"),
		@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b") })
public class Book {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private Author author;

	public Book() {
	}

	public Book(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Book(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", name='" + name + '\'' + ", author=" + author.getName() + '}';
	}
}

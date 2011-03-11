/**
 * 
 */
package com.cookbook.domain;

import java.io.Serializable;

import javax.persistence.Id;

import org.hibernate.annotations.Entity;

/**
 * Recipe is the domain object to hold recipe contents and annotated with
 * Hibernate Entity class
 * 
 * @author lokesh
 */
@Entity
public class Recipe implements Serializable {

	/*
	 * Additional Costructor with the fields
	 */
	public Recipe(long id, String title, String contents, String author) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.author = author;
	}

	/**
	 * Empty Costructor necessary for JPA 2.0
	 */
	public Recipe() {
		super();
	}

	private static final long serialVersionUID = -8333501449975018182L;

	@Id
	private long id;

	private String title;

	private String contents;

	private String author;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents
	 *            the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", contents="
				+ contents + ", author=" + author + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}

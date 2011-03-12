/**
 * 
 */
package com.cookbook.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Recipe is the domain object to hold recipe contents and annotated with
 * Hibernate Entity class
 * 
 * @author lokesh
 */
@Entity
public class Recipe implements DomainObject, Serializable {

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

	@Version
	private int version;

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

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", contents="
				+ contents + ", author=" + author + "]".trim();
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode() Hashcode generated is a unique number
	 * for each ID. Example if the ID is 10 the has code would be 9+32 according
	 * to the logic in the method
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

		boolean flag = false;

		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (obj instanceof Recipe) {
			Recipe other = (Recipe) obj;
			if (id == other.id) {
				flag = true;
			}
		}
		return flag;
	}

}

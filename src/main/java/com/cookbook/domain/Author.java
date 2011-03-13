/**
 * 
 */
package com.cookbook.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author lokesh
 * 
 */
public class Author implements DomainObject, Serializable {

	private static final long serialVersionUID = -7310625405953952315L;

	public Author() {
		super();
	}

	public Author(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	private long id;
	private String name;

	@ManyToOne
	private Recipe recipe;

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
	 * @return the Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the lastName to set
	 */
	public void setName(String name) {
		this.name = name.trim();
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe
	 *            the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
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

		boolean flag = false;

		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (obj instanceof Author) {
			Author other = (Author) obj;
			if (id == other.id) {
				flag = true;
			}
		}

		return flag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", recipe=" + recipe
				+ "]";
	}

}

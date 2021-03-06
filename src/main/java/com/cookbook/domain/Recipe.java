/**
 * 
 */
package com.cookbook.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

/**
 * Recipe is the domain object to hold recipe contents and annotated with
 * Hibernate Entity class
 * 
 * @author lokesh
 */
@Entity
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Recipe implements DomainObject, Serializable {

	private static final long serialVersionUID = -8333501449975018182L;

	/*
	 * Additional Costructor with the fields
	 */
	public Recipe(long id, String title, String contents) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
	}

	/**
	 * Empty Costructor necessary for JPA 2.0
	 */
	public Recipe() {
		super();
	}

	@TableGenerator(name = "recipeGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "RECIPE_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "recipeGen")
	private long id;

	private String title;

	private String contents;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private List<Author> authors;

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
	public List<Author> getAuthors() {
		if (authors == null)
			authors = new ArrayList<Author>();
		return authors;
	}

	public boolean addAuthorToRecipe(Author author) {
		boolean flag = false;
		if (author != null) {
			author.setRecipe(this);
			if (authors != null) {
				flag = this.authors.add(author);
			} else {
				authors = new ArrayList<Author>();
				flag = this.authors.add(author);
			}
		}
		return flag;
	}

	/*
	 * 
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

		if (obj instanceof Recipe) {
			Recipe other = (Recipe) obj;
			if (id == other.id) {
				flag = true;
			}
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", contents="
				+ contents + ", authors=" + authors + ", version=" + version
				+ "]";
	}

}

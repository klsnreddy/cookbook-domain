/**
 * 
 */
package com.akkineni.domain;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.cookbook.domain.Author;
import com.cookbook.domain.Recipe;

/**
 * @author lokesh
 * 
 */
public class AuthorTest {

	@Test
	public void testEqualMethod() {

		/*
		 * Testing Equal Hashcode scenario
		 */
		Author author = new Author(1, "Vijay Akkineni");
		Author author1 = new Author(1, "Akhila Kambhampati");
		Assert.assertEquals(true, author.equals(author1));

		/*
		 * Testing Null scenario
		 */
		Assert.assertEquals(false, author.equals(null));

		/*
		 * Testing with Object and Class of different Type
		 */

		Assert.assertEquals(false, author.equals(new Object()));
		Assert.assertEquals(false, author.equals(new ArrayList<Object>()));

		/*
		 * Testing for equal ID's with different hashcodes
		 */
		author = new Author(101, "Vijay Akkineni");
		Object obj = new Author(102, "Akhila Kambhampati");
		Assert.assertEquals(false, author.equals(obj));

		/**
		 * Test for same memory address equality
		 */
		Assert.assertEquals(true, author.equals(author));

		/*
		 * Testing for equal ID's
		 */
		author.setId(10001);
		author1.setId(10001);
		boolean flag = author.equals(author1);
		Assert.assertEquals(true, flag);

	}

	@Test
	public void testGettersAndSetters() {
		Author author = new Author();
		author.setId(1);
		author.setName("Vijay Akkineni");
		Recipe recipe = new Recipe(1, "My Recipe", "This is the contents");
		author.setRecipe(recipe);

		Assert.assertEquals(1, author.getId());
		Assert.assertEquals("Vijay Akkineni", author.getName());
		Assert.assertEquals(recipe, author.getRecipe());

	}

	@Test
	public void testConstructors() {
		Author author = new Author();
		Assert.assertNotNull(author);
		Author author1 = new Author(101, "Vijay Akkineni");
		Assert.assertNotNull(author1);
		Assert.assertEquals(101, author1.getId());
		Assert.assertEquals("Author [id=0, name=null, recipe=null]",
				author.toString());
	}

	@Test
	public void testHashCode() {
		Author author1 = new Author(1, "Vijay Akkineni");
		Assert.assertEquals(32, author1.hashCode());
		Author author2 = new Author(100, "Vijay Akkineni");
		Assert.assertEquals(131, author2.hashCode());
	}

	// @Test
	// public void testAddAuthors() {
	// Assert.assertEquals(0, recipe.getAuthors().size());
	// Author author1 = new Author(1, "Vijay Akkineni");
	// Author author2 = new Author(2, "Akhila Kambhampati");
	// recipe = new Recipe(1, "My Recipe", "This is the contents");
	// recipe.addAuthorToRecipe(author1);
	// recipe.addAuthorToRecipe(author2);
	// int testSize = recipe.getAuthors().size();
	// Assert.assertEquals(2, testSize);
	// }
}

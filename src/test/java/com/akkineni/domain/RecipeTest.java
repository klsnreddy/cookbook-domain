package com.akkineni.domain;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cookbook.domain.Author;
import com.cookbook.domain.Recipe;

public class RecipeTest {

	private static Recipe recipe;

	@BeforeClass
	public static void initialize() {
		recipe = new Recipe();
	}

	@Test
	public void testEqualMethod() {

		/*
		 * Testing Equal Hashcode scenario
		 */
		Recipe recipe2 = new Recipe(10, "My Recipe", "This is the contents");
		Recipe recipe3 = new Recipe(10, "My Recipe", "This is the contents");
		Assert.assertEquals(true, recipe2.equals(recipe3));

		/*
		 * Testing Null scenario
		 */
		Assert.assertEquals(false, recipe3.equals(null));

		/*
		 * Testing with Object and Class os different Type
		 */

		Assert.assertEquals(false, recipe3.equals(new Object()));
		Assert.assertEquals(false, recipe3.equals(new ArrayList<Object>()));

		/*
		 * Testing for equal ID's with different hashcodes
		 */
		recipe2 = new Recipe(101, "My Recipe", "This is the contents");
		Object obj = new Recipe(102, "My Recipe", "This is the contents");
		Assert.assertEquals(false, recipe2.equals(obj));

		/**
		 * Test for same memory address equality
		 */
		Assert.assertEquals(true, recipe2.equals(recipe2));

		/*
		 * Testing for equal ID's
		 */
		recipe2 = new Recipe(101, "My Recipe", "This is the contents");
		Object obj2 = new Recipe(101, "My Recipe", "This is the contents");
		boolean flag = recipe2.equals(obj2);
		Assert.assertEquals(true, flag);

	}

	@Test
	public void testGettersAndSetters() {
		recipe.setId(1);
		recipe.setContents("This is test content");
		recipe.setTitle("My Test Recipe");

		Assert.assertEquals(1, recipe.getId());
		Assert.assertEquals("This is test content", recipe.getContents());
		Assert.assertEquals("My Test Recipe", recipe.getTitle());

	}

	@Test
	public void testConstructors() {
		recipe = new Recipe();
		Assert.assertNotNull(recipe);
		recipe = new Recipe(1, "My Recipe", "This is the contents");
		Assert.assertNotNull(recipe);
		Assert.assertEquals(1, recipe.getId());
		Assert.assertEquals("This is the contents", recipe.getContents());
		Assert.assertEquals("My Recipe", recipe.getTitle());

		Assert.assertEquals(
				"Recipe [id=1, title=My Recipe, contents=This is the contents, authors=null, version=0]",
				recipe.toString());
	}

	@Test
	public void testHashCode() {
		recipe = new Recipe(1, "My Recipe", "This is the contents");
		Assert.assertEquals(32, recipe.hashCode());
		recipe = new Recipe(100, "My Recipe", "This is the contents");
		Assert.assertEquals(131, recipe.hashCode());
	}

	@Test
	public void testAddAuthors() {
		Assert.assertEquals(0, recipe.getAuthors().size());
		Author author1 = new Author(1, "Vijay Akkineni");
		Author author2 = new Author(2, "Akhila Kambhampati");
		recipe = new Recipe(1, "My Recipe", "This is the contents");
		recipe.addAuthorToRecipe(author1);
		recipe.addAuthorToRecipe(author2);
		int testSize = recipe.getAuthors().size();
		Assert.assertEquals(2, testSize);
	}

}

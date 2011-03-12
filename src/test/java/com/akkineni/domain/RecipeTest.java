package com.akkineni.domain;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

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
		Recipe recipe2 = new Recipe(10, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Recipe recipe3 = new Recipe(10, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Assert.assertEquals(true, recipe2.equals(recipe3));
		/*
		 * Testing Null scenario
		 */
		Assert.assertEquals(false, recipe3.equals(null));

		/*
		 * TEsting with Object and Class os different Type
		 */

		Assert.assertEquals(false, recipe3.equals(new Object()));
		Assert.assertEquals(false, recipe3.equals(new ArrayList<Object>()));

		/*
		 * Testing for equal ID's with different hashcodes
		 */
		recipe2 = new Recipe(101, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Object obj = new Recipe(102, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Assert.assertEquals(false, recipe2.equals(obj));

		/**
		 * Test for same meory address equality
		 */
		Assert.assertEquals(true, recipe2.equals(recipe2));

		/*
		 * Testing for equal ID's
		 */
		recipe2 = new Recipe(101, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Object obj2 = new Recipe(101, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		boolean flag = recipe2.equals(obj2);
		Assert.assertEquals(true, flag);

	}

	@Test
	public void testGettersAndSetters() {
		recipe.setId(1);
		recipe.setContents("This is test content");
		recipe.setAuthor("VIjay Akkineni");
		recipe.setTitle("My Test Recipe");
		recipe.setVersion(0);

		Assert.assertEquals(1, recipe.getId());
		Assert.assertEquals("This is test content", recipe.getContents());
		Assert.assertEquals("VIjay Akkineni", recipe.getAuthor());
		Assert.assertEquals("My Test Recipe", recipe.getTitle());
		Assert.assertEquals(0, recipe.getVersion());

	}

	@Test
	public void testConstructors() {
		recipe = new Recipe();
		Assert.assertNotNull(recipe);
		recipe = new Recipe(1, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Assert.assertNotNull(recipe);
		Assert.assertEquals(1, recipe.getId());
		Assert.assertEquals("This is the contents", recipe.getContents());
		Assert.assertEquals("Vijay Akkineni", recipe.getAuthor());
		Assert.assertEquals("My Recipe", recipe.getTitle());

		Assert.assertEquals(
				"Recipe [id=1, title=My Recipe, contents=This is the contents, author=Vijay Akkineni]",
				recipe.toString());
	}

	@Test
	public void testHashCode() {
		recipe = new Recipe(1, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Assert.assertEquals(32, recipe.hashCode());
		recipe = new Recipe(100, "My Recipe", "This is the contents",
				"Vijay Akkineni");
		Assert.assertEquals(131, recipe.hashCode());
	}

}

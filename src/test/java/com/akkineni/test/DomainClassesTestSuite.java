package com.akkineni.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.akkineni.domain.AuthorTest;
import com.akkineni.domain.RecipeTest;

@RunWith(value = Suite.class)
@SuiteClasses(value = { RecipeTest.class, AuthorTest.class })
public class DomainClassesTestSuite {

}

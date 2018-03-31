package com.example.demo;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	public static String  staticName  = null;
	public String memberName = null;

	@BeforeClass
	public static void initializeClass() {
		staticName  = "Rod Johnson";
	}

	@Before
	public void initializeTest() {
		memberName = "Gavin King";
	}

	@Test
	public void simpleEqualsAssertion() {
		Assert. assertEquals ("Rod Johnson",  staticName );
	}

	@Test
	public void simpleBooleanAssertion() {
		Assert. assertFalse ( staticName .equals(memberName));
	}

	@Test
	@Ignore
	public void dontTestThis() {
		// notice that this would fail without @Ignore
		Assert. assertEquals ("Rod", memberName);
	}



}

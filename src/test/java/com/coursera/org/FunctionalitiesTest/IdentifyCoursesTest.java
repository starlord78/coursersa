package com.coursera.org.FunctionalitiesTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.Base.Base;
import com.coursera.org.Functions.IdentifyCourses;

public class IdentifyCoursesTest {

	Base base = new Base();
	IdentifyCourses course = new IdentifyCourses();

	@Test
	public void testIdentifyCouerses() {

		try {
			course.searchCourse();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

		base.quitBrowser();

	}

}

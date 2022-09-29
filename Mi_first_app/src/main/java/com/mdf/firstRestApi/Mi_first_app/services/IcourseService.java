package com.mdf.firstRestApi.Mi_first_app.services;

import java.util.List;

import com.mdf.firstRestApi.Mi_first_app.models.Course;

public interface IcourseService {
	
	Course saveCourse(Course course);
	Course getCourse(String name);
	List<Course>getAllCourses(int from, int limit);
	Course updateCourse(Course course);
	Course deleteCourse(long id);

}

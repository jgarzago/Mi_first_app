package com.mdf.firstRestApi.Mi_first_app.services.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.mdf.firstRestApi.Mi_first_app.exception.CourseApiException;
import com.mdf.firstRestApi.Mi_first_app.models.Course;
import com.mdf.firstRestApi.Mi_first_app.services.IcourseService;

@Component
public class CourseServiceImpl implements IcourseService {
	
	
	private List<Course> courseList = new ArrayList<>();

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub

		if(courseList.isEmpty()) {
			course.setId(1);
		}else {	
			course.setId(courseList.get(courseList.size() -1 ).getId() + 1);
		}
		if(courseList.stream()
				.filter(_course -> _course.getName().equals(course.getName()))
				.findFirst()
				.isPresent()) {
			throw new CourseApiException(HttpStatus.BAD_REQUEST, "Course Name already exists");
			
		};
		
		
		this.courseList.add(course);
		return course;
	}

	@Override
	public Course getCourse(String name) {
		// TODO Auto-generated method stub
		if(name == null || name.isBlank()) {
			throw new CourseApiException(HttpStatus.BAD_REQUEST, "Its nessesary the 'courseName' param to execute the search");
		}
		return this.courseList.stream()
				.filter(_course -> _course.getName().contains(name))
				.findFirst()
				.orElseThrow(() -> new CourseApiException(HttpStatus.BAD_REQUEST, "Did not find course with the name provided"));
		
	}

	@Override
	public List<Course> getAllCourses(int from, int limit) {
		// TODO Auto-generated method stub
		
		return this.courseList.stream().skip(from).limit(limit).toList();
		

	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course deleteCourse(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

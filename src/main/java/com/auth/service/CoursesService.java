package com.auth.service;

import com.auth.controller.dto.CoursesDTO;
import com.auth.entity.Courses;

public interface CoursesService {

	CoursesDTO createCourses(CoursesDTO coursesRequests);
	
	Courses findCoursesByCode(String code);
}

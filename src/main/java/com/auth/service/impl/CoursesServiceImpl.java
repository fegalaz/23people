package com.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.controller.dto.CoursesDTO;
import com.auth.entity.Courses;
import com.auth.repository.CoursesRepository;
import com.auth.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	public CoursesRepository coursesRepository;
	
	@Override
	public CoursesDTO createCourses(CoursesDTO coursesRequests) {
		return null;
	}
	
	@Override
	public Courses findCoursesByCode(String code) {
		Courses respond = coursesRepository.findCoursesByCode(code);
		return respond;
	}
}

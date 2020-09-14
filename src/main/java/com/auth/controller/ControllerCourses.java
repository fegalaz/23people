package com.auth.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.controller.dto.CoursesDTO;
import com.auth.entity.Courses;
import com.auth.service.CoursesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/23people")
@RequiredArgsConstructor
public class ControllerCourses {

	private final static Logger LOGGER = Logger.getLogger(Controller.class.getName());

	@Autowired
	private CoursesService coursesService;

	@PostMapping(value = "/createCourses")
	@ResponseBody
	public ResponseEntity<?> createCourses(@RequestBody CoursesDTO coursesRequests) {

		LOGGER.info("{coursesService.createCourses}");
		CoursesDTO respond = coursesService.createCourses(coursesRequests);
		return new ResponseEntity<CoursesDTO>(respond, HttpStatus.OK);
	}

	@GetMapping(value = "/hello")
	public String firstPage() {
		return "Hello World";
	}
	
	@GetMapping(value ="/getCourseById")
	public ResponseEntity<Courses> getCourseById(@RequestParam String code){
		
		Courses respond = coursesService.findCoursesByCode(code);
		return new ResponseEntity<Courses>(respond, HttpStatus.OK);
	}
	
}

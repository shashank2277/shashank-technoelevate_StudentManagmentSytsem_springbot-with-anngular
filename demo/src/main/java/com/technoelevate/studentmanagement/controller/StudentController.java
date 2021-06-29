package com.technoelevate.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.technoelevate.studentmanagement.bean.StudentBean;
import com.technoelevate.studentmanagement.bean.StudentResponse;
import com.technoelevate.studentmanagement.service.StudentServiceImpl;

@RestController

public class StudentController {
	@Autowired
	StudentServiceImpl serviceImpl;

	@GetMapping("/")
	public String firstHandlerMethod() {
		return "TechnoElevate";
	}// end of firstHandler Method

	@GetMapping(path = "/getStudent", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponse searchStudent(int userid) {
		StudentResponse studentResponse = new StudentResponse();
		StudentBean studentBean = serviceImpl.searchStudent(userid);

		if (studentBean != null) {
			studentResponse.setStatusCode(200);
			studentResponse.setMsg("success");
			studentResponse.setDescription(" Data found for id : " + userid);
			studentResponse.setBean(studentBean);
		} else {
			studentResponse.setStatusCode(404);
			studentResponse.setMsg("failure");
			studentResponse.setDescription("Error Data Not found");
		}
		return studentResponse;
	}// end of getEmp

	@DeleteMapping(path = "/delete/{student_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse deleteEmp(@PathVariable(name = "student_id") int userid) {
		StudentResponse studentResponse = new StudentResponse();
		if (serviceImpl.delete(userid)) {
			studentResponse.setStatusCode(200);
			studentResponse.setMsg("success");
			studentResponse.setDescription(" Data Deleted for id : " + userid);
		} else {
			studentResponse.setStatusCode(400);
			studentResponse.setMsg("failure");
			studentResponse.setDescription(" Data Not for id : " + userid);
		}

		return studentResponse;
	}// end of the delete student

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse insert(@RequestBody StudentBean employeeBean) {
		StudentResponse response = new StudentResponse();
		if (serviceImpl.insertStudent(employeeBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}// end of the insert

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse updateStudent(@RequestBody StudentBean bean) {
		System.out.println(bean);
		StudentResponse response = new StudentResponse();
		if (serviceImpl.updateStudent(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Updated Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}// end of the update

	@GetMapping(path = "/getMarks", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponse aggregateMarks(@RequestBody StudentBean bean) {
		StudentResponse response = new StudentResponse();
		boolean bean2 = serviceImpl.aggregateMarks(0);
		if (serviceImpl.aggregateMarks(0)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("aggregate marks");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("not found");
		}

		return response;
		
	}
	@GetMapping(path = "/getGrade", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponse grade(@RequestBody StudentBean bean) {
		StudentResponse response = new StudentResponse();
		String bean2 = serviceImpl.grade(bean);
		if(serviceImpl.aggregateMarks(0)) {
			response.setStatusCode(200);
			response.setMsg(" grade");
			response.setDescription("grade are");
		}else {
			response.setStatusCode(400);
			response.setMsg("not found");
			response.setDescription("grade not good ");
			
		}
		return response;
	}
	

}

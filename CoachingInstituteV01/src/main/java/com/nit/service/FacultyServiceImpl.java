package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IFacultyDao;
import com.nit.dto.FacultyDTO;
import com.nit.model.Faculty;
@Service
public class FacultyServiceImpl implements IFacultyService {

	@Autowired
	private IFacultyDao dao;
	
	@Override
	@Transactional(readOnly=false)
	public void registerFaculty(FacultyDTO facultyDTO) {
		Faculty faculty=new Faculty();
		BeanUtils.copyProperties(facultyDTO, faculty);
		dao.addFaculty(faculty);
	}
	
	@Override
	public FacultyDTO showFaculty(Integer id) {
		Faculty faculty=dao.getFaculty(id);
		FacultyDTO dto=new FacultyDTO();
		BeanUtils.copyProperties(faculty, dto);
		return  dto;
	}

	@Override
	@Transactional
	public void removeFaculty(Integer id) {
        dao.deleteFaculty(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void editFaculty(FacultyDTO facultyDTO) {
		Faculty faculty=new Faculty();
		BeanUtils.copyProperties(facultyDTO, faculty);
		dao.updateFaculty(faculty);
	}
	
	@Override
	public List<FacultyDTO> allFaculty() {
		List<FacultyDTO> list=new ArrayList();
		 dao.allFaculty().forEach(faculty->{
			 FacultyDTO dto=new FacultyDTO();
			 BeanUtils.copyProperties(faculty, dto);
			 list.add(dto);
		 });
		 return list;
	}
}
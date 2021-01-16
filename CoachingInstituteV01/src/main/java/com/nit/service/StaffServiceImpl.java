package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IStaffDao;
import com.nit.dto.StaffDTO;
import com.nit.model.Staff;

@Service
public class StaffServiceImpl implements IStaffService{

	@Autowired
	private IStaffDao dao;

	@Override
	@Transactional(readOnly=false)
	public void registerStaff(StaffDTO dto) {
		Staff staff=new Staff();
		BeanUtils.copyProperties(dto, staff);
		dao.addStaff(staff);
	}

	@Override
	@Transactional(readOnly=true)
	public StaffDTO showStaff(Integer id) {
		 StaffDTO dto=new StaffDTO(	);
		 BeanUtils.copyProperties(dao.getStaff(id), dto);
		 return dto;
	}

	@Override
	@Transactional(readOnly=false)
	public void removeStaff(Integer id) {
	   dao.deleteStaff(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void editStaff(StaffDTO dto) {
		Staff staff=new Staff();
		BeanUtils.copyProperties(dto, staff);
	    dao.updateStaff(staff);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StaffDTO> allStaff() {
		List<StaffDTO> listDto=new ArrayList();
		dao.allStaff().forEach(staff->{
			StaffDTO dto=new StaffDTO();
			listDto.add(dto);
		});
		return listDto;
	}

}

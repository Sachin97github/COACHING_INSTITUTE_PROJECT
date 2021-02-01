package com.nit.service;

import java.util.List;

import com.nit.dto.CourseDTO;
import com.nit.dto.StaffDTO;

public interface IStaffService {
	public void registerStaff(StaffDTO dto);
	public StaffDTO showStaff(Integer id);
    public void removeStaff(Integer id);
    public void editStaff(StaffDTO dto);
    public List<StaffDTO> allStaff();    
}

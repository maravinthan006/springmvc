package com.niit.dao;

import java.util.List;

import com.niit.model.Register;

public interface RegisterDAO {

	public void addRegister(Register register);
	public List<Register> validate(Register register);
	
}

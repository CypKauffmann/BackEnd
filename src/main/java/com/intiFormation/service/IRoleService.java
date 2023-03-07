package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Role;

public interface IRoleService {

	public Optional<Role> selectById(int id);

	public List<Role> getAllRoles();

	public Role ajout(Role role);
	}

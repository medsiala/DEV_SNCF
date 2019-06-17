package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.dao.RoleRepository;
import org.sid.dao.UsersRepository;
import org.sid.entities.Role;
import org.sid.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UsersRepository usersRepository ;
	
	public Users save(Users u) {
		return usersRepository.save(u);
	}
	public List<Users> findAll(){
		return usersRepository.findAll();
	}
     @Autowired
     RoleRepository roleRepository;
     public Role saveRole(Role r) {
 		return roleRepository.save(r);
 	}
 	public List<Role> findRole(){
 		return roleRepository.findAll();
 	}
 	public Users addRoleToUser(String cp ,String role) {
 		
 		Users u =usersRepository.findById(cp).orElse(null);
 		Role r =roleRepository.findById(role).orElse(null);
 		u.getRoles().add(r);
 		usersRepository.save(u);
 		return u ;
 	}
}

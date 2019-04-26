package com.vishwa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishwa.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
	UserDetails validateUser(String loginName, String password);
}

package com.lab.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.study.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	 public List<Users> findById(Integer id);
}

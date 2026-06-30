package com.itp.pppjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.pppjwt.model.DBUser;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Integer>
{
			public DBUser findByUsername(String s);   //JPA FindBy methods
}

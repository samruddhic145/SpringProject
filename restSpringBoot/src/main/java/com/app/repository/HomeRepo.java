package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event.ID;

import com.app.model.Student;
@Repository
public interface HomeRepo extends JpaRepository<Student,Integer>  {
	public Student findByUsernameOrPassword(String username,String password);
	@Query("from Student where username=?1and password=?2")
	public Student StudentValidateByUserNameAndPassword(String useraname ,String Password);
	@Query("from Student where username=:username and password=:password")
	public Student getStudentByUsernameAndPassword(@Param("username") String un, @Param("password")String ps);
	
	
@Transactional
@Modifying
	public void deleteByName(String name);

	
	
}

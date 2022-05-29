package com.blit.SpringBootJPARestCRUDAPIAssignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blit.SpringBootJPARestCRUDAPIAssignment.entity.Tutorial;

// define that this is used for the DAO (Data Access Object) *is a structural design pattern* 
// also allows for persistence related exceptions. (for Data Acess Exceptions) the base class of exceptions
@Repository 
public interface TutorialRepository extends JpaRepository<Tutorial, Integer>{

}

package com.bridgelabz.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.springboot.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>{
	
	public Label searchByLabelName(String labelName);
	
	@Query(value = "select * from labels where userId = ?1", nativeQuery = true)
	public List<Label> searchAllByUserId(Long userId);
	
	public Label searchByLabelId(Long labelId);
	
}

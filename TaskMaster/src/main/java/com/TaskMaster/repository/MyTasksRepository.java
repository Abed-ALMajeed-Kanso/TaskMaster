package com.TaskMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskMaster.entity.MyTasksList;

@Repository
public interface MyTasksRepository extends JpaRepository<MyTasksList,Integer>{

}

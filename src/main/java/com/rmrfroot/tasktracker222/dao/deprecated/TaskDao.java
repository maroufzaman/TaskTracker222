package com.rmrfroot.tasktracker222.dao.deprecated;


import com.rmrfroot.tasktracker222.entities.deprecated.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer> {
}

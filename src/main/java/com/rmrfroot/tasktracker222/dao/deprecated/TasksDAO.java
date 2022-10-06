package com.rmrfroot.tasktracker222.dao.deprecated;

import com.rmrfroot.tasktracker222.entities.deprecated.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksDAO extends JpaRepository<Task,Integer> {
}

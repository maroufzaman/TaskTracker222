package com.rmrfroot.tasktracker222.DAO;

import com.rmrfroot.tasktracker222.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {
}

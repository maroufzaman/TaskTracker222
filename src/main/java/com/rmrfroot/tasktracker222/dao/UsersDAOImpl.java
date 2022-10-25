package com.rmrfroot.tasktracker222.dao;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import com.rmrfroot.tasktracker222.entities.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UsersDAOImpl implements CustomUsersDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Boolean hasUserData(String email) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<Users> query=cSession.createQuery("from Users where email=:email",Users.class);
        query.setParameter("email",email);
        Boolean check=false;
        List<Users> list=query.getResultList();
        try{
            if(list.size()>0) {
                check=true;
            }
        }catch (Exception e){
            check=false;
        }
        return check;
    }


    @Override
    public Users findUserByEmail(String email) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<Users> query=cSession.createQuery("from Users where email=:email",Users.class);
        query.setParameter("email",email);

        Users user=null;
        try{
            user=query.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }
    @Override
    public Users findUsersById(int id){
        Session cSession=entityManager.unwrap(Session.class);
        Query<Users> query=cSession.createQuery("from Users where id=:id",Users.class);
        query.setParameter("id",id);

        Users user=null;
        try{
            user=query.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }
    @Override
    public void save(Users user) {
        Session cSession=entityManager.unwrap(Session.class);
        cSession.saveOrUpdate(user);
    }

    @Override
    public Users findUserByUsername(String username) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<Users> query=cSession.createQuery("from Users where username=:username",Users.class);
        query.setParameter("username",username);

        Users user=null;
        try{
            user=query.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }

}

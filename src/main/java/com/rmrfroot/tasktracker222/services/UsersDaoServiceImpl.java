package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.dao.UsersDao;
import com.rmrfroot.tasktracker222.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsersDaoServiceImpl implements UsersDaoService {
    @Autowired
    private UsersDao usersDAO;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return usersDAO.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = usersDAO.findById(theId);

        User acc;

        if (result.isPresent()) {
            acc = result.get();
        } else {
            //we didn't find the employee
            throw new RuntimeException("Did not find account id - " + theId);
        }
        return acc;
    }


    @Override
    public void deleteById(int theId) {
        usersDAO.deleteById(theId);
    }

    @Override
    public User update(int id, User user) {
        try {
            Optional<User> result = usersDAO.findById(id);

            User updatedUser;

            if (result.isPresent()) {
                updatedUser = result.get();
                usersDAO.deleteById(id);
            } else {
                //day not found
                throw new RuntimeException("Did not find user id - " + id);
            }
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setMilitaryEmail(user.getMilitaryEmail());
            updatedUser.setCivilianEmail(user.getCivilianEmail());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setOfficeNumber(user.getOfficeNumber());
            updatedUser.setRank(user.getRank());
            updatedUser.setWorkCenter(user.getWorkCenter());
            updatedUser.setFlight(user.getFlight());
            updatedUser.setTeams(user.getTeams());
            usersDAO.save(updatedUser);
            return updatedUser;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    @Transactional
    public void save(User user) {
        usersDAO.save(user);
    }

    @Override
    @Transactional
    public Boolean hasUserData(String email) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> query=cSession.createQuery("from User where email=:email", User.class);
        query.setParameter("email",email);
        Boolean check=false;
        List<User> list=query.getResultList();
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
    public User findUserByUsername(String username) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> query=cSession.createQuery("from User where userName=:username", User.class);
        query.setParameter("username",username);

        User user;
        try{
            user=query.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }

    @Override
    @Transactional
    public User findUserByEmail(String email){
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> query=cSession.createQuery("from User where email=:email", User.class);
        query.setParameter("email",email);

        User user=null;
        try{
            user=query.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }

    @Override
    @Transactional
    public User findUsersById(int id) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> query=cSession.createQuery("from User where id=:id", User.class);
        query.setParameter("id",id);

        User user=null;
        try{
            user=query.getSingleResult();
        }catch (Exception e){
            user=null;
        }
        return user;
    }

    @Override
    @Transactional
    public void registerUserToDatabase(String userName, String firstName, String lastName, String militaryEmail, String civilianEmail,
                                       String email,String phoneNumber, String officeNumber, String rank, String workCenter,
                                       String flight, ArrayList<String> teams) {
        User user =new User(userName, firstName, lastName, militaryEmail, civilianEmail,email,
                phoneNumber, officeNumber, rank, workCenter,
                flight, teams);
        usersDAO.save(user);
    }

    @Override
    public List<User> findUsersByWorkCenter(String workCenter) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> query=cSession.createQuery("from User where workCenter = :workCenter", User.class);
        query.setParameter("workCenter", workCenter);

        List<User> users;
        try {
            users = query.getResultList();
        }
        catch (Exception e) {
            users = null;
        }
        return users;
    }

    @Override
    public List<User> findUsersByFlight(String flight) {
        Session cSession=entityManager.unwrap(Session.class);
        Query<User> query=cSession.createQuery("from User where flight = :flight", User.class);
        query.setParameter("flight", flight);

        List<User> users;
        try {
            users = query.getResultList();
        }
        catch (Exception e) {
            users = null;
        }
        return users;
    }

    @Override
    public List<User> findUsersByTeam(String team) {
        Session cSession=entityManager.unwrap(Session.class);

        Query<User> query= cSession.createQuery("from User where cast(teams as string) like concat('%',:team,'%') ", User.class);
        query.setParameter("team", team);

        List<User> users;
        try {
            users = query.getResultList();
        }
        catch (Exception e) {
            users = null;
        }
        return users;
    }

}

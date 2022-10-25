package com.rmrfroot.tasktracker222.dao;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DrillSchedulesImpl implements CustomDrillSchedulesDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public DrillSchedules findDrillSchedulesById(int id){
        Session cSession=entityManager.unwrap(Session.class);
        Query<DrillSchedules> query=cSession.createQuery("from DrillSchedules where id=:id",DrillSchedules.class);
        query.setParameter("id",id);

        DrillSchedules drillSchedules=null;
        try{
            drillSchedules=query.getSingleResult();
        }catch (Exception e){
            drillSchedules=null;
        }
        return drillSchedules;
    }

    @Override
    public void save(DrillSchedules drillSchedules) {
        Session cSession=entityManager.unwrap(Session.class);
        cSession.saveOrUpdate(drillSchedules);
    }
}

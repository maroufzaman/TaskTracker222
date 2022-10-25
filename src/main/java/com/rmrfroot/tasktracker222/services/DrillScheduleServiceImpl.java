package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.dao.CustomDrillSchedulesDAO;
import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrillScheduleServiceImpl implements DrillScheduleService{

    @Autowired
    private CustomDrillSchedulesDAO customDrillSchedulesDAO;

    @Override
    public DrillSchedules findDrillSchedulesById(int id) {
        return customDrillSchedulesDAO.findDrillSchedulesById(id);
    }

    @Override
    public void save(DrillSchedules drillSchedules) {
        customDrillSchedulesDAO.save(drillSchedules);
    }
}

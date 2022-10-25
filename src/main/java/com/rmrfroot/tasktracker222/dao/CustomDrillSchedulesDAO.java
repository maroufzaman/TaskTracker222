package com.rmrfroot.tasktracker222.dao;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;

public interface CustomDrillSchedulesDAO {

    public DrillSchedules findDrillSchedulesById(int id);
    public void save(DrillSchedules drillSchedules);
}

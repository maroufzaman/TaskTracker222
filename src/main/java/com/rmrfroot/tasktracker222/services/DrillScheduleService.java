package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;

public interface DrillScheduleService {

    public DrillSchedules findDrillSchedulesById(int id);
    public void save(DrillSchedules drillSchedules);

    //DrillSchedules update(int id, DrillSchedules drillSchedules);
}

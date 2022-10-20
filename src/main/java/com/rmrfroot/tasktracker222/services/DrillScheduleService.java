package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import com.rmrfroot.tasktracker222.entities.Users;

public interface DrillScheduleService {

    public DrillSchedules findDrillSchedulesById(int id);
    public void save(DrillSchedules drillSchedules);

    DrillSchedules update(int id, DrillSchedules drillSchedules);
}

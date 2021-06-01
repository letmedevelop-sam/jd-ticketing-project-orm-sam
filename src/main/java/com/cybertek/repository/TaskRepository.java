package com.cybertek.repository;

import com.cybertek.entity.Project;
import com.cybertek.entity.Task;
import com.cybertek.entity.User;
import com.cybertek.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    //write query
    //JPQL : find number of tasks under a certain projectCode which are not COMPLETED
    @Query("select count(t) from Task t where t.project.projectCode = ?1 and t.taskStatus<>'COMPLETED'")
    int totalNonCompletedTasks(String projectCode);

    @Query("select count(t) from Task t where t.project.projectCode = ?1 and t.taskStatus='COMPLETED'")
    int totalCompletedTasks(String projectCode);
}

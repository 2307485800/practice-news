package com.news.schedule.service.impl;

import com.news.model.schedule.dtos.Task;
import com.news.schedule.ScheduleApplication;
import com.news.schedule.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = ScheduleApplication.class)
@RunWith(SpringRunner.class)
public class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void addTask() {

            Task task = new Task();
            task.setTaskType(100);
            task.setPriority(50);
            task.setParameters("task test".getBytes());
            task.setExecuteTime(new Date().getTime()+50000);

            long taskId = taskService.addTask(task);

    }

    @Test
    public void cancelTesk(){
        taskService.cancelTask(1775430068139585537L);
    }

    @Test
    public void testPoll(){
        Task task = taskService.poll(100, 50);
        System.out.println(task);
    }


}
package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.entity.Project;
import com.cybertek.enums.Status;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.mapper.UserMapper;
import com.cybertek.repository.ProjectRepository;
import com.cybertek.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    private ProjectMapper projectMapper;
    private ProjectRepository projectRepository;
    private UserMapper userMapper;

    //create constructor for Injection
    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository, UserMapper userMapper) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
        this.userMapper = userMapper;
    }

    //Implement overridden methods
    @Override
    public ProjectDTO getByProjectCode(String code) {
        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        return null;
    }

    @Override
    public void save(ProjectDTO dto) {
        // There is no field to set Project Status in our Form. When we start project it will automatically be OPEN
        dto.setProjectStatus(Status.OPEN);

        //When data entered to UI a DTO will come and we will convert it to ENTITY
        Project obj = projectMapper.convertToEntity(dto); //constructor injection needed to use this method from ProjectMapper

        //we need to assign manager //when one object has dependency on other object we need to make this kind of conversion
        obj.setAssignedManager(userMapper.convertToEntity(dto.getAssignedManager())); //constructor injection needed to use this method from UserMapper

        //we need to SAVE the changes
        Project project = projectRepository.save(obj); //constructor injection needed to use this method from ProjectRepository

    }

    @Override
    public ProjectDTO update(ProjectDTO dto) {
        return null;
    }

    @Override
    public void delete(String code) {

    }
}

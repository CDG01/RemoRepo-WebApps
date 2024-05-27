package com.example.CrudTest_webApp.services;

import com.example.CrudTest_webApp.Repository.StudentRepo;
import com.example.CrudTest_webApp.models.entities.StudentEntity;
import com.example.CrudTest_webApp.models.dtos.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper mapper;

    public StudentDto createUser (StudentDto user){
        StudentEntity entity = mapper.map(user, StudentEntity.class);
        StudentEntity saved = studentRepo.saveAndFlush(entity);
        mapper.map(saved, user);
        return user;
    }
    public StudentDto findById (Long id){
        StudentEntity entity = studentRepo.findById(id).orElse(null);
        if (entity==null) return null;
        return mapper.map(entity, StudentDto.class);
    }
    public List<StudentDto> findALl (){
        List<StudentEntity> entities = studentRepo.findAll();
        List<StudentDto> dtos = new ArrayList<StudentDto>();
        for (StudentEntity entity:entities){
            if (entity==null) {
                dtos.add(mapper.map(entity, StudentDto.class));
            }
        }
        return mapper.map(entities, List.class);
    }
    public StudentDto isWorkingSwitch(Long id, Boolean working){
        Optional<StudentEntity> foundedEntity = studentRepo.findById(id);
        if (!foundedEntity.isPresent()) return null;
        StudentEntity foundStudentEntity = foundedEntity.get();
        foundStudentEntity.setIsWorking(working);
        studentRepo.saveAndFlush(foundStudentEntity);
        return mapper.map(foundedEntity, StudentDto.class);
    }
    public StudentDto changeInfo(Long id, StudentDto user){
        Optional<StudentEntity> foundedEntity = studentRepo.findById(id);
        if (!foundedEntity.isPresent()) return null;
        user.setId(id);

        StudentEntity updatedEntity = studentRepo.saveAndFlush(mapper.map(user, StudentEntity.class));
        return mapper.map(updatedEntity, StudentDto.class);
    }
    public void deleteUser(Long id){
        studentRepo.deleteById(id);
    }
}

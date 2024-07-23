package com.example.Week2HWSpringMVC.SpringMVCWeek2HW.Service;

import com.example.Week2HWSpringMVC.SpringMVCWeek2HW.DTO.DeptDTO;
import com.example.Week2HWSpringMVC.SpringMVCWeek2HW.Entity.DeptEntity;
import com.example.Week2HWSpringMVC.SpringMVCWeek2HW.Repository.DeptRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptService {

    private final DeptRepository deptRepository;
    private final ModelMapper modelMapper;

    public DeptService(DeptRepository deptRepository, ModelMapper modelMapper) {
        this.deptRepository = deptRepository;
        this.modelMapper = modelMapper;
    }

    public List<DeptDTO> getAllDepartments(){
        List<DeptEntity> deptEntities =deptRepository.findAll();
        return deptEntities
                .stream()
                .map(deptEntity -> modelMapper.map(deptEntity, DeptDTO.class))
                .collect(Collectors.toList());
    }

    public DeptDTO createDept(DeptDTO inputInfoOfDept) {
        DeptEntity deptEntity = modelMapper.map(inputInfoOfDept, DeptEntity.class);
        DeptEntity infoOfDept = deptRepository.save(deptEntity);
        return modelMapper.map(infoOfDept, DeptDTO.class);
    }

    public DeptDTO updateDept(Long deptId, DeptDTO deptDTO) {
        DeptEntity deptEntity = modelMapper.map(deptDTO, DeptEntity.class);
        deptEntity.setId(deptId);
        DeptEntity updatedDept = deptRepository.save(deptEntity);
        return modelMapper.map(updatedDept, DeptDTO.class);
    }

    public Boolean deleteDeptById(Long deptId) {
        Boolean exists = deptRepository.existsById(deptId);
        if(exists) {
            deptRepository.deleteById(deptId);
        }
        return false;
    }
}

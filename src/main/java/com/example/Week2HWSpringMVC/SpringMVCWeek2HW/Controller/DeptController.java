package com.example.Week2HWSpringMVC.SpringMVCWeek2HW.Controller;

import com.example.Week2HWSpringMVC.SpringMVCWeek2HW.DTO.DeptDTO;
import com.example.Week2HWSpringMVC.SpringMVCWeek2HW.Service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dept")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public ResponseEntity<List<DeptDTO>> getAllDept(){
        return ResponseEntity.ok(deptService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DeptDTO> createDept(@RequestBody DeptDTO inputInfoOfDept){
        DeptDTO deptDTO = deptService.createDept(inputInfoOfDept);
        return new ResponseEntity<>(deptDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{deptId}")
    public ResponseEntity<DeptDTO> upDateDept( @RequestBody DeptDTO deptDTO, @PathVariable Long deptId){
        return ResponseEntity.ok(deptService.updateDept(deptId, deptDTO));

    }

    @DeleteMapping(path = "/{deptId}")
    public ResponseEntity<Boolean> deleteDept(@PathVariable Long deptId){
        Boolean gotDeleted =deptService.deleteDeptById(deptId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }




}

package com.example.Week2HWSpringMVC.SpringMVCWeek2HW.Repository;

import com.example.Week2HWSpringMVC.SpringMVCWeek2HW.Entity.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<DeptEntity, Long> {


}

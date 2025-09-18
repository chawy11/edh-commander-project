package com.chawy.edh_commander_test.repository;

import com.chawy.edh_commander_test.model.MonoCommander;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MonoCommanderRepository extends JpaRepository<MonoCommander, Long> {

    List<MonoCommander> findByColor(String color);
}

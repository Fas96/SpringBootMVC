package com.fas.SpringBootMVC.database;

import com.fas.SpringBootMVC.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.Period;
import java.util.List;
import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Integer> {
    List<Person> findByName(String name);

    List<Person> findByAgeGreaterThan(int age);

    @Query("from Person where name=?1 order by age ")
    List<Person> findByNameSorted(String name);

}

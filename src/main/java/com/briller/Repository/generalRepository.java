package com.briller.Repository;

import com.briller.Model.general;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface generalRepository extends JpaRepository<general,Integer> {

    List<general> findAll();
}

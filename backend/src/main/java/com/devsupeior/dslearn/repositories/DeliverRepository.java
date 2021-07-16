package com.devsupeior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsupeior.dslearn.entities.Deliver;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {

}

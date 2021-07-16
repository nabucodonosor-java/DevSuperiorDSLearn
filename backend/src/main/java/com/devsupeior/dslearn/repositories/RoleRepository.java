package com.devsupeior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsupeior.dslearn.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

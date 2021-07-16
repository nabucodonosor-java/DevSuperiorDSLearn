package com.devsupeior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsupeior.dslearn.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}

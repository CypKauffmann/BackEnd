package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Participant;

public interface ParticipantDao extends JpaRepository<Participant, Integer>{

}

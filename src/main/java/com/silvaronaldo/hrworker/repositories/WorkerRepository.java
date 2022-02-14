package com.silvaronaldo.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silvaronaldo.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
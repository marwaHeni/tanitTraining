package com.mapsit.tanitTraining.BaseTva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Depot entity.
 */

@Repository
public interface BaseTvaRepository extends JpaRepository<BaseTva, Long> {

}
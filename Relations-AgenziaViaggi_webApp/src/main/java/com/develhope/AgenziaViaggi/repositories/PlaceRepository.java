package com.develhope.AgenziaViaggi.repositories;

import com.develhope.AgenziaViaggi.entities.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
}

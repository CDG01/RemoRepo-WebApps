package com.develhope.Ospedale.repositories;

import com.develhope.Ospedale.entities.Dottore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DottoreRepo extends JpaRepository<Dottore, Long> {
    List<Dottore> findAllByDeleted(Boolean deleted);

    @Query(value = "SELECT * FROM dottori WHERE deleted = 0 ", nativeQuery = true)
    List<Dottore> nativeQueryDottore();

//    @Query(value = "SELECT d FROM Dottore d WHERE d.deleted = ?1")
//    List<Dottore> jdqlDottoreByDeleted(Boolean deleted);

    @Query(value = "SELECT d FROM Dottore d WHERE d.deleted = :deleted")
    List<Dottore> jdqlDottoreByDeleted(@Param("deleted") Boolean deleted);

    Optional<Dottore> findByIdAndDeleted(Long id, Boolean deleted);


    @Modifying
    @Query("UPDATE Dottore d SET d.deleted = true WHERE d.id = :id")
    int delete(@Param("id") Long id);

}

package tg.voyage_pro.reservation_pro.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tg.voyage_pro.reservation_pro.Model.VOYAGE;


@Repository
public interface VoyageRepository extends JpaRepository<VOYAGE , Long> {
    @Query(value = "SELECT * FROM VOYAGE v ORDER BY v.id_voyage DESC" , nativeQuery = true)
    List<VOYAGE> findAllOrderByIdVoyageDesc();
    @Query(value = "SELECT * FROM VOYAGE v ORDER BY v.date_voyage DESC" , nativeQuery = true)
    List<VOYAGE> findAllByOrderByDateVoyageDesc();



}

package tg.voyage_pro.reservation_pro.database;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tg.voyage_pro.reservation_pro.Model.CLIENT;


@Repository
public interface ClientRepository extends JpaRepository<CLIENT , Long> {

    @Query(value = "SELECT * FROM CLIENT c ORDER BY c.id_client DESC" , nativeQuery = true)
    List<CLIENT> findAllOrderByIdClientDesc();

    @Query(value = "SELECT * FROM client c_1 WHERE c_1.id_client IN (" +
    "SELECT c_2.id_client FROM client c_2 WHERE (:sexe IS NULL OR c_2.sexe_client = '%' || :sexe || '%') OR (:date_naissance IS NULL OR (TO_CHAR(c_2.date_naiss, 'YYYY-MM-DD') = '%' || :date_naissance || '%')) " +
    ") OR c_1.id_client IN (" +
    "SELECT c_3.id_client FROM client c_3 WHERE (:telephone IS NULL OR c_3.tel_client LIKE '%' || :telephone || '%') " +
    ") OR c_1.id_client IN (" +
    "SELECT c_4.id_client FROM client c_4 WHERE (:mail IS NULL OR c_4.mail_client LIKE '%' || :mail || '%') " +
    ") OR c_1.id_client IN (" +
    "SELECT c_5.id_client FROM client c_5 WHERE (:nom IS NULL OR c_5.nom_client LIKE '%' || :nom || '%') " +
    ") OR c_1.id_client IN (" +
    "SELECT c_6.id_client FROM client c_6 WHERE (:nom IS NULL OR c_6.prenom_client LIKE '%' || :nom || '%') " +
    ") " +
    "ORDER BY c_1.id_client DESC", 
    nativeQuery = true)

    List<CLIENT> searchClient( 
        @Param("nom") String nom,
        @Param("mail") String mail ,
        @Param("date_naissance")  String date_naissance ,
        @Param("sexe") String sexe ,
        @Param("telephone") String telephone 
    
    );

    /*(:nom IS NULL OR (c.nom_client LIKE CONCAT('%' , :nom , '%') OR c.prenom_client LIKE CONCAT('%' , :nom , '%')))  */

    /**
     * 
     * @Query(value = "SELECT * FROM CLIENT c WHERE c.id_client IN ( " +
    "SELECT id_client FROM CLIENT WHERE " +
    "nom_client ILIKE '%' || :nom || '%' " +
    "OR prenom_client ILIKE '%' || :nom || '%' " +
    "OR tel_client LIKE '%' || :telephone || '%' " +
    "OR mail_client LIKE '%' || :mail || '%' " + 
    "OR TO_CHAR(date_naiss, 'YYYY-MM-DD') LIKE '%' || :date_naissance || '%' " +
    "OR sexe_client LIKE '%' || :sexe || '%' " +
    "ORDER BY id_client DESC " +
    ") ORDER BY c.id_client DESC", nativeQuery = true)

     */
    
}

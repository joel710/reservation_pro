package tg.voyage_pro.reservation_pro.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.voyage_pro.reservation_pro.Model.PAIEMENT;


@Repository
public interface PaiementRepository extends JpaRepository<PAIEMENT , String> {
}

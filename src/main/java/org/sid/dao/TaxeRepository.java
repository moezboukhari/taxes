package org.sid.dao;

import org.sid.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.sid.entities.Entreprise;
import java.util.List;


public interface TaxeRepository extends JpaRepository<Taxe, Long>{
List<Taxe> findByEntreprise(Entreprise entreprise);
}

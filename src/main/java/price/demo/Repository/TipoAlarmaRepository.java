package price.demo.Repository;

import price.demo.Entity.TipoAlarma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoAlarmaRepository extends JpaRepository<TipoAlarma, Integer> {

}

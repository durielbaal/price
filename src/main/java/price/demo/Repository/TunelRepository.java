package price.demo.Repository;

import price.demo.Entity.Tunel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TunelRepository extends JpaRepository<Tunel, Integer> {

}

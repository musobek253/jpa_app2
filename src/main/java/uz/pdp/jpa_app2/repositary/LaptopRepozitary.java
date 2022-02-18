package uz.pdp.jpa_app2.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.jpa_app2.entity.Laptop;
@Repository
public interface LaptopRepozitary extends JpaRepository<Laptop,Integer> {
}

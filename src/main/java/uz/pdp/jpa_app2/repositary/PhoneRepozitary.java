package uz.pdp.jpa_app2.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.jpa_app2.entity.Phone;
@Repository
public interface PhoneRepozitary extends JpaRepository<Phone,Integer> {
}

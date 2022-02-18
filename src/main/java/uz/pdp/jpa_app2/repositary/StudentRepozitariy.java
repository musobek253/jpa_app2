package uz.pdp.jpa_app2.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jpa_app2.entity.Users;

public interface StudentRepozitariy extends JpaRepository<Users,Integer> {
}

package ru.restoclub.crm.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restoclub.crm.domain.user.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}

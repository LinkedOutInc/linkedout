package app.linkedout.repositories.security;

import app.linkedout.repositories.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("role") @Transactional
@RequiredArgsConstructor
public class RoleRepository extends BaseRepository {
//    Optional<Role> findByName(EnumRole name);

}

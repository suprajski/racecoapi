package com.raceco.apii.Repository;

import com.raceco.apii.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.role.roleId <> :excludedRoleId")
    List<User> findByRoleIdNot(@Param("excludedRoleId") Long excludedRoleId);

    Optional<User> findByEmailAndPasswordHash(String email, String password);
    List<User> findByRoleRoleName(String roleName);
}

// User repository
package com.procurement.procurement.repository.user;

import com.procurement.procurement.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username or email
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    // Check if user exists by username or email
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}

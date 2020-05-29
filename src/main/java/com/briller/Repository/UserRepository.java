package com.briller.Repository;

import com.briller.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByUserName(String username);

    Optional<Users> findByphoneNbr(String phoneNbr);

    Optional<Users> findByToken(String token);



}

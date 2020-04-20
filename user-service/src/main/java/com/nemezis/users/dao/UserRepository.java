package com.nemezis.users.dao;

import com.nemezis.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nemezis on 08.06.2019.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

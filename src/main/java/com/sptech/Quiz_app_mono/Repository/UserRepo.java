package com.sptech.Quiz_app_mono.Repository;

import com.sptech.Quiz_app_mono.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
}

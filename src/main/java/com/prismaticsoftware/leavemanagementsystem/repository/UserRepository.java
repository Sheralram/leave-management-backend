package com.prismaticsoftware.leavemanagementsystem.repository;

import com.prismaticsoftware.leavemanagementsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    public UserEntity findByEmailId(String email);

}

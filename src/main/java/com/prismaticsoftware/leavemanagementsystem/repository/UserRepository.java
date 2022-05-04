package com.prismaticsoftware.leavemanagementsystem.repository;

import com.prismaticsoftware.leavemanagementsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Purpose : To demonstrate all the fields of User repository connected with JpaRepository format
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    public UserEntity findByEmailId(String email);

}

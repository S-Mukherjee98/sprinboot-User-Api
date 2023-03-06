package com.caalm.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.caalm.user.model.User;

public interface UserRepository extends MongoRepository<User, String >  {
    public User findByMobileNum(String mobileNum);
    public void deleteByMobileNum(String mobileNum);
}

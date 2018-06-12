package com.anji.springbootjparedis.service.impl;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/12 10:27
 */


import com.anji.springbootjparedis.model.User;
import com.anji.springbootjparedis.repository.UserRepository;
import com.anji.springbootjparedis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    //@Cacheable,如果没有指定key则方法参数作为key保存到缓存中。
    @Cacheable(value = "users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //@CachePut缓存新增的或更新的数据到缓存,其中缓存名字是 user 。数据的key是user的id
    @CachePut(value = "user", key = "#user.id")
    public void saveUser(User user) {
        userRepository.save(user);
    }

//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }

//    @Override
//    public void saveUser(User book) {
//
//    }

//    @Override
//    public User findOne(long id) {
//        return null;
//    }

    @Cacheable(value = "user", key = "#id")
    public User findOne(long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    //@CacheEvict从缓存User中删除key为id的数据
    @CacheEvict(value = "user", key = "#id")
    public void delete(long id) {

    }

//    @Override
//    public void delete(long id) {
//
//    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }
}

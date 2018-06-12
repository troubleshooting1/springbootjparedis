package com.anji.springbootjparedis.service;


import com.anji.springbootjparedis.model.User;

import java.util.List;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/12 10:27
 */
public interface UserService {
    public List<User> findAll();

    public void saveUser(User book);

    public User findOne(long id);

    public void delete(long id);

    public List<User> findByName(String name);
}

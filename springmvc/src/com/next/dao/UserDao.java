package com.next.dao;

import com.next.vo.User;

import java.util.List;

/**
 * Created by jianliang.meng on 2016/11/8.
 */
public interface UserDao {

    public List<User> list();

    public int delete(int id);

    public int update(User user);

    public int save(User user);
}

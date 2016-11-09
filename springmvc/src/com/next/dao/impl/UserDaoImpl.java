package com.next.dao.impl;

import com.next.dao.UserDao;
import com.next.vo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jianliang.meng on 2016/11/8.
 */
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<User> list() {
        return getSqlSession().selectList("com.next.vo.user.mapper.findAll");
    }

    @Override
    public int delete(int id) {

        return getSqlSession().delete("com.next.vo.user.mapper.delete",id);
    }

    @Override
    public int update(User user) {
        return getSqlSession().update("com.next.vo.user.mapper.update",user);
    }

    @Override
    public int save(User user) {
        System.out.println(user.getName()+user.getPassword());
        return getSqlSession().insert("com.next.vo.user.mapper.insert",user);
    }
}

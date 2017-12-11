package com.vue.crud.dao;

import com.vue.crud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
}

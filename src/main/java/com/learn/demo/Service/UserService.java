package com.learn.demo.Service;

import com.learn.demo.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author demo
 * @date 2019/9/12 17:14
 */
public interface UserService extends JpaRepository<UserModel, String> {


}

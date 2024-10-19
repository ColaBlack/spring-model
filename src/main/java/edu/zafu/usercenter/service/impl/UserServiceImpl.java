package edu.zafu.usercenter.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zafu.usercenter.mapper.UserMapper;
import edu.zafu.usercenter.model.po.User;
import edu.zafu.usercenter.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-10-19 16:36:09
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}





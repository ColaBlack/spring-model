package edu.zafu.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.zafu.usercenter.common.BaseResponse;
import edu.zafu.usercenter.model.po.User;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-10-19 16:36:09
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册服务
     *
     * @param userAccount      用户名
     * @param userPassword      密码
     * @param checkPassword 确认密码
     * @return 注册成功返回用户id，失败返回null
     */
    public Long userRegister(String userAccount, String userPassword, String checkPassword);
}

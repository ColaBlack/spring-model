package edu.zafu.usercenter.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zafu.usercenter.common.ErrorCode;
import edu.zafu.usercenter.common.exception.BusinessException;
import edu.zafu.usercenter.constant.UserConstant;
import edu.zafu.usercenter.mapper.UserMapper;
import edu.zafu.usercenter.model.po.User;
import edu.zafu.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-10-19 16:36:09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    /**
     * 盐值，混淆密码
     */
    public static final String SALT = "ColaBlack";

    @Override
    public Long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (!userAccount.matches(UserConstant.ACCOUNT_REGEX)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号由字母、数字组成，长度在4-20位之间");
        }
        if (!userPassword.matches(UserConstant.PASSWORD_REGEX) || !checkPassword.matches(UserConstant.PASSWORD_REGEX)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码由字母、数字组成，长度在6-20位之间，但不能是纯数字或纯字母");
        }
        // 密码和校验密码相同
        if (!userPassword.equals(checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次输入的密码不一致");
        }
        synchronized (userAccount.intern()) {
            // 账户不能重复
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_account", userAccount);
            long count = this.baseMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号重复");
            }
            // 2. 加密
            String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
            // 3. 插入数据
            User user = new User();
            user.setUserAccount(userAccount);
            user.setUserPassword(encryptPassword);
            boolean saveResult = this.save(user);
            if (!saveResult) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "注册失败，数据库错误");
            }
            return user.getUserId();
        }
    }
}





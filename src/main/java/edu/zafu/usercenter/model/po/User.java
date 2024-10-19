package edu.zafu.usercenter.model.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @author ColaBlack
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 状态 0-正常 1-vip 2-ban 3-管理员
     */
    private Integer userRole;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 记录更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 用户简介
     */
    private String userProfile;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
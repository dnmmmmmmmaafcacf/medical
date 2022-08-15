package com.medical.entity;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

    import javax.persistence.Table;

/**
* <p>
    * 用户表
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data

        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @Table(name = "user")

    public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

    private int id;

    private String username;

    private String password;

            /**
            * 姓名
            */
    private String name;

            /**
            * 出生日期
            */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private LocalDate brithday;

            /**
            * 年龄
            */
    private Integer age;

            /**
            * 性别
            */
    private String sex;

            /**
            * 联系方式
            */
    private Integer tel;

            /**
            * 身份证
            */
    private String idcard;

            /**
            * 注册时间
            */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    private LocalDateTime enrollDate;

            /**
            * 医生外键
            */
    private Integer doid;

            /**
            * 封号状态
            */
    private String uState;

    private int vipId;
}

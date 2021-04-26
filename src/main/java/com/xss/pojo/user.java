package com.xss.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user")
public class user {
    @TableId
    private int userid;
    private String username;
    private String password;
    private String userNickname;
    private int spouseId;

}

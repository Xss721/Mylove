package com.xss.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("anniversary")
public class anniversary {
    @TableId
    private int anniversaryid;

    private int userid;

    private String anniversaryname;

    private Date anniversarytime;

    private String anniversarytext;

    private boolean anniversaryhide;

    public anniversary(int anniversaryid, int userid, Date anniversarytime) {
        this.anniversaryid = anniversaryid;
        this.userid = userid;
        this.anniversarytime = anniversarytime;
    }

    public anniversary(int anniversaryid, int userid, Date anniversarytime, String anniversarytext) {
        this.anniversaryid = anniversaryid;
        this.userid = userid;
        this.anniversarytime = anniversarytime;
        this.anniversarytext = anniversarytext;
    }
}

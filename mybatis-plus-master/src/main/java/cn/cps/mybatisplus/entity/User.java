package cn.cps.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;
    private String userPassword;
    private Integer userGender;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createDateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDateTime;

    @TableLogic
    private Integer is_delete;

}

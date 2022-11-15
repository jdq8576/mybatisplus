package cn.edu.njtech.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tim
 * @date 2022/11/15 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

/**
 * 默认情况下MP操作的表名就是实体类的类名，但是如果表名和类名不一致就需要我们自己设置映射规则。
 */
@TableName("user")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    /**
     * 默认情况下MP会根据实体类的属性名去映射表的列名。
     * 如果数据库的列表和实体类的属性名不一致了我们可以使用`@TableField`注解的`value`属性去设置映射关系
     */
    @TableField("address")
    private String addressStr;
}

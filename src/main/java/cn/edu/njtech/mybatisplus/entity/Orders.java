package cn.edu.njtech.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author tim
 * @date 2022/11/15 18:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Long id;
    /**
     * 价格
     */
    private Integer price;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 逻辑删除标识 0-未删除 1-已删除
     */
    private Integer delFlag;
}

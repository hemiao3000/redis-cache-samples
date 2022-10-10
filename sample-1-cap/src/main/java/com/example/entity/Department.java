package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("department")
@RedisHash(value = "Department", timeToLive = 10)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门所在地
     */
    private String location;


}

USE scott;

DROP TABLE IF EXISTS department;
CREATE TABLE department
(
    `id`       BIGINT AUTO_INCREMENT COMMENT '部门ID',
    `name`     VARCHAR(15) COMMENT '部门名称',
    `location` VARCHAR(13) COMMENT '部门所在地',
    PRIMARY KEY (`id`)
) COMMENT '部门信息表';

INSERT INTO department
VALUES (1, 'ACCOUNTING', 'NEW YORK'),
       (2, 'RESEARCH', 'DALLAS'),
       (3, 'SALES', 'CHICAGO'),
       (4, 'OPERATIONS', 'BOSTON');
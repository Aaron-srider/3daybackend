package com.bistu.threeday.player.model;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Player {
    @TableId(type = IdType.AUTO)
    private int id;
    @ExcelProperty(value = "name", index = 0)
    private String name;
    @ExcelProperty(value = "sex", index = 1)
    private String sex;
    @ExcelProperty(value = "age", index = 2)
    private String age;
    @ExcelProperty(value = "country", index = 3)
    private String country;
    private String itemPlay;
    @ExcelProperty(value = "preResult", index = 4)
    private String preResult;
    @ExcelProperty(value = "finalResult", index = 5)
    private String finalResult;
    @ExcelProperty(value = "healthStatus", index = 6)
    private String healthStatus;
    @ExcelProperty(value = "comeTime", index = 7)
    private String comeTime;
}

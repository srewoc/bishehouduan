package com.bydbishe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProblemManageVo implements Serializable {
    private Integer uid;
    //题型:1选择题，2填空题，3判断题，4简答题，5计算题，6综合分析题
    private Integer type;
    //题目内容
    private String text;
    //答案
    private String answer;
    //知识点
    private String knowledge;
    //难度
    private String difficulty;
    //图片链接,多张图片之间用'-'连接
    private String picture;
    //答案图片链接,多张图片之间用'-'连接
    private String anspicture;
    //填空题的填空数
    private Integer kong;
}

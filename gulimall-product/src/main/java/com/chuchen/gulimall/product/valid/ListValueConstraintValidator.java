package com.chuchen.gulimall.product.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author chuchen
 * @Date 2022/9/14
 * @Description ListValue 注解校验器
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer> {

    private final Set<Integer> set = new HashSet<>();

    //初始化
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] values = constraintAnnotation.values();
        for (int value : values) {
            set.add(value);
        }
    }

    //判断是否校验成功
    /**
     *
     * @param integer 需要校验的值
     * @param constraintValidatorContext 校验的环境信息
     * @return 是否校验成功
     */
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(integer);
    }
}

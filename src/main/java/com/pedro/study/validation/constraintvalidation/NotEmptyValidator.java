package com.pedro.study.validation.constraintvalidation;

import com.pedro.study.validation.NotEmptyList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.util.List;

public class NotEmptyValidator implements ConstraintValidator <NotEmptyList, List> {

    @Override
    public void initialize(NotEmptyList constraintAnnotation) {

    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        return list != null && !list.isEmpty();
    }
}

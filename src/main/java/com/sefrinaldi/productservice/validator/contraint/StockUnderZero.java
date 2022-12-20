package com.sefrinaldi.productservice.validator.contraint;

import com.sefrinaldi.productservice.validator.StockUnderZeroValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = {StockUnderZeroValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface StockUnderZero {

    String message() default "stock product cannot under zero";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

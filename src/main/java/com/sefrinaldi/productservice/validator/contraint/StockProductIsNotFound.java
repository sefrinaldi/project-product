package com.sefrinaldi.productservice.validator.contraint;

import com.sefrinaldi.productservice.validator.StockProductIsNotFoundValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR,ElementType.TYPE,ElementType.PARAMETER})
@Constraint(validatedBy = {StockProductIsNotFoundValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface StockProductIsNotFound {

    String message() default "stock product is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package com.sefrinaldi.productservice.validator.contraint;

import com.sefrinaldi.productservice.validator.ProductIsNotFoundValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR,ElementType.TYPE,ElementType.PARAMETER})
@Documented
@Constraint(validatedBy = {ProductIsNotFoundValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductCodeIsNotFound {

    String message() default "product code is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

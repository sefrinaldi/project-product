package com.sefrinaldi.productservice.validator.groups;

import com.sefrinaldi.productservice.controller.StockController;

import javax.validation.GroupSequence;

@GroupSequence(value = {StockController.class, ValidateFirst.class, ValidateSecond.class})
public interface StockControllerChecks {
}

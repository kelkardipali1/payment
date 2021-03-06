package com.thoughtworks.common;

import com.thoughtworks.error.PaymentErrorResponse;
import com.thoughtworks.payment.BeneficiaryAccountDetailsNotFound;
import com.thoughtworks.payment.PayeeAccountDetailsNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionMessageHandler {

    @ExceptionHandler(BeneficiaryAccountDetailsNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    protected PaymentErrorResponse InvalidBeneficiaryAccount(BeneficiaryAccountDetailsNotFound ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getKey(), ex.getValue());
        return new PaymentErrorResponse("PAYMENT_FAILED",errors);
    }

    @ExceptionHandler(PayeeAccountDetailsNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    protected PaymentErrorResponse InvalidPayeeAccount(PayeeAccountDetailsNotFound ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getKey(), ex.getValue());
        return new PaymentErrorResponse("PAYMENT_FAILED",errors);
    }

}

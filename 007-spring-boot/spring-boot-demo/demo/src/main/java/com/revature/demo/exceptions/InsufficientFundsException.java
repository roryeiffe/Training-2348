package com.revature.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Trying to give more money than you have")
public class InsufficientFundsException extends Exception{
}

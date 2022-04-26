package com.prismaticsoftware.leavemanagementsystem.exception;

/**
 * Purpose : To demonstrate the message shown through CustomException if it is occurred
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
public class NoDataFoundException extends  RuntimeException{
    /**
     * Purpose : This method is used to define the message used to throw during exception
     *
     * @param message defines the exception message
     */
    public NoDataFoundException(String message){
        super(message);
    }
}

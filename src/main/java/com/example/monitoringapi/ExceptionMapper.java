//package com.example.monitoringapi;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//class RestError{
//    String message;
//    int code;
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//}
//
//@ControllerAdvice
//public class ExceptionMapper {
//    @ExceptionHandler(Throwable.class)
//    @ResponseBody
//    ResponseEntity<?> handleThrowable(HttpServletRequest request, HttpServletResponse response, Throwable t)
//    {
//
//        RestError restError = new RestError();
//        restError.setMessage(t.getMessage());
//        return new ResponseEntity<>(restError,HttpStatus.INTERNAL_SERVER_ERROR);
//
////        return new ResponseEntity<>(restError, HttpStatus.valueOf(errorTo.getStatus()));
//    }
//}


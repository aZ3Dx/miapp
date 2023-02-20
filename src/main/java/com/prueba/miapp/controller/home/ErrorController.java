package com.prueba.miapp.controller.home;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.prueba.miapp.config.CustomException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = { Exception.class })
    public ModelAndView handleAllExceptions(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errorMessage", "Ha ocurrido un error en la aplicación: " + ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = { CustomException.class })
    public ModelAndView handleCustomException(CustomException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

}

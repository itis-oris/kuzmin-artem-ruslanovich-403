package ru.itis.handler;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import ru.itis.handler.exception.AppException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(AppException.class)
    public String handlerAppException(AppException ex,
                                      HttpServletResponse response,
                                      Model model) {

        log.error("exception occurred: {}", ex.getMessage(), ex);
        response.setStatus(ex.getStatus().value());
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", ex.getStatus().value());
        return "error";
    }


    @ExceptionHandler(Exception.class)
    public String handleException(
            Model model,
            HttpServletResponse response
    ) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("message", "Внутренняя ошибка сервера");
        model.addAttribute("status", 500);
        return "error";
    }
}

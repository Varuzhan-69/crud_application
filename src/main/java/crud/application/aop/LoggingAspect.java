package crud.application.aop;


import crud.application.model.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* crud.application.service.UserService.save(..)) && args(user)")
    public void saveOperation(User user) {}

    @Pointcut("execution(* crud.application.service.UserService.update(..)) && args(id, user)")
    public void updateOperation(int id, User user) {}

    @Pointcut("execution(* crud.application.service.UserService.delete(..)) && args(id)")
    public void deleteOperation(int id) {}

    @After("saveOperation(user)")
    public void logAfterSave(User user) {
        logger.info("Пользователь " + user + " создан");
    }

    @After("updateOperation(id, user)")
    public void logAfterUpdate(int id, User user) {
        logger.info("Пользователь " + user +" изменен");
    }

    @After("deleteOperation(id)")
    public void logAfterDelete(int id) {
        logger.info("Пользователь c ID "+ id + " удален");
    }

    @Before("saveOperation(user)")
    public void logBeforeSave(User user) {
        logger.info("Попытка создать пользователя: " + user );
    }

    @Before("updateOperation(id, user)")
    public void logBeforeUpdate(int id, User user) {
        logger.info("Попытка изменить пользователя: " + user);
    }

    @Before("deleteOperation(id)")
    public void logBeforeDelete(int id) {
        logger.info("Попытка удалить пользователя c ID: " + id);
    }
}

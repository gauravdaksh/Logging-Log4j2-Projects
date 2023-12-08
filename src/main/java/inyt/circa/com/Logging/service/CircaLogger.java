package inyt.circa.com.Logging.service;


import org.springframework.stereotype.Service;

@Service
public interface CircaLogger {

   //public CircaLogManager getLogger(Class<?> clazz);

    public void debug(String message);

    public void info(String message);

    public void warn(String message);

    public void error(String message);

    public void error(String message, Throwable throwable);

    public void logWithUUID(String message);

    public void logWithCorrelationId(String correlationId, String message);


}

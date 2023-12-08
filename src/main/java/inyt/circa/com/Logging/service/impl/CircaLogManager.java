package inyt.circa.com.Logging.service.impl;

import inyt.circa.com.Logging.service.CircaLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class CircaLogManager implements CircaLogger {

    private Logger logger;

    public CircaLogManager() {
    }
    public CircaLogManager(Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);

       /* ConfigurationBuilder<BuiltConfiguration> builder
                = ConfigurationBuilderFactory.newConfigurationBuilder();
        AppenderComponentBuilder file
                = builder.newAppender("log", "File");
        file.addAttribute("fileName", "logs/logging.log");

        builder.add(file);*/
    }

     public static CircaLogManager getLogger(Class<?> clazz) {
        return new CircaLogManager(clazz);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public void logWithUUID(String message) {
        String uuid = UUID.randomUUID().toString();
        ThreadContext.put("uuid", uuid);
        logger.info(message + " (UUID: " + uuid + ")");
        ThreadContext.remove("uuid");
    }

    public void logWithCorrelationId(String correlationId, String message) {
        ThreadContext.put("correlationId", correlationId);
        logger.info(message + " (Correlation ID: " + correlationId + ")");
        ThreadContext.remove("correlationId");
    }

}

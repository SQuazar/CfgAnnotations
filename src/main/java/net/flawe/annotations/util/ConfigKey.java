package net.flawe.annotations.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for creating configuration section
 *
 * @author flaweoff
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ConfigKey {
    /**
     * Gets the configuration section name (key)
     * @return configuration section name (key)
     */
    String value();
}

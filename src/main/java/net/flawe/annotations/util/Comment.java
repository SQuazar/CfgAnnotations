package net.flawe.annotations.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for creating comments above configuration section
 *
 * @author flaweoff
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Comment {
    /**
     * Gets the comments
     * @return comments
     */
    String[] value();
}

package net.flawe.annotations.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for adding indents above configuration section
 *
 * @author flaweoff
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Indent {
    /**
     * Gets the indents count
     * @return indents count
     */
    int value();
}

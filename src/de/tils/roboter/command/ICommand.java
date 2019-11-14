package de.tils.roboter.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface ICommand {

    /**
     *  call if the command execute
     */
    void onExecute(String[] args);


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Info {

        String name();

        String description() default "no description";

    }
}

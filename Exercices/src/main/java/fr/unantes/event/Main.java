package fr.unantes.event;

import java.util.Optional;

/**
 * Created on 02/02/2018.
 *
 * @author sunye.
 */
public class Main {

    public static void main(String[] args) {
        Optional<String> value = Optional.empty();

        if(value.isPresent())

            value.orElse("rien");

        Optional.of("ttt");
        System.out.println(Optional.ofNullable(null).get());
    }
}

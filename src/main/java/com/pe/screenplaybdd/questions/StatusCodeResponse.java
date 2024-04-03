package com.pe.screenplaybdd.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StatusCodeResponse implements Question<Integer> {

    public static Question<Integer> value(){
        return new StatusCodeResponse();
    }

    @Override
    public Integer answeredBy(Actor actor) {

        return SerenityRest.lastResponse().statusCode();
    }
}

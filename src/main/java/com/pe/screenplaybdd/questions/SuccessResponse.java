package com.pe.screenplaybdd.questions;

import com.pe.screenplaybdd.model.UserResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SuccessResponse implements Question<Object> {

    public static Question<Object> is() {
        return new SuccessResponse();
    }

    @Override
    public UserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().as(UserResponse.class);
    }
}

package com.pe.screenplaybdd.questions;

import com.pe.screenplaybdd.endpoints.UserBDDEndpoints;

import com.pe.screenplaybdd.model.User;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.RestQuestionBuilder;

public class TheUser {
    public static Question<String> theValueName(String userName) {

        return new RestQuestionBuilder<String>().about("Get User")
                .to(UserBDDEndpoints.Ob_user.getPath())
                .with(request -> request.given().log().all().pathParam("username", userName))
                .returning(response -> response.then().log().all().extract().path("username"));

    }

    public static Question<String> message(String userName) {

        return new RestQuestionBuilder<String>().about("Cash account balance")
                .to(UserBDDEndpoints.Ob_user.getPath())
                .with(request -> request.given().log().all().pathParam("username", userName))
                .returning(response -> response.then().log().all().extract().path("message"));

    }


}

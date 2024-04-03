package com.pe.screenplaybdd.stepsdefinitions;

import com.pe.screenplaybdd.model.User;
import com.pe.screenplaybdd.model.UserResponse;
import com.pe.screenplaybdd.questions.StatusCodeResponse;
import com.pe.screenplaybdd.questions.TheUser;
import com.pe.screenplaybdd.tasks.CreateUser;
import com.pe.screenplaybdd.tasks.DeleteUser;
import com.pe.screenplaybdd.tasks.UpdateUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.CoreMatchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserManagerStepsDefinitions {
    EnvironmentVariables environmentVariables;
    private User user;
    @Given("^el owner con los siguiente detalles:$")
    public void elOwnerConLosSiguientesDetalles(List<Map<String, String>> listOfData) {
        theActorCalled("owner").whoCan(CallAnApi.at(EnvironmentSpecificConfiguration.
                from(environmentVariables).getProperty("url")));
        Map<String, String> userData = listOfData.get(0);
        user = new User(Integer.parseInt(userData.get("id")), userData.get("username"),
                userData.get("firstName"), userData.get("lastName"), userData.get("email"),
                userData.get("password"), userData.get("phone"), userData.get("userStatus"));
    }
    @When("^el owner registra el usuario$")
    public void elOwnerRegistraElUsuario() {
        theActorInTheSpotlight().attemptsTo(CreateUser.asNewUser(user));
    }
    @Then("^el usuario se debe visualizar en la lista con su nombre (.*)$")
    public void elUsuarioSeDebeVisualizarEnLaListaConSuNombre(String userName) {
        String userRegistred = theActorInTheSpotlight().recall("username");
        theActorInTheSpotlight().should(seeThat(TheUser.theValueName(userRegistred), is(equalTo(userName))));
        theActorInTheSpotlight().should(seeThat(StatusCodeResponse.value(), equalTo(200)));
    }

    @When("^el owner actualiza el usuario (.*)$")
    public void elOwnerActualizaElUsuario(String userUpdate) {
        theActorInTheSpotlight().attemptsTo(UpdateUser.as(user, userUpdate));
    }

    @When("^el owner realiza la eliminación del usuario$")
    public void elOwnerRealizaLaEliminaciónDelUsuario() {
        theActorInTheSpotlight().attemptsTo(DeleteUser.how(user.getUsername()));
    }

    @Then("^el owner obtiene en la busqueda el mensaje (.*)$")
    public void elOwnerObtieneEnLaBusquedaElMensaje(String message) {
        theActorInTheSpotlight().should(seeThat(TheUser.message(user.getUsername()), is(equalTo(message))));
    }
}

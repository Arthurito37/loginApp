package com.exemplo.loginapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.action.ViewActions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
@RunWith(AndroidJUnit4.class)
public class loginTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new
            ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void testSuccessfulLogin() {
// Digita o nome de usuário
        onView(withId(R.id.editTextUsername)).perform(ViewActions.typeText("TesteUsuario")
                , ViewActions.closeSoftKeyboard());
// Digita a senha
        onView(withId(R.id.editTextPassword)).perform(ViewActions.typeText("senha123"),
                ViewActions.closeSoftKeyboard());
// Clica no botão de login
        onView(withId(R.id.buttonLogin)).perform(ViewActions.click());
// Verifica se a mensagem de boas-vindas está visível
        onView(withId(R.id.welcomeMessage)).check(matches(isDisplayed()));
    }
}
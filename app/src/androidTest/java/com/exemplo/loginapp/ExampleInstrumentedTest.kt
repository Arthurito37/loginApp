package com.exemplo.loginapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginTest {
    @Rule
    var activityRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun testSuccessfulLogin() {
// Digita o nome de usuário
        Espresso.onView(withId(R.id.editTextUsername)).perform(
            ViewActions.typeText("TesteUsuario"), ViewActions.closeSoftKeyboard()
        )
        // Digita a senha
        Espresso.onView(withId(R.id.editTextPassword)).perform(
            ViewActions.typeText("senha123"),
            ViewActions.closeSoftKeyboard()
        )
        // Clica no botão de login
        Espresso.onView(withId(R.id.buttonLogin)).perform(ViewActions.click())
        // Verifica se a mensagem de boas-vindas está visível
        Espresso.onView(withId(R.id.welcomeMessage))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
package ru.arizara.password;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    ActivityScenario scenario;

    //создание активности
    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    // @Before - метод всегда запускается перед запуском тестов
    @Before
    public void setUp() {
        scenario = rule.getScenario();
    }

    // @Test - этот метод тест
    @Test
    public void correctPassword(){
        // onView(withId(R.id.*)) - получаем элемент на экране
        // perform() - выполнить действие
        // typeText("123_sddFGHJF") -  установить текст в элемент
        // click() - клик на элемент
        // check(matches()) - проверка содержимого
        // withText("Пароль подходит") - сравнить текст на элементе
        // Espresso.closeSoftKeyboard(); - сокрытие клавиатуры
        onView(withId(R.id.et_password)).perform(typeText("123_sddFGHJF"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_out)).check(matches(withText("Пароль подходит")));
    }
    @Test
    public void incorrectPasswordLength(){
        onView(withId(R.id.et_password)).perform(typeText("123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_out)).check(matches(withText("Пароль менее 6 символов")));
    }
    @Test
    public void incorrectPasswordSymbol(){
        onView(withId(R.id.et_password)).perform(typeText("dfasSDF$123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_out)).check(matches(withText("Пароль содержит неверные символы")));
    }
    @Test
    public void incorrectPasswordContainsDigit(){
        onView(withId(R.id.et_password)).perform(typeText("dfasSDF"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_out)).check(matches(withText("Пароль должен содержать цифры")));
    }
    @Test
    public void incorrectPasswordContainsLetter(){
        onView(withId(R.id.et_password)).perform(typeText("123456789"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_out)).check(matches(withText("Пароль должен содержать буквы")));
    }
    @Test
    public void incorrectPasswordContainsLowLetter(){
        onView(withId(R.id.et_password)).perform(typeText("1234ASDAS"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_out)).check(matches(withText("Пароль должен содержать строчные буквы")));
    }
    @Test
    public void incorrectPasswordContainsUpLetter(){
        onView(withId(R.id.et_password)).perform(typeText("123sdfsdf"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.tv_out)).check(matches(withText("Пароль должен содержать прописные буквы")));
    }
}
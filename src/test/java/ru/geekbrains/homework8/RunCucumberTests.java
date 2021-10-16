package ru.geekbrains.homework8;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/resources/howemork8"},
plugin = {"pretty", "html:target/cucumber/report.html"})
public class RunCucumberTests {
}

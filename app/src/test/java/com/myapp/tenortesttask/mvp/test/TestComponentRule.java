package com.myapp.tenortesttask.mvp.test;

import android.support.annotation.NonNull;

import com.myapp.tenortesttask.app.TenorTestTaskApp;
import com.myapp.tenortesttask.di.AppComponent;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by denishmelinin on 14.03.17.
 */

public class TestComponentRule implements TestRule {

    private AppComponent appComponent;

    public TestComponentRule() {
        appComponent = new TestComponent();
    }

    public TestComponentRule(@NonNull AppComponent component) {
        this.appComponent = component;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                TenorTestTaskApp.setAppComponent(appComponent);
                base.evaluate();
            }
        };
    }
}
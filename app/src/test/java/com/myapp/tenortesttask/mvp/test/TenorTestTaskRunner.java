package com.myapp.tenortesttask.mvp.test;

import android.support.annotation.NonNull;

import com.myapp.tenortesttask.BuildConfig;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Method;

/**
 * Created by denishmelinin on 14.03.17.
 */

public class TenorTestTaskRunner extends RobolectricTestRunner {
    private static final int SDK_EMULATE_LEVEL = 23;

    public TenorTestTaskRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    public Config getConfig(@NonNull Method method) {
        final Config defaultConfig = super.getConfig(method);
        return new Config.Implementation(
                new int[]{SDK_EMULATE_LEVEL},
                defaultConfig.manifest(),
                defaultConfig.qualifiers(),
                defaultConfig.packageName(),
                defaultConfig.resourceDir(),
                defaultConfig.assetDir(),
                defaultConfig.shadows(),
                defaultConfig.instrumentedPackages(),
                defaultConfig.application(),
                defaultConfig.libraries(),
                defaultConfig.constants() == Void.class ? BuildConfig.class : defaultConfig.constants()
        );
    }
}

package com.doghero.runner

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import com.doghero.application.DogHeroApplicationTest

class ApplicationTestRunner : AndroidJUnitRunner() {

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, DogHeroApplicationTest::class.java.name, context)
    }
}
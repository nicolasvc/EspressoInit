package com.example.espressoinit.testsuite

import com.example.espressoinit.testActivity.MainActivityTest
import com.example.espressoinit.testActivity.SecondaryActivityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Para realizar todas las pruebas de multiples clases se debe hacer uso de los decorador Suite
 * */
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondaryActivityTest::class
)
class ActivityTestSuite
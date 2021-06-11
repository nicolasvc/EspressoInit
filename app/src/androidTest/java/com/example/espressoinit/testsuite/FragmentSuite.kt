package com.example.espressoinit.testsuite

import com.example.espressoinit.navigation.NavigationTest
import com.example.espressoinit.testfragment.DirectorsFragmentTest
import com.example.espressoinit.testfragment.MovieDetailFragmentTest
import com.example.espressoinit.testfragment.StarActorsFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieDetailFragmentTest::class,
    DirectorsFragmentTest::class,
    StarActorsFragmentTest::class,
    NavigationTest::class
)
class FragmentSuite
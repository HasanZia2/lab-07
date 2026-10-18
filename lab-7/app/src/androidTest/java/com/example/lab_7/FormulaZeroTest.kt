package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // navigate to driver screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify driver screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Test Name")

        // add driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver appears
        composeTestRule
            .onNodeWithText("Test Name")
            .assertExists()

        // enter second driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Test Name 2")

        // add second driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify second driver appears
        composeTestRule
            .onNodeWithText("Test Name 2")
            .assertExists()

        // clear driver names
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify first driver disappears
        composeTestRule
            .onNodeWithText("Test Name")
            .assertDoesNotExist()

        // verify second driver disappears
        composeTestRule
            .onNodeWithText("Test Name 2")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
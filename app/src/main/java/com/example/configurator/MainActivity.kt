package com.example.configurator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.configurator.ui.theme.ConfiguratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfiguratorTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    // Let the race and type be changeable
    var race by remember { mutableStateOf("-") }
    var type by remember { mutableStateOf("-") }
    // Main column for the application
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.height(40.dp))
        Text(
            text = "Select your class: ",
            modifier = modifier.padding(10.dp)
        )
        // Row of custom buttons, so that they stick when a choice is made
        Row(modifier = modifier) {
            // Each box is for one class. If it's chosen, the type gets set to the proper class and the colors change to show it's the selected class
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small)
                    .clickable {
                        type = "Barbarian"
                    }
                    .background(
                        color = getColor(type, "Barbarian", "background"),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = "Barbarian",
                    color = getColor(type, "Barbarian", "content"),
                    style = LocalTextStyle.current.copy(color = getColor(type, "Barbarian", "content")),
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small)
                    .clickable {
                        type = "Archer"
                    }
                    .background(
                        color = getColor(type, "Archer", "background"),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = "Archer",
                    color = getColor(type, "Archer", "content"),
                    style = LocalTextStyle.current.copy(color = getColor(type, "Archer", "content")),
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small)
                    .clickable {
                        type = "Rogue"
                    }
                    .background(
                        color = getColor(type, "Rogue", "background"),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = "Rogue",
                    color = getColor(type, "Rogue", "content"),
                    style = LocalTextStyle.current.copy(color = getColor(type, "Rogue", "content")),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Spacer(modifier = modifier.height(40.dp))

        Text(
            text = "Select your race: ",
            modifier = modifier.padding(10.dp)
        )
        // Same thing as before, but for race. Custom buttons just like for the class/type
        Row(modifier = modifier) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small)
                    .clickable {
                        race = "Half-Orc"
                    }
                    .background(
                        color = getColor(race, "Half-Orc", "background"),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = "Half-Orc",
                    color = getColor(race, "Half-Orc", "content"),
                    style = LocalTextStyle.current.copy(color = getColor(race, "Half-Orc", "content")),
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small)
                    .clickable {
                        race = "Elf"
                    }
                    .background(
                        color = getColor(race, "Elf", "background"),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = "Elf",
                    color = getColor(race, "Elf", "content"),
                    style = LocalTextStyle.current.copy(color = getColor(race, "Elf", "content")),
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small)
                    .clickable {
                        race = "Human"
                    }
                    .background(
                        color = getColor(race, "Human", "background"),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = "Human",
                    color = getColor(race, "Human", "content"),
                    style = LocalTextStyle.current.copy(color = getColor(race, "Human", "content")),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Spacer(modifier = modifier.height(100.dp))

        // This row will list the stats for the chosen class and race
        Row(modifier = modifier) {
            // One column for all the possible stats
            Column (modifier = modifier, horizontalAlignment = Alignment.Start) {
                Text(text = "Class ----> ", modifier = modifier.padding(10.dp))
                Text(text = "Race ----> ", modifier = modifier.padding(10.dp))
                Text(text = "Health ----> ", modifier = modifier.padding(10.dp))
                Text(text = "Defense ----> ", modifier = modifier.padding(10.dp))
                Text(text = "Weapon 1 ----> ", modifier = modifier.padding(10.dp))
                Text(text = "Weapon 2 ----> ", modifier = modifier.padding(10.dp))
            }
            // This column is for the actual stats. They will change based on the type and race, through a switch
            Column (modifier = modifier, horizontalAlignment = Alignment.End) {
                Text(text = type, modifier = modifier.padding(10.dp))
                Text(text = race, modifier = modifier.padding(10.dp))
                when (race) {
                    "Half-Orc" -> {
                        Text(text = "19", modifier = modifier.padding(10.dp))
                        Text(text = "10", modifier = modifier.padding(10.dp))
                    }
                    "Elf" -> {
                        Text(text = "11", modifier = modifier.padding(10.dp))
                        Text(text = "20", modifier = modifier.padding(10.dp))
                    }
                    "Human" -> {
                        Text(text = "14", modifier = modifier.padding(10.dp))
                        Text(text = "15", modifier = modifier.padding(10.dp))
                    }
                    else -> {
                        Text(text = "-", modifier = modifier.padding(10.dp))
                        Text(text = "-", modifier = modifier.padding(10.dp))
                    }
                }
                when (type) {
                    "Barbarian" -> {
                        Text(text = "Great Mace", modifier = modifier.padding(10.dp))
                        Text(text = "Short sword", modifier = modifier.padding(10.dp))
                    }
                    "Archer" -> {
                        Text(text = "Short bow", modifier = modifier.padding(10.dp))
                        Text(text = "Dagger", modifier = modifier.padding(10.dp))
                    }
                    "Rogue" -> {
                        Text(text = "Daggers", modifier = modifier.padding(10.dp))
                        Text(text = "Throwing stars", modifier = modifier.padding(10.dp))
                    }
                    else -> {
                        Text(text = "-", modifier = modifier.padding(10.dp))
                        Text(text = "-", modifier = modifier.padding(10.dp))
                    }
                }
            }

        }

    }
}

// This function will take the race or type for that button, the current race or type, and the kind of color it needs
@Composable
fun getColor(selected: String, type: String, kind: String): Color {
    // If the race/type for that button is the current race/type, it will be the primary color. Otherwise, it will be another color
    val backgroundColor = if (selected == type) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer
    val contentColor = if (selected == type) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
    // Return the color for either the background or the content
    return if (kind == "background") backgroundColor else contentColor
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun GreetingPreview() {
    ConfiguratorTheme {
        Greeting()
    }
}
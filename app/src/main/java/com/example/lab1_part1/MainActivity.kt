package com.example.lab1_part1

import androidx.compose.ui.res.painterResource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // Import for Column, Spacer, and Arrangement
import androidx.compose.material3.* // Import for MaterialTheme, Button, Scaffold, Text
import androidx.compose.runtime.* // Import for state management (remember, mutableStateOf)
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // Import for unit (dp)
import kotlin.random.Random
import com.example.lab1_part1.ui.theme.Lab1_Part1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1_Part1Theme {
                PortfolioApp()
            }
        }
    }
}
@Composable
fun PortfolioApp() {
    // Define portfolio elements like skills, hobbies, or experience
    val portfolioItems = listOf(
        "I am an Android Developer specializing in Jetpack Compose.",
        "I have experience in building web applications using React.",
        "I love contributing to open-source projects.",
        "I enjoy working with modern backend technologies like Node.js.",
        "I'm passionate about UI/UX design and mobile app development.",
        "I have a strong foundation in Java and Kotlin programming.",
        "I am skilled in database management using MySQL and Firebase.",
        "I have developed and deployed apps to Google Play.",
        "I enjoy learning new technologies like AI and Machine Learning.",
        "I am proficient in Git, Docker, and CI/CD tools."
    )

    // Store the currently displayed portfolio item
    var currentItem by remember { mutableStateOf(portfolioItems[0]) }

    // Define the UI layout with a Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,  // Align items vertically in the center
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            // Image on the left (top-left corner)
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Phoenix Image",
                modifier = Modifier.size(40.dp)  // Size of the image
            )

            Spacer(modifier = Modifier.width(16.dp))  // Add space between image and text

            // Center the heading text
            Text(
                text = "My Portfolio",

                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        // Display the current portfolio item
        Image(
            painter = painterResource(id = R.drawable.lakshmiprofile),
            contentDescription = "My profile Image",  // Accessible description for screen readers
            modifier = Modifier.size(200.dp)  // Set the size of the image
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = currentItem,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to show the next random portfolio item
        Button(onClick = {
            currentItem = portfolioItems[Random.nextInt(portfolioItems.size)]
        }) {
            Text(text = "Skill Summary")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PortfolioApp()
}
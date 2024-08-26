package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFF4CAF50)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.name), fontSize = 28.sp
        )
        Text(
            text = stringResource(id = R.string.profession), fontSize = 10.sp, color = Color(
                0xFF004C00
            )
        )
        // Footer Content

        Column(
            modifier = Modifier.padding(top = 300.dp)
        ) {
            AddPhoneDetails()
            AddShareDetails()
            AddMailDetails()
        }
    }
}

@Composable
fun AddPhoneDetails() {
    Row(
        verticalAlignment = Alignment.CenterVertically //puts icon and text on the same line
    ) {
        Icon(
            imageVector = Icons.Filled.Phone,
            contentDescription = "Phone Icon",
            modifier = Modifier
                .size(20.dp) // Adjust size of the icon
                .padding(end = 8.dp) // Space between icon and text
            ,
            tint = Color(0xFF00FF00)
        )
        Text(
            text = stringResource(id = R.string.phone), fontSize = 10.sp
        )
    }
}

@Composable
fun AddShareDetails() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = "Share Icon",
            modifier = Modifier
                .size(20.dp) // Adjust size of the icon
                .padding(end = 8.dp) // Space between icon and text
            ,
            tint = Color(0xFF00FF00)
        )
        Text(
            text = stringResource(id = R.string.handle), fontSize = 10.sp
        )
    }
}

@Composable
fun AddMailDetails() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Filled.Email,
            contentDescription = "Email Icon",
            modifier = Modifier
                .size(20.dp) // Adjust size of the icon
                .padding(end = 8.dp), // Space between icon and text
            tint = Color(0xFF00FF00)
        )
        Text(
            text = stringResource(id = R.string.email), fontSize = 10.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}

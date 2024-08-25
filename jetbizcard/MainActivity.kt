package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme
import androidx.compose.material3.HorizontalDivider as HorizontalDivider1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                CreateBizCard()
            }
        }
    }
}

@Composable
fun CreateBizCard() {

    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp) // here width and height makes no difference
                .height(12.dp) // it takes dimensions frm parent itself
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile(modifier = Modifier.size(135.dp))
                HorizontalDivider1(
                    thickness = 2.dp, color = MaterialTheme.colorScheme.secondary
                )
                CreateInfo()
                CreatePortfolioButton(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                })
                if (buttonClickedState.value) Content() else Box() {}
            }
        }
    }
}


@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Miles P.", style = MaterialTheme.typography.titleLarge, color = Color.Blue
        )
        Text(
            text = "Andoird Compose Programmer", modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@themilesCompose", modifier = Modifier.padding(3.dp)
        )
    }

}

@Composable
fun CreatePortfolioButton(onClick: () -> Unit) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(text = "Portfolio")
    }
}

@Composable
fun Content() {
    Box(
        modifier = Modifier.padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White) // Apply white background to the Card
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(item)
                        Text("A great project", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
    }
}

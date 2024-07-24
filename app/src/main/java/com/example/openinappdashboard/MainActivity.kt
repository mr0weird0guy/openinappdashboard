package com.example.openinappdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappdashboard.ui.theme.Blue40
import com.example.openinappdashboard.ui.theme.Blue80
import com.example.openinappdashboard.ui.theme.fontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dashboard()
        }
    }
}

@Composable
fun NavBar() {
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .padding(20.dp, 35.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text="Dashboard", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.White)
        Button(onClick = { OpenSettings() }, modifier = Modifier
            .size(50.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(0x1FFFFFFF)), colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)){
            Icon(
                painter = painterResource(id = R.drawable.wrench),
                contentDescription ="settings",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun Greetings(greet: String, name: String){
    Column(modifier = Modifier.padding(24.dp)){
        Text(text = greet, style = MaterialTheme.typography.bodyLarge, fontSize = 16.sp, fontWeight = FontWeight.W300, color = Color(0xFF999CA0))
        Text(text = "$name 👋🏻", style = MaterialTheme.typography.bodyLarge, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Body() {
    Column(modifier = Modifier
        .padding(top = 100.dp)
        .fillMaxSize()
        .background(
            color = Color(0xFFF5F5F5),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ),)
    {
        Greetings(greet = "Good Morning", name = "Rohan")
        Chart()
        InfoBlockRow()
        Button(onClick = {  }, shape = RoundedCornerShape(6.dp), modifier = Modifier
            .padding(16.dp)
            .height(48.dp), colors = ButtonDefaults.buttonColors(Color.Transparent), border = BorderStroke(1.dp, Color(0xFFD8D8D8))) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Icon(
                    painter = painterResource(R.drawable.arrows),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "Arrow",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "View Analytics",
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
        ChipContentFilter()
    }
}

@Composable
fun Chart(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(horizontal = 24.dp)){

    }
}

@Composable
fun InfoBlockRow(){
    Row(modifier = Modifier
        .padding(20.dp)) {
        InfoBlock(
            R.drawable.mouse_clicks,
            Color(0xFF5C33CF),
            Color(0x1F5C33CF),
            "123",
            "Today's Clicks")
        InfoBlock(R.drawable.pin, Color(0xFF0E6FFF), Color(0x1F0E6FFF), "Ahamedabad", "Top Location")
        InfoBlock(R.drawable.globe, Color(0xFFFF4E64), Color(0x1FFF4E64), "Instagram", "Top Sources")
        InfoBlock(R.drawable.time, Color(0xFFFFB319), Color(0x1FFFB319), "11:00 - 12:00", "Best Time")
    }
}

@Composable
fun InfoBlock(iconId: Int, color: Color, bgColor: Color, data: String, description: String){
    Card(modifier = Modifier
        .size(120.dp)
        .horizontalScroll(rememberScrollState())
        .padding(end = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8)){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .width(86.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Card(shape = RoundedCornerShape(50), modifier = Modifier.size(32.dp), colors = CardDefaults.cardColors(containerColor = bgColor),){
                Icon(painter = painterResource(id = iconId), contentDescription = "iconId", tint = color, modifier = Modifier
                    .padding(6.dp)
                    .size(20.dp))
            }
            Text(text = data, fontWeight = FontWeight.Bold, fontFamily= fontFamily, fontSize = 16.sp,  overflow = TextOverflow.Ellipsis, maxLines = 1)
            Text(text = description, fontWeight = FontWeight.W300, fontFamily= fontFamily, fontSize = 14.sp)
        }
    }
}

@Composable
fun ChipContentFilter() {
    Column {
        ChipBoxHead()

    }
}

@Composable
fun ChipBoxHead() {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)){
        ControllerChip(action = chipClick(true), "Top Links")
        Spacer(modifier = Modifier.width(10.dp))
        ControllerChip(action = chipClick(false), text = "Top Sources")
        Button(onClick = { OpenSettings() }, modifier = Modifier
            .size(50.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(0x1FFFFFFF)), colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)){
            Icon(
                painter = painterResource(id = R.drawable.wrench),
                contentDescription ="settings",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

var chipColors = Color.Transparent

fun chipClick(enabled: Boolean) {
    if (enabled) {
        chipColors = Blue40
    }
    else {
        chipColors = Color.Transparent
    }
}

@Composable
fun ControllerChip(action: Unit, text: String) {
    var textCol = Color(0xFF999CA0)
    if (chipColors== Blue40){
        textCol = Color.White
    }
    SuggestionChip(onClick = { action },
        label = { Text(text = text, color = textCol) },
        shape = RoundedCornerShape(50),
        border = BorderStroke(0.dp, Color.Transparent),
        colors = SuggestionChipDefaults.suggestionChipColors(chipColors))
}


fun OpenSettings() {}

@Preview(showBackground = true)
@Composable
fun Dashboard() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Blue80)){
        NavBar()
        Body()
    }
}
/*
Date: Tuesday 18th October 2022, 16:28 PT
Programmer: Anne Dawson
Email: anne.dawson@gmail.com
Codelab title: Practice: Compose Basics
Status: Completed
 */

package net.annedawson.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.TypedArrayUtils.getString
import net.annedawson.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Article(stringResource(R.string.title_string), stringResource(R.string.paragraph1_string),
            stringResource(R.string.paragraph2_string)
        )
}

@Composable
fun Article(title: String, paragraph1: String, paragraph2: String) {

    val image = painterResource(R.drawable.bg_compose_background)
    // https://youtu.be/8f_R6RH4sgw
    // note on the video at 5:45, he uses the following equivalent line:
    // val image = painterResource(id = R.drawable.gin)

    Column() {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                //.fillMaxHeight()
                .fillMaxWidth(),
            //contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)

        )
        Text(
            text = paragraph1,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                //.fillMaxWidth()
                //.wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)

        )
        Text(
            text = paragraph2,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                //.fillMaxWidth()
                //.wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        MyApp()
    }
}
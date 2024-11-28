package com.kodiiiofc.urbanuniversity.jetpackcompose.annotatedstring

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.UrlAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kodiiiofc.urbanuniversity.jetpackcompose.annotatedstring.ui.theme.AnnotatedStringTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnnotatedStringTheme {

                val linkAnnotation = LinkAnnotation.Clickable(
                    tag = "next_page",
                    styles = null
                ) {
                    val intent = Intent(this, NextPage::class.java)
                    startActivity(intent)
                }

                Text(
                    buildAnnotatedString {
                        append("Go to the ")

                        withLink(
                            link = linkAnnotation
                        ) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 40.sp,
                                    textDecoration = TextDecoration.Underline,
                                )
                            ) {
                                append("next")
                            }
                        }

                        append(" page")

                    },
                    fontSize = 32.sp
                )


            }
        }
    }
}

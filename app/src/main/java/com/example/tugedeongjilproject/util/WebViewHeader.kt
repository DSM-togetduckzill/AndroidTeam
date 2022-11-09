package com.example.tugedeongjilproject.util

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugedeongjilproject.R

internal val notoSansFamily = FontFamily(
    Font(R.font.notosanskr_bold, FontWeight.Bold),
)

object HeaderColor {
    val Black = Color(0xFF000000)
    val BackGround = Color(0xFFFFF1E3)
}

@Stable
private val headerStyle = TextStyle(
    fontFamily = notoSansFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp
)

@Stable
private val HeaderHeight: Dp = 50.dp

@Composable
fun WebViewHeader(
    btnBack: Boolean,
    onBackPressed: () -> Unit,
    headerText: String,
    btnMenu: Boolean,
    onMenuPressed: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(HeaderHeight)
            .background(
                color = HeaderColor.BackGround
            )
    ){
        if(btnBack){
            IconButton(
                onClick = onBackPressed,
            ) {
                Icon(
                    painter = painterResource(id = HeaderIcon.Back.drawableId),
                    contentDescription = HeaderIcon.Back.contentDescription
                )
            }
        }else{
            Spacer(modifier = Modifier.width(16.dp))
        }

        Text(
            text = headerText,
            color = HeaderColor.Black,
            style = headerStyle
        )

        if(btnMenu){
            IconButton(
                onClick = onMenuPressed,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            ) {
                Icon(
                    painter = painterResource(id = HeaderIcon.Menu.drawableId),
                    contentDescription = HeaderIcon.Menu.contentDescription
                )
            }
        }
    }
}



@Immutable
class HeaderIcon private constructor(
    @DrawableRes val drawableId: Int,
    val contentDescription: String? = null,
) {
    companion object {
        @Stable
        val Back = HeaderIcon(
            drawableId = R.drawable.ic_back_gray,
            contentDescription = "header icon back gray"
        )

        @Stable
        val Menu = HeaderIcon(
            drawableId = R.drawable.ic_menu,
            contentDescription = "header icon menu black"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ShowWebViewHeader(){
    WebViewHeader(btnBack = true, onBackPressed = {}, headerText = "채팅", btnMenu = true)
}
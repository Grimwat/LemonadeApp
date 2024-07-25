package com.example.lemonade.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.R

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
    ) {
    Box(modifier = modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
            ){
                    Image(
                        painter = painterResource(drawableResourceId),
                        contentDescription = stringResource(contentDescriptionResourceId),
                        modifier = modifier)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
            
        }
    }
}
@Composable
fun LemonApp(){
    var currentstep by remember { mutableStateOf(1) }
    var squeezecount by remember { mutableStateOf(0) }

    when (currentstep) {
        1 ->{
            LemonTextAndImage(
                textLabelResourceId = R.string.Tree,
                drawableResourceId = R.drawable.lemon_tree,
                contentDescriptionResourceId = R.string.Lemon_tree ,
                onImageClick = {
                    currentstep = 2
                    squeezecount = (2..4).random()
                })
        }
        2 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.Squeeze,
                drawableResourceId = R.drawable.lemon_squeeze,
                contentDescriptionResourceId = R.string.Lemon ,
                onImageClick = {
                    squeezecount --
                    if (squeezecount == 0 ){
                    currentstep = 3 }
                })
        }
        3 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.Lemonade,
                drawableResourceId = R.drawable.lemon_drink,
                contentDescriptionResourceId = R.string.Drink,
                onImageClick = {
                    currentstep = 4
                })
        }
        4 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.Glass,
                drawableResourceId = R.drawable.lemon_restart,
                contentDescriptionResourceId = R.string.Empty_glass,
                onImageClick = {
                    currentstep = 1
                })

        }
    }

}
@Preview
@Composable
fun ImageAndTextPreview(
){

}
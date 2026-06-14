package com.example.datingapp.screens.feed

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SwipeCard(
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    val offsetX = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope ()

    val swipeThreshold = 300f

    Box(
        modifier = modifier
            .offset { IntOffset(offsetX.value.roundToInt(),0)}
            .rotate(offsetX.value / 40f)
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragEnd = {
                        coroutineScope.launch {
                            when {
                                offsetX.value > swipeThreshold -> {
                                    offsetX.animateTo(
                                        targetValue = 1200f,
                                        animationSpec = tween(300)
                                    )
                                    onSwipeRight()
                                    offsetX.snapTo(0f)
                                }

                                offsetX.value < -swipeThreshold -> {
                                    offsetX.animateTo(
                                        targetValue = -1200f,
                                        animationSpec = tween(300)
                                    )
                                    onSwipeLeft()
                                    offsetX.snapTo(0f)
                                }

                                else -> {
                                    offsetX.animateTo(
                                        targetValue = 0f,
                                        animationSpec = spring()
                                    )
                                }
                            }
                        }
                    },
                    onHorizontalDrag = { _, dragAmount ->
                        coroutineScope.launch {
                            offsetX.snapTo(offsetX.value + dragAmount)
                        }
                    }
                )
            }
    ){
        content()
        SwipeOverlay(offsetX = offsetX.value)
    }
}
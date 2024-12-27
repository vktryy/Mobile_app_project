package ru.project_final.saturday10.presentation.details.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ramcosta.composedestinations.annotation.Destination
import ru.project_final.saturday10.data.models.UserModel

@OptIn(ExperimentalGlideComposeApi::class)
@Destination
@Composable
fun DetailsScreenContent(
  userModel: UserModel,
) {
  Column {
    Text("Name: ${userModel.login}", fontSize = 30.sp, fontFamily = FontFamily.Cursive)
    Text("Photo:", fontSize = 24.sp, fontFamily = FontFamily.Cursive)
    GlideImage(
      model = userModel.imageUrl,
      contentDescription = null,
      modifier = Modifier
        .height(200.dp)
        .width(200.dp)
    )
    Text(
      "Описание: привет , мне ${userModel.age} лет, мне нравятся такие люди как меган фокс и путин , если ты меган фокс напиши мне !!",
      fontSize = 20.sp,
      fontFamily = FontFamily.Cursive
    )

    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Button(
        modifier = Modifier.padding(start = 14.dp),
        onClick = {}
      ) {
        Text("Like")
      }
      Button(
        modifier = Modifier.padding(start = 14.dp)
          .offset(x=30.dp),
        onClick = {}
      ) {
        Text("Dislike")
      }
    }
  }
}
package ru.project_final.saturday10.presentation.details.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Text("Name: ${userModel.login}", fontSize = 30.sp)
    Text("Photo:", fontSize = 24.sp)
    GlideImage(
      model = userModel.imageUrl,
      contentDescription = null,
    )
    Text(
      "Description: привет , мне ${userModel.age} лет, мне нравятся такие люди как меган фокс и путин , если ты меган фокс напиши мне !!",
      fontSize = 24.sp
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
        modifier = Modifier.padding(end = 14.dp),
        onClick = {}
      ) {
        Text("Dislike")
      }
    }
  }
}
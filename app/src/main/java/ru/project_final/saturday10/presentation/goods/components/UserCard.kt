package ru.project_final.saturday10.presentation.goods.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.project_final.saturday10.data.models.UserModel
import ru.project_final.saturday10.presentation.goods.contract.UserEvent

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserCard(
  userModel: UserModel,
  onEvent: (UserEvent) -> Unit,
) {
  ElevatedCard(
    modifier = Modifier
      .height(420.dp)
      .width(300.dp)
  ) {

    GlideImage(
      model = userModel.imageUrl,
      contentDescription = null,
      modifier = Modifier
        .height(300.dp)
        .width(300.dp)
    )
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth(),
        text = userModel.login,
        fontSize = 24.sp
      )
    }
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {

      Button(
        modifier = Modifier.padding(start = 14.dp),
        onClick = {
          onEvent(UserEvent.OnUserItemClick(userModel))
        }
      ) {
        Text("More info")
      }
    }
    Spacer(modifier = Modifier.padding(6.dp))
  }
  Spacer(modifier = Modifier.padding(10.dp))
}
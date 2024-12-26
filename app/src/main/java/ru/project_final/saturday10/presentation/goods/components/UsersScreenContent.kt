package ru.project_final.saturday10.presentation.goods.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.project_final.saturday10.presentation.goods.contract.UserEvent
import ru.project_final.saturday10.presentation.goods.contract.UserState

@Composable
fun GoodsScreenContent(
  uiState: UserState,
  onEvent: (UserEvent) -> Unit,
) {
  Column {
    Column(
      modifier = Modifier.fillMaxWidth(),
    ) {
      Button(
        modifier = Modifier.padding(start = 14.dp),
        onClick = {
          onEvent(UserEvent.AddButtonClicked)
        }) {
        Text(text = "See people")
      }
    }

    LazyColumn {
      uiState.users.forEach { item ->
        item {
          UserCard(item, onEvent)
        }
      }
    }
  }
}
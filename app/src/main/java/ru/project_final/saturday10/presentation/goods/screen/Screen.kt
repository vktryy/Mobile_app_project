package ru.project_final.saturday10.presentation.goods.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest
import ru.project_final.saturday10.presentation.destinations.DetailsScreenContentDestination
import ru.project_final.saturday10.presentation.goods.components.GoodsScreenContent
import ru.project_final.saturday10.presentation.goods.contract.UserEffect.OpenDetails
import ru.project_final.saturday10.presentation.goods.viewmodels.ViewModel

@Destination(start = true)
@Composable
fun GoodsScreen(
  navigator: DestinationsNavigator,
) {

  val viewModel = viewModel<ViewModel>()

  val state by viewModel.state.collectAsState()

  GoodsScreenContent(
    uiState = state,
    onEvent = viewModel::handleEvent
  )

  LaunchedEffect(viewModel.effect) {
    viewModel.effect.collectLatest { effect ->
      when (effect) {
        is OpenDetails -> {
          navigator.navigate(DetailsScreenContentDestination(userModel = effect.item))
        }
      }
    }
  }
}
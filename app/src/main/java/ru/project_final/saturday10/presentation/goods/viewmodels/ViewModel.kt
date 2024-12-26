package ru.project_final.saturday10.presentation.goods.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.project_final.saturday10.App
import ru.project_final.saturday10.data.api.ApiExample
import ru.project_final.saturday10.data.models.UserModel
import ru.project_final.saturday10.presentation.goods.contract.UserEffect
import ru.project_final.saturday10.presentation.goods.contract.UserEvent
import ru.project_final.saturday10.presentation.goods.contract.UserEvent.AddButtonClicked
import ru.project_final.saturday10.presentation.goods.contract.UserEvent.OnUserItemClick
import ru.project_final.saturday10.presentation.goods.contract.UserEvent.UpdateUserTextField
import ru.project_final.saturday10.presentation.goods.contract.UserEvent.UpdateUserUrlField
import ru.project_final.saturday10.presentation.goods.contract.UserState


class ViewModel : ViewModel() {

  val state = MutableStateFlow(UserState())

  private val _effect = Channel<UserEffect>()
  val effect = _effect.receiveAsFlow()

  private fun getClient(): ApiExample {
    val httpClient = Builder()
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    httpClient.addInterceptor(logging)
    val retrofit = Retrofit.Builder()
      .baseUrl("https://api.github.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClient.build())
      .build()

    return retrofit.create(ApiExample::class.java)
  }

  fun handleEvent(event: UserEvent) {
    when (event) {
      is UpdateUserTextField -> {
        state.value = state.value.copy(userName = event.text)
      }

      is OnUserItemClick -> {
        viewModelScope.launch {
          _effect.send(UserEffect.OpenDetails(event.user))
        }
      }

      AddButtonClicked -> {
        App.getDatabase()?.clearAllTables()
        val client = getClient()

        viewModelScope.launch {
          try {
            App.getDatabase()?.userDao()?.let { dao ->
              val users = client.getUsers()

              state.value = state.value.copy(
                users = users.map {
                  UserModel(
                    id = it.id,
                    login = it.login,
                    imageUrl = it.imageUrl,
                    age = it.age
                  )
                },
                userName = ""
              )
            }
          } catch (e: Exception) {
            e.printStackTrace()
          }
        }
      }

      is UpdateUserUrlField -> {
        state.value = state.value.copy(userUrl = event.url)
      }
    }
  }
}
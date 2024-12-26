package ru.project_final.saturday10.presentation.goods.contract

import ru.project_final.saturday10.data.models.UserModel

sealed class UserEvent {

  data class UpdateUserTextField(val text: String): UserEvent()
  data class UpdateUserUrlField(val url: String): UserEvent()
  data class OnUserItemClick(val user: UserModel): UserEvent()
  data object AddButtonClicked: UserEvent()
}
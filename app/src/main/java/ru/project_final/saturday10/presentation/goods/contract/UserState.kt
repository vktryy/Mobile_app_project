package ru.project_final.saturday10.presentation.goods.contract

import ru.project_final.saturday10.data.models.UserModel

data class UserState(
  val userName: String = "",
  val userUrl: String = "",
  val users: List<UserModel> = emptyList()
)
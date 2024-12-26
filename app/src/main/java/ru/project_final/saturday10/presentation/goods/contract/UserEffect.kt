package ru.project_final.saturday10.presentation.goods.contract

import ru.project_final.saturday10.data.models.UserModel

sealed interface UserEffect {

  data class OpenDetails(val item: UserModel): UserEffect
}
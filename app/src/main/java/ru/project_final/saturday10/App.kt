package ru.project_final.saturday10

import android.app.Application
import androidx.room.Room
import ru.project_final.saturday10.data.db.UsersDatabase


class App : Application() {
  override fun onCreate() {
    super.onCreate()
    db = Room.databaseBuilder(
      applicationContext,
      UsersDatabase::class.java,
      "user-db"
    )
      .allowMainThreadQueries()
      .build()
  }

  companion object {
    var db: UsersDatabase? = null
    fun getDatabase(): UsersDatabase? {
      return db
    }
  }
}
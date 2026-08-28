package com.odc.finalapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.odc.finalapp.Model.Produit
import com.odc.finalapp.Model.Livraison

@Database(
    entities = [Produit::class, Livraison::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun produitDao(): ProduitDao
    abstract fun livraisonDao(): LivraisonDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "finalapp_database"
                )
                .fallbackToDestructiveMigration()
                .build()

                INSTANCE = instance

                instance
            }
        }
    }
}

package com.vimal.comic.datasources

import com.vimal.comic.repositories.SplashRepository
import javax.inject.Inject

class SplashDataSource @Inject constructor():SplashRepository {
    override fun getWaiting(): Long {
        return 3*1000
    }
}
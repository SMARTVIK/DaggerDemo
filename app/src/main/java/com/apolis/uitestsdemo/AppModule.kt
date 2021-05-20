package com.apolis.uitestsdemo

import dagger.Module
import dagger.Provides

@Module
class AppModule {


    @Provides
    fun getRandomString() : String {
        return "This is supplied from module"
    }


    @Provides
    fun getRepoInstance() : Repo {
        return Repo()
    }


}
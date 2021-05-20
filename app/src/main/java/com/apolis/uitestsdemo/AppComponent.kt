package com.apolis.uitestsdemo

import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(repo: Repo)
}
package com.apolis.uitestsdemo

import javax.inject.Inject

class Repo {

    @Inject
    lateinit var string: String

    init {
        DaggerAppComponent.builder().build().inject(this)
    }



}
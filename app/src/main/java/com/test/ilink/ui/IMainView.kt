package com.test.ilink.ui

interface IMainView {
    fun loadImage(url: String)
    fun showErrorMessage()
    fun setProgressVisibility(value: Int)
}
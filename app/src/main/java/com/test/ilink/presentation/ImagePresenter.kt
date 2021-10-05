package com.test.ilink.presentation

import android.view.View
import com.test.ilink.data.repository.ImageRepository
import com.test.ilink.ui.IMainView
import io.reactivex.disposables.CompositeDisposable

class ImagePresenter(private val view: IMainView) {
    private val composite = CompositeDisposable()

    fun onShowCatClick() {
        composite.add(ImageRepository.fetchCatUrl()
            .doOnSubscribe {
                view.setProgressVisibility(View.VISIBLE)
            }
            .doAfterTerminate {
                view.setProgressVisibility(View.INVISIBLE)
            }
            .subscribe({ url ->
                view.loadImage(url)
            }, {
                view.showErrorMessage()
            })
        )
    }

    fun onShowDuckClick() {
        composite.add(ImageRepository.fetchDuckUrl()
            .doOnSubscribe {
                view.setProgressVisibility(View.VISIBLE)
            }
            .doAfterTerminate {
                view.setProgressVisibility(View.INVISIBLE)
            }
            .subscribe({ url ->
                view.loadImage(url)
            }, {
                view.showErrorMessage()
            })
        )
    }

    fun onDestroy() {
        composite.dispose()
    }
}
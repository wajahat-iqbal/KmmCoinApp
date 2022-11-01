package com.example.kmmcoinapp

import com.example.kmmcoinapp.presentation.home.GetAllCoinsViewModel
import org.koin.dsl.module
import io.ktor.client.engine.android.*
import org.koin.androidx.viewmodel.dsl.viewModel

//class AndroidPlatform : Platform {
//    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
//}
//
//actual fun getPlatform(): Platform = AndroidPlatform()


actual fun platformModule() = module {


    single {
        Android.create()
    }
    /**
     *
     * for android koin has a special viewmodel scope that we can use
     * to create a viewmodel
     *
     */
    /**
     *
     * for android koin has a special viewmodel scope that we can use
     * to create a viewmodel
     *
     */

    viewModel {
        GetAllCoinsViewModel(
            get()
        )
    }
}

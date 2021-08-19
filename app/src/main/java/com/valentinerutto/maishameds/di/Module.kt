package com.valentinerutto.maishameds.di

import com.valentinerutto.maishameds.data.PostsRepository
import com.valentinerutto.maishameds.network.ApiService
import com.valentinerutto.maishameds.ui.viewmodel.PostsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), BASE_URL) }
    single { provideApiService(get()) }
}

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

val viewModelModule = module {
    viewModel {
        PostsViewModel(get())
    }
}
val repoModule = module {
    single {
        PostsRepository(get())
    }
}
val koinModules = listOf(viewModelModule, appModule, repoModule)

package ed.maevski.imdb.di.modules

import dagger.Module
import dagger.Provides
import ed.maevski.imdb.data.api.OttApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RemoteModule {
    @Provides
    @Singleton
    fun provideTestOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        //Настраиваем таймауты для медленного интернета
        .callTimeout(HALF_MINUTE_FOR_SLOW_INTERNET, TimeUnit.SECONDS)
        .readTimeout(HALF_MINUTE_FOR_SLOW_INTERNET, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BASIC
//                level = HttpLoggingInterceptor.Level.HEADERS
            level = HttpLoggingInterceptor.Level.BODY

        })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        //Указываем базовый URL из констант
        .baseUrl(BASE_URL)
        //Добавляем конвертер
        .addConverterFactory(GsonConverterFactory.create())
        //Добавляем кастомный клиент
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideMaiboApi(retrofit: Retrofit): OttApi = retrofit.create(OttApi ::class.java)

    companion object {
        private const val HALF_MINUTE_FOR_SLOW_INTERNET = 30L
        const val BASE_URL = "https://ott-details.p.rapidapi.com/"
    }
}
package com.example.androidstudy.ui.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.androidstudy.databinding.FragmentTestBinding
import com.example.androidstudy.ui.presentation.view_models.TestViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding

    private val viewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        multiThreading()
    }

    private fun multiThreading(){
        coroutinesFunction()
    }

    private fun coroutinesFunction() =
        viewModel.viewModelScope.launch {
            Log.d("TEST_ANDROID", "Start work with downloading files")
            Log.d("TEST_ANDROID", "Downloading files by launch")
            downloadFiveFilesLaunched()
            Log.d("TEST_ANDROID", "Downloading files by async")
            downloadFiveFilesAsync()
            Log.d("TEST_ANDROID", "All uploaded!")
        }

    private suspend fun downloadFiveFilesLaunched() = withContext(IO) {
        coroutineScope {

           launch { downloadFirstFile() }
           launch { downloadSecondFile() }
            launch { downloadThirdFile() }
            launch { downloadForthFile() }
            launch { downloadFifthFile() }
           canselOrJoin()
        }
    }

    private suspend fun downloadFiveFilesAsync() = withContext(IO) {
        coroutineScope {

            val result1 = async { downloadSixthFile() }
            val result2 = launch { downloadSeventhFile() }
            val result3 = launch { downloadEighthFile() }
            val result4 = launch { downloadNinthFile() }
            val result5 = launch { downloadTenthFile() }
            canselOrJoin()
        }
    }

    private suspend fun downloadFirstFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download first file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... first file download finished ! .....")
    }

    private suspend fun downloadSecondFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download first Second.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Second file download finished ! .....")
    }
    private suspend fun downloadThirdFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Third file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Third file download finished ! .....")
    }
    private suspend fun downloadForthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Forth file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Forth file download finished ! .....")
    }
    private suspend fun downloadFifthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Fifth file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Fifth file download finished ! .....")
    }
    private suspend fun downloadSixthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Sixth file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Sixth file download finished ! .....")
    }
    private suspend fun downloadSeventhFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Seventh file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Seventh file download finished ! .....")
    }
    private suspend fun downloadEighthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Eighth file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Eighth file download finished ! .....")
    }
    private suspend fun downloadNinthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Ninth file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Ninth file download finished ! .....")
    }
    private suspend fun downloadTenthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download Tent file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... Tent file download finished ! .....")
    }

    suspend fun canselOrJoin() = coroutineScope {

        val downloader: Job = launch {
            Log.d("TEST_ANDROID", "Загружаем файлы....")
            for (i in 1..100) {
                Log.d("TEST_ANDROID", "Файл $i загружен!")
                delay(1000L)
            }
        }

        delay(500L)
        Log.d("TEST_ANDROID", "Прервем загрузку? ")

        downloader.cancel()
        downloader.join()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater,container,false)
        return binding.root
    }
}
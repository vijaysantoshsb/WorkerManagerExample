package com.android.workermanagerexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uploadWorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .build()

        WorkManager.getInstance().enqueue(uploadWorkRequest)

        WorkManager.getInstance().getWorkInfoByIdLiveData(uploadWorkRequest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                    Log.i("Executed","yes")
                }
            })
    }


    class UploadWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
        override fun doWork(): Result {
            doTask()
            doonemoreTask()
            return Result.success()
        }

        private fun doTask() {
            Log.i("Executed","yes")
        }
        private fun doonemoreTask() {
            Log.i("Executed","yes")
        }
    }
}

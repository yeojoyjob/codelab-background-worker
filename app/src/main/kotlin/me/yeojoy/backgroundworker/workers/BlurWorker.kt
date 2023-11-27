package me.yeojoy.backgroundworker.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import me.yeojoy.backgroundworker.R
import me.yeojoy.backgroundworker.util.blurBitmap
import me.yeojoy.backgroundworker.util.makeStatusNotification
import me.yeojoy.backgroundworker.util.writeBitmapToFile

private const val TAG = "BlurWorker"

class BlurWorker(
    private val context: Context,
    params: WorkerParameters
) : Worker(context, params) {

    override fun doWork(): Result {
        // TODO("Not yet implemented")
        makeStatusNotification("Start blurring an image", context)

        return try {

            val picture = BitmapFactory.decodeResource(
                context.resources,
                R.drawable.android_cupcake
            )

            val output = blurBitmap(picture, context)

            val outputUri = writeBitmapToFile(context, output)

            makeStatusNotification("Output is $outputUri", context)

            Result.success()
        } catch (e: Exception) {
            makeStatusNotification("Fail to blur the image.", context)
            Log.e(TAG, "doWork() error -> ${e.message}")
            Result.failure()
        }
    }
}
package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by saip92 on 7/24/2017.
 */

public class Emojifier {

    private static final String TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bitmap){

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = detector.detect(frame);
        if(faces.size() > 0)
            Log.v(TAG, "Number of faces detected: " + faces.size());
        else
            Toast.makeText(context,"No faces detected", Toast.LENGTH_SHORT).show();

        detector.release();
    }
}

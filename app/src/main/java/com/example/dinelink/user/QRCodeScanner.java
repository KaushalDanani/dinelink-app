package com.example.dinelink.user;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.dinelink.R;
import com.google.zxing.Result;

public class QRCodeScanner extends AppCompatActivity {

    private TextView welcomeText;
    private CodeScanner mCodeScanner;
    boolean cameraPermission = false;
    private final int CAMERA_REQ_CODE = 10;
    private String name;
//    private CameraManager cameraManager;
//    private String[] cameraID;
//    boolean isFlashLightOn = false;
//    private Button flashBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qrcode_scanner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.qrScannerFrame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = getIntent().getStringExtra("KeyName");

        welcomeText = findViewById(R.id.welcomeText);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
//        flashBtn = findViewById(R.id.flashBtn);

//        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
//        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
//            // Device doesn't support flash
//            Toast.makeText(this, "No Flash", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            try {
//
//                cameraID = cameraManager.getCameraIdList();
//
//                for (String id : cameraID) {
//                    if (cameraManager.getCameraCharacteristics(id)
//                            .get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_BACK) {
//                        cameraID[0] = id;
//                    }
//                }
//            } catch (Exception e) {
//                Toast.makeText(this, "Camera Access Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        flashBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(isFlashLightOn)
//                {
//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
//                    {
//                        try {
//                            cameraManager.setTorchMode(cameraID[0], true);
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
//                        isFlashLightOn = false;
//                    }
//                }
//                else {
//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
//                    {
//                        try {
//                            cameraManager.setTorchMode(cameraID[0], false);
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
//                        isFlashLightOn = true;
//                    }
//                }
//            }
//        });

        mCodeScanner = new CodeScanner(this, scannerView);
        welcomeText.setText("Hey, "+name+"\n🍽 Happy Dinner 🍽");
        askCameraPermission();

        if(cameraPermission) {
            mCodeScanner.setDecodeCallback(new DecodeCallback() {
                @Override
                public void onDecoded(@NonNull final Result result) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent ii = new Intent(QRCodeScanner.this, MenuItemActivity.class);
                            ii.putExtra("HOTEL_ID", Integer.parseInt(result.getText()));
                            startActivity(ii);
                            Toast.makeText(QRCodeScanner.this, result.getText(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
            scannerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCodeScanner.startPreview();
                }
            });
        }
    }


    private void askCameraPermission() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{android.Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
            }
            else
            {
                cameraPermission = true;
                mCodeScanner.startPreview();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == CAMERA_REQ_CODE)
        {
            if(grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED))
            {
                cameraPermission = true;
                mCodeScanner.startPreview();
            }
            else
            {
                if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))
                {
                    new AlertDialog.Builder(this)
                            .setTitle("Camera Permission")
                            .setMessage("Please provide the camera permission for scan QR code and using all features of app")
                            .setPositiveButton("Procced", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .create().show();
                }
                else
                {
                    new AlertDialog.Builder(this)
                            .setTitle("Camera Permission")
                            .setMessage("You have denied camera permission.\nPlease allow permission at [Setting] > [Permissions]")
                            .setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    dialogInterface.dismiss();
                                    Intent ii = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null));
                                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(ii);
                                    finish();
                                }
                            })
                            .setNegativeButton("No, Exit App", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finishAffinity();
                                    System.exit(0);
                                }
                            })
                            .create().show();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(cameraPermission) {
            mCodeScanner.startPreview();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(cameraPermission) {
            mCodeScanner.releaseResources();
        }
    }
}
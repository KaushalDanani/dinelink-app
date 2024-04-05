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
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.dinelink.R;
import com.google.gson.Gson;
import com.example.dinelink.login.Customer_Login;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QRCodeScanner extends AppCompatActivity {

    private TextView welcomeText;
    private CodeScanner mCodeScanner;
    boolean isCameraPermission = false, isPhonePermission = false, isSMSPermission = false, isPhoneStatePermission = false;
    public static String USER_PHONE_NO;
    public static int HOTEL_ID, TABLE_NO;
    ActivityResultLauncher<String[]> activityResultLauncher;

//    private final int CAMERA_REQ_CODE = 10, PHONE_NO_REQ_CODE = 20;

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

//        name = getIntent().getStringExtra("KeyName");

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
        welcomeText.setText("Hey, " + Customer_Login.NAME_OF_USER + "\n🍽 Happy Dinner 🍽");


        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(),
                new ActivityResultCallback<Map<String, Boolean>>() {
                    @Override
                    public void onActivityResult(Map<String, Boolean> res) {

                        if (res.get(Manifest.permission.CAMERA) != null) {
                            isCameraPermission = res.get(Manifest.permission.CAMERA);
                            if (!isCameraPermission)
                                askCameraPermissionAgain();
                        }


                        if (res.get(Manifest.permission.READ_PHONE_NUMBERS) != null) {
                            isPhonePermission = res.get(Manifest.permission.READ_PHONE_NUMBERS);
                            if (!isPhonePermission)
                                askPhonePermissionAgain();
                        }

                        if (res.get(Manifest.permission.READ_PHONE_STATE) != null) {
                            isPhoneStatePermission = res.get(Manifest.permission.READ_PHONE_STATE);
                        }

//                        if (res.get(Manifest.permission.READ_SMS) != null) {
//                            isSMSPermission = res.get(Manifest.permission.READ_SMS);
//                            if (!isSMSPermission)
//                                askPhonePermissionAgain();
//                        }
                    }
                });

        requestForPermissions();
//        Toast.makeText(this, "Phone No: "+USER_PHONE_NO.substring(2), Toast.LENGTH_SHORT).show();

        if (isCameraPermission && isPhonePermission) {
            mCodeScanner.startPreview();
            mCodeScanner.setDecodeCallback(new DecodeCallback() {
                @Override
                public void onDecoded(@NonNull final Result result) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            QRCodeDecoder q = null;
                            String sqJson = result.getText();
                            Gson gson = new Gson();
                            q = gson.fromJson(sqJson,QRCodeDecoder.class);
                            HOTEL_ID = q.hotelId;
                            TABLE_NO = q.tableNo;
//                            Toast.makeText(QRCodeScanner.this,q.hotelId+" "+q.tableNo,Toast.LENGTH_SHORT).show();
                            Intent ii = new Intent(QRCodeScanner.this, MenuItemActivity.class);
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

    public void requestForPermissions() {

        isCameraPermission = ContextCompat.checkSelfPermission(QRCodeScanner.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;
        isPhonePermission = ContextCompat.checkSelfPermission(QRCodeScanner.this, Manifest.permission.READ_PHONE_NUMBERS)
                == PackageManager.PERMISSION_GRANTED;
        isPhoneStatePermission = ContextCompat.checkSelfPermission(QRCodeScanner.this, Manifest.permission.READ_PHONE_STATE)
                == PackageManager.PERMISSION_GRANTED;
//        isSMSPermission = ContextCompat.checkSelfPermission(QRCodeScanner.this, Manifest.permission.READ_SMS)
//                == PackageManager.PERMISSION_GRANTED;

        if(isPhonePermission) {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
            USER_PHONE_NO = telephonyManager.getLine1Number();
//            Toast.makeText(this, "Phone No: "+USER_PHONE_NO.substring(2), Toast.LENGTH_SHORT).show();
        }

        List<String> requestPermissions = new ArrayList<String>();

        if(!isCameraPermission)
            requestPermissions.add(Manifest.permission.CAMERA);
        if(!isPhonePermission)
            requestPermissions.add(Manifest.permission.READ_PHONE_NUMBERS);
        if(!isPhoneStatePermission)
            requestPermissions.add(Manifest.permission.READ_PHONE_STATE);
//        if(!isSMSPermission)
//            requestPermissions.add(Manifest.permission.READ_SMS);

        if(!requestPermissions.isEmpty())
            activityResultLauncher.launch(requestPermissions.toArray(new String[0]));

//        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        USER_PHONE_NO = telephonyManager.getLine1Number();
//        Toast.makeText(this, "Phone No: "+USER_PHONE_NO.substring(2), Toast.LENGTH_SHORT).show();
    }


    private void askCameraPermissionAgain() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            new AlertDialog.Builder(this)
                    .setTitle("Camera Permission")
                    .setMessage("Please provide the camera permission for scan QR code and to use all features of application...!")
                    .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

//                            ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);

                            List<String> requestPermissions = new ArrayList<String>();
                            if(!isCameraPermission)
                                requestPermissions.add(Manifest.permission.CAMERA);

                            activityResultLauncher.launch(requestPermissions.toArray(new String[0]));
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create().show();
        } else {
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


    private void askPhonePermissionAgain() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_NUMBERS)) {
            new AlertDialog.Builder(this)
                    .setTitle("Phone Permission")
                    .setMessage("Please provide the phone call permission to use all features of application...!")
                    .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

//                            ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);

                            List<String> requestPermissions = new ArrayList<String>();
                            if(!isPhonePermission)
                                requestPermissions.add(Manifest.permission.READ_PHONE_NUMBERS);

                            activityResultLauncher.launch(requestPermissions.toArray(new String[0]));
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create().show();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Phone Permission")
                    .setMessage("You have denied phone call permission.\nPlease allow permission at [Setting] > [Permissions]")
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


    private void askSMSPermissionAgain() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS))
        {
            new AlertDialog.Builder(this)
                    .setTitle("Required Permission")
                    .setMessage("Please provide the SMS permission to use all features of application...!")
                    .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            List<String> requestPermissions = new ArrayList<String>();
                            if(!isSMSPermission)
                                requestPermissions.add(Manifest.permission.READ_SMS);

                            activityResultLauncher.launch(requestPermissions.toArray(new String[0]));
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
    }






//    private void askCameraPermission() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
//        } else {
//            cameraPermission = true;
//        }
//    }
//
//    private void askPhoneNumberPermission() {
//
//        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED
//                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
//                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_PHONE_NUMBERS, Manifest.permission.READ_SMS}, PHONE_NO_REQ_CODE);
//        } else {
//            phoneAndSMSPermission = true;
//            String phone = tm.getLine1Number();
//            Toast.makeText(this, "Phone No: "+phone, Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        if (requestCode == CAMERA_REQ_CODE) {
//            if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                cameraPermission = true;
//            } else {
//                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
//                    new AlertDialog.Builder(this)
//                            .setTitle("Camera Permission")
//                            .setMessage("Please provide the camera permission for scan QR code and to use all features of application...!")
//                            .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//
//                                    ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
//                                }
//                            })
//                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                }
//                            })
//                            .create().show();
//                } else {
//                    new AlertDialog.Builder(this)
//                            .setTitle("Camera Permission")
//                            .setMessage("You have denied camera permission.\nPlease allow permission at [Setting] > [Permissions]")
//                            .setPositiveButton("Settings", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//
//                                    dialogInterface.dismiss();
//                                    Intent ii = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null));
//                                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                    startActivity(ii);
//                                    finish();
//                                }
//                            })
//                            .setNegativeButton("No, Exit App", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                    finishAffinity();
//                                    System.exit(0);
//                                }
//                            })
//                            .create().show();
//                }
//            }
//        } else if (requestCode == PHONE_NO_REQ_CODE) {
//            phoneAndSMSPermission = true;
//            for (int grantResult : grantResults) {
//                if (grantResult != PackageManager.PERMISSION_GRANTED) {
//                    phoneAndSMSPermission = false;
//                    break;
//                }
//            }
//
//            if(!phoneAndSMSPermission) {
//                if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_NUMBERS))
//                {
//                    new AlertDialog.Builder(this)
//                            .setTitle("Permission Required")
//                            .setMessage("Please provide the both Phone call and SMS permission to use all features of application...!")
//                            .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//
//                                    ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_PHONE_NUMBERS, Manifest.permission.READ_SMS}, PHONE_NO_REQ_CODE);
//                                }
//                            })
//                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                }
//                            })
//                            .create().show();
//                }
//                else {
//                    new AlertDialog.Builder(this)
//                            .setTitle("Permission Required")
//                            .setMessage("You have denied require permission.\nPlease allow permission at [Setting] > [Permissions]")
//                            .setPositiveButton("Settings", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//
//                                    dialogInterface.dismiss();
//                                    Intent ii = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null));
//                                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                    startActivity(ii);
//                                    finish();
//                                }
//                            })
//                            .setNegativeButton("No, Exit App", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                    finishAffinity();
//                                    System.exit(0);
//                                }
//                            })
//                            .create().show();
//                }
//            }
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

    @Override
    protected void onResume() {
        super.onResume();

        if(isCameraPermission && isPhonePermission)
            mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(isCameraPermission && isPhonePermission)
            mCodeScanner.releaseResources();
    }
}
package com.example.dinelink.login;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.dinelink.BuildConfig;
import com.example.dinelink.R;
import com.example.dinelink.user.QRCodeScanner;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import org.jetbrains.annotations.Nullable;

public class Customer_Login extends Activity {

    public static String USER_EMAIL_ID;
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;
    private static final int REQ_SIGN_IN_WITH_GOOGLE = 37;
    private static final String CLIENT_ID = BuildConfig.CLIENT_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_customer_login);

        oneTapClient = Identity.getSignInClient(this);
        signInRequest = BeginSignInRequest.builder()
                .setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions.builder()
                        .setSupported(true)
                        .build())
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        .setServerClientId(CLIENT_ID)
                        .setFilterByAuthorizedAccounts(false)
                        .build())
//                .setAutoSelectEnabled(true)
                .build();

    }


    public void SignIn_With_Google (View view) {


        oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener(this, new OnSuccessListener<BeginSignInResult>() {
                @Override
                public void onSuccess(BeginSignInResult result) {
                    try {
                        startIntentSenderForResult(
                                result.getPendingIntent().getIntentSender(), REQ_SIGN_IN_WITH_GOOGLE,
                                null, 0, 0, 0);
                    } catch (IntentSender.SendIntentException e) {
                        Log.e(TAG, "Couldn't start One Tap UI: " + e.getLocalizedMessage());
                    }
                }
            })
                .addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            });

//        Toast.makeText(this, "Hello, Folks....", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_SIGN_IN_WITH_GOOGLE) {
            try {
                SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(data);
                String idToken = credential.getGoogleIdToken();
                USER_EMAIL_ID = credential.getId();
                String name = credential.getDisplayName();
                Toast.makeText(this,"Email ID : "+USER_EMAIL_ID+"\n Name : "+name, Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(this, QRCodeScanner.class);
//                ii.putExtra("KeyEmailID", USER_EMAIL_ID);
                ii.putExtra("KeyName", name);
                startActivity(ii);

                if (idToken != null) {
                    Log.d(TAG, "Got ID token.");
                } else if (name != null) {
                    Log.d(TAG, "Got Name.");
                }
            } catch (ApiException e) {
                Toast.makeText(this, "SIGN-IN WITH GOOGLE ERROR : "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
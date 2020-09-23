package com.example.finalfyp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp extends AppCompatActivity {
    AutoCompleteTextView nationality;
    String [] arr = {"Australia","India","Pakistan", "South Africa", "USA"};
    CircleImageView profilepic;
    String path;
    EditText username, email, password;
    Button signUp;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private final static int IMAGE_PICK_CODE = 1000;
    private final static int PERMISSION_CODE = 1001;
    String name, get_email, get_password;
    String get_nationality;
    boolean flag_success = false;
    boolean flag_image = false;
    static Uri imageuri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nationality = (AutoCompleteTextView) findViewById(R.id.nationality);
        ArrayAdapter<String> adapter = new ArrayAdapter<> (this,android.R.layout.select_dialog_item, arr);
        nationality.setThreshold(0);
        nationality.setAdapter(adapter);

        profilepic = (CircleImageView)findViewById(R.id.profilepic);
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check runtime permission
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED)
                    { //permission not granted. Request it
                        String [] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //Show pop up for runtime permission
                        requestPermissions(permissions,PERMISSION_CODE);
                    }
                    else{ //permission already granted
                        pickImageFromGallery();

                    }

                }
                else{ //system OS is less than marshmallow
                    pickImageFromGallery();

                }
            }
        });
        signUp = findViewById(R.id.sign_up);
        username = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        nationality.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                get_nationality = parent.getItemAtPosition(position).toString();
                flag_success = true;
                return;
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int imageId = 0;
                if(username.getText() != null) {
                    name = username.getText().toString();
                    flag_success = true;
                }
                else {
                    Toast.makeText(getApplicationContext(), "enter your name", Toast.LENGTH_SHORT).show();
                    flag_success = false;
                }
                if(email.getText().toString() ==null) {
                    Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
                    flag_success = false;
                }
                else {
                    if (email.getText().toString().trim().matches(emailPattern)) {
                        get_email = email.getText().toString();
                        flag_success = true;
                    } else {
                        Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                        flag_success =false;
                    }
                }
                if(password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter password", Toast.LENGTH_SHORT).show();
                    flag_success = false;
                }
                else {
                    get_password = password.getText().toString();
                    flag_success = true;
                }

                if(get_nationality == null) {
                    Toast.makeText(getApplicationContext(), "Choose your nationality", Toast.LENGTH_SHORT).show();
                    flag_success = false;
                }
                if(flag_image == true)
                    imageId = profilepic.getId();
                else
                {
                    flag_success = false;
                    Toast.makeText(getApplicationContext(), "Choose profile picture", Toast.LENGTH_SHORT).show();
                }

                if(flag_success == true && flag_image == true)
                {

                    if(Start.myAppDb.myDao().getUserEmail(get_email) == null) {
                        User user = new User(name, get_password, get_nationality, get_email, path);
                        Start.myAppDb.myDao().addUser(user);
                        Intent intent = new Intent(getApplicationContext(), Login.class );
                        intent.putExtra("image", imageuri.toString());
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void pickImageFromGallery() {
        //Intent to pick image
        flag_image = true;
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    //handle result of runtime permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    pickImageFromGallery();
                }
                else //permission not granted
                {
                    Toast.makeText(this,"Permission denied", Toast.LENGTH_SHORT).show();
                }
        }
    }

    //Handle result of picked image

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE)
        {
            profilepic.setImageURI(data.getData());
            imageuri = data.getData();
            path = getRealPathFromURI(this,imageuri);
            String name = getFileName(imageuri);

            try {
                insertInPrivateStorage(name,path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void insertInPrivateStorage(String name, String path) throws IOException {
        FileOutputStream fos  = openFileOutput(name,MODE_APPEND);

        File file = new File(path);

        byte[] bytes = getBytesFromFile(file);

        fos.write(bytes);
        fos.close();



    }

    public byte[] getBytesFromFile(File file) throws IOException {
        byte[] data = FileUtils.readFileToByteArray(file);
        return data;

    }

    public String getFileName(Uri uri)
    {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    public String getRealPathFromURI(Context context, Uri uri)
    {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, proj, null, null,
                null);
        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        return null;
    }



}

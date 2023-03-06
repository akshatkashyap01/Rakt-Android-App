package com.example.rakt;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.rakt.DonorInformation.DonorInformation;
import com.example.rakt.DonorInformation.DonorRoot;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;


public class DonateBloodScreen extends Fragment {


    private static final String TAG = "DonateBloodScreen";

 View view;
 String imgpath=null;
 EditText editText_name,editText_phone,editText_city;
 ImageView back;
 Button submit_button,btn_A,btn_B,btn_AB,btn_O_pos,btn_O_neg;
 ImageView add_profile_image;
 RadioButton radio_btn_male,radio_btn_female;
 String type,blood_type;
 Uri image;
 DonorInformation donorInformation;
    ArrayList<DonorInformation> donorInformation1;
    DonorRoot donorRoot;
 public static ImageView profile_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_donate_blood_screen, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        type=null;
        blood_type=null;


        FindId();

        OnClicks();




    }

    private void FindId() {

        back=view.findViewById(R.id.image_back);
        submit_button=view.findViewById(R.id.done_btn);
        add_profile_image=view.findViewById(R.id.Add_profilepic_imageView);
        profile_image=view.findViewById(R.id.img_donor);
        editText_name=view.findViewById(R.id.edtx_name_doner);
        editText_phone=view.findViewById(R.id.edtx_phone_doner);
        editText_city=view.findViewById(R.id.edtx_city_doner);
        radio_btn_male=view.findViewById(R.id.radio_btn_male);
        radio_btn_female=view.findViewById(R.id.radio_btn_female);
        btn_A=view.findViewById(R.id.btn_A);
        btn_B=view.findViewById(R.id.btn_B);
        btn_AB=view.findViewById(R.id.btn_AB);
        btn_O_pos=view.findViewById(R.id.btn_O_pos);
        btn_O_neg=view.findViewById(R.id.btn_O_neg);

    }

    private void OnClicks() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog upload_box=new Dialog(getContext());
                upload_box.setContentView(R.layout.exit_without_submitdetails_dialogue_box);
//                upload_box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                upload_box.setCanceledOnTouchOutside(false);
                Window window=upload_box.getWindow();
                window.setGravity(Gravity.CENTER);
                upload_box.show();

                upload_box.findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        getActivity().onBackPressed();

                        upload_box.dismiss();
                    }
                });

                upload_box.findViewById(R.id.no_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getContext(), "Please enter details and submit", Toast.LENGTH_SHORT).show();

                        upload_box.dismiss();
                    }
                });

            }
        });



        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                blood_type="A+";

            }
        });

        btn_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                blood_type="B+";

            }
        });

        btn_AB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                blood_type="AB+";

            }
        });

        btn_O_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                blood_type="O+";

            }
        });

        btn_O_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                blood_type="O-";

            }
        });



        radio_btn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                type="Male";
            }
        });

        radio_btn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                type="Female";
            }
        });


        submit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (editText_name.length()==0){

                    Toast.makeText(getContext(), "please enter name", Toast.LENGTH_SHORT).show();

                }else if (editText_phone.length()==0){

                    Toast.makeText(getContext(), "please enter phone", Toast.LENGTH_SHORT).show();

                }else if (editText_city.length()==0){

                    Toast.makeText(getContext(), "please enter city", Toast.LENGTH_SHORT).show();

                }

                else if(type==null)
                {
                    Toast.makeText(getContext(), "please select gender", Toast.LENGTH_SHORT).show();
                }


                else if(blood_type==null)
                {
                    Toast.makeText(getContext(), "please select blood type", Toast.LENGTH_SHORT).show();

                }

                else{


                    Gson gson = new Gson();


                    SharedPreferences sharedPreferences= requireContext().getSharedPreferences(MainScreen.donor_file, Context.MODE_PRIVATE);
                    String editData = sharedPreferences.getString(MainScreen.donor_key, "");

                    if(editData.length()!=0)
                    {

                        Log.d(TAG, "onClick: not empty");

                        donorRoot = gson.fromJson(editData, DonorRoot.class);

                      donorInformation1=new ArrayList<>(donorRoot.getDonorInformation());


                        donorInformation=new DonorInformation();

                        donorInformation.setName(editText_name.getText().toString());
                        donorInformation.setPhone(editText_phone.getText().toString());
                        donorInformation.setCity(editText_city.getText().toString());
                        donorInformation.setGender(type);
                        donorInformation.setBlood_type(blood_type);
                        if(image!=null)
                        {
                            donorInformation.setImage(image.toString());
                        }
                        else
                        {

                            donorInformation.setImage("no image");
                        }

                        donorInformation1.add(donorInformation);

                    }

                    else
                    {

                        Log.d(TAG, "onClick: empty");

                         donorInformation=new DonorInformation();

                        donorInformation.setName(editText_name.getText().toString());
                        donorInformation.setPhone(editText_phone.getText().toString());
                        donorInformation.setCity(editText_city.getText().toString());
                        donorInformation.setGender(type);
                        donorInformation.setBlood_type(blood_type);

                        if(image!=null)
                        {
                            donorInformation.setImage(image.toString());
                        }
                        else
                        {

                            donorInformation.setImage("no image");
                        }


                    }

                    Dialog upload_box=new Dialog(getContext());
                    upload_box.setContentView(R.layout.details_submitted_dialogue_box);
//                upload_box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    upload_box.setCanceledOnTouchOutside(false);
                    Window window=upload_box.getWindow();
                    window.setGravity(Gravity.CENTER);
                    upload_box.show();

                    upload_box.findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            SharedPreferences sharedPreferences= requireContext().getSharedPreferences(MainScreen.donor_file, Context.MODE_PRIVATE);
                            String editData = sharedPreferences.getString(MainScreen.donor_key, "");


                            if(editData.length()!=0)
                            {
                                SharedPreferences sharedPreferences1= requireContext().getSharedPreferences(MainScreen.donor_file,Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor=sharedPreferences1.edit();

                                editor.clear();
                                editor.apply();


                                SharedPreferences sharedPreferences2= requireContext().getSharedPreferences(MainScreen.donor_file, Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor1=sharedPreferences2.edit();

                                donorRoot.donorInformation=donorInformation1;

                                String json = gson.toJson(donorRoot);

                                editor1.putString(MainScreen.donor_key,json);

                                editor1.apply();

                            }
                            else
                            {
                                donorRoot=new DonorRoot();


                                donorRoot.donorInformation.add(donorInformation);


                                SharedPreferences sharedPreferences1= requireContext().getSharedPreferences(MainScreen.donor_file, Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor=sharedPreferences1.edit();

                                String json = gson.toJson(donorRoot);

                                editor.putString(MainScreen.donor_key,json);

                                editor.apply();
                            }

                            Toast.makeText(getContext(), "Details Submitted Successfully.", Toast.LENGTH_SHORT).show();

                            getActivity().onBackPressed();

                            upload_box.dismiss();
                        }
                    });

                    upload_box.findViewById(R.id.no_btn).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(getContext(), "Details Submission Cancelled.", Toast.LENGTH_SHORT).show();

                            upload_box.dismiss();
                        }
                    });


                }

            }
        });


        add_profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int permission= ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE);

                if(permission!= PackageManager.PERMISSION_GRANTED)
                {

                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
                            ,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
                else
                {
                    Intent intent=new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");

                    startActivityForResult(intent,1);


                }

                add_profile_image.setVisibility(View.GONE);

            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == Activity.RESULT_OK)
        {


            assert data != null;
              image=data.getData();

            ContentResolver contentResolver= requireContext().getContentResolver();
            Cursor cursor=contentResolver.query(image,null,null,null,null);

            if(cursor!=null)
            {
                while (cursor.moveToNext())
                {

                    File file=new File(cursor.getString(cursor.getColumnIndex("_data")));

                    this.imgpath=file.toString();


                    profile_image.setImageURI(image);

                }

                cursor.close();

            }

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                startActivityForResult(intent, 1);


            } else {

                if(shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE))
                {

                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
                            ,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

                }
                else
                {
                    Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri=Uri.fromParts("package", requireContext().getPackageName(),null);
                    intent.setData(uri);
                    requireContext().startActivity(intent);

                }
            }
        }

    }


}
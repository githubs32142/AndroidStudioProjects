package com.wather.andrzej.sqllite;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wather.andrzej.sqllite.ModelDB.User;

public class SingOut extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("User");
    EditText nPhone,pswd,userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_out);
        nPhone= (EditText)findViewById(R.id.numberPhone);
        pswd = (EditText) findViewById(R.id.passwd);
        userName=(EditText)findViewById(R.id.nameUser);
    }



    public void singOutBtnClick(View view) {
                final ProgressDialog mDialog= new ProgressDialog(SingOut.this);
                mDialog.setMessage("Please wait");
                mDialog.show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mDialog.dismiss();
                        if(dataSnapshot.child(nPhone.getText().toString()).exists()){
                            Toast.makeText(SingOut.this,"Phone number already exist",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            User user= new User(userName.getText().toString(),pswd.getText().toString());
                            databaseReference.child(nPhone.getText().toString()).setValue(user);
                            Toast.makeText(SingOut.this,"Sing up is fiish.",Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
}

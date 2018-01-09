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

public class SingIn extends AppCompatActivity {
 FirebaseDatabase database = FirebaseDatabase.getInstance();
 DatabaseReference databaseReference = database.getReference("User");
 EditText nPhone,pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        nPhone= (EditText)findViewById(R.id.numberPhone);
        pswd = (EditText) findViewById(R.id.passwd);
    }

    public void singInBtnClick(View view) {
        new Runnable() {
            @Override
            public void run() {
                final ProgressDialog mDialog= new ProgressDialog(SingIn.this);
                mDialog.setMessage("Please wait");
                mDialog.show();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mDialog.dismiss();
                        if(dataSnapshot.child(nPhone.getText().toString()).exists()){

                            User user= dataSnapshot.child(nPhone.getText().toString()).getValue(User.class);
                            if(user.getPassword().equals(pswd.getText().toString())){
                                Toast.makeText(SingIn.this, R.string.sucess,Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(SingIn.this, R.string.fail,Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SingIn.this, R.string.exist,Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        }.run();

    }
}

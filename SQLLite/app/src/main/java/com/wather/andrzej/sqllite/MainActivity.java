package com.wather.andrzej.sqllite;

        import android.content.Intent;
        import android.database.DatabaseErrorHandler;
        import android.database.sqlite.SQLiteDatabaseLockedException;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singInClick(View view) {
        Intent singIn = new Intent(MainActivity.this,SingIn.class);
        startActivity(singIn);
    }

    public void singUpClick(View view) {
        Intent singUp = new Intent(MainActivity.this,SingOut.class);
        startActivity(singUp);
    }
}

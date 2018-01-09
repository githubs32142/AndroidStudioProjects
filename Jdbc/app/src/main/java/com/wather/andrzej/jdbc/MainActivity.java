package com.wather.andrzej.jdbc;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.wather.andrzej.jdbc.DAO.DAOConf;
import com.wather.andrzej.jdbc.DAO.DAOConnection;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Button conn;
    Statement st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connBAO(View view) {
        //TableLayout ll = (TableLayout) findViewById(R.id.tableLayout);
       new AsynTask().execute("");
       try {

          ResultSet resultSet = st.executeQuery("SELECT * FROM Student ");

       }
       catch (Exception ex){
           ex.printStackTrace();
       }

    }

    private class AsynTask extends AsyncTask<String ,Void,Connection> {

        @Override
        protected Connection doInBackground(String... doubles) {
            Connection c= null;
            try {
                Class.forName(DAOConf.JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                Log.getStackTraceString(e);
            }
            try {
                c= DriverManager.getConnection(DAOConf.URL, DAOConf.LOGIN, DAOConf.PASSWORD);

            } catch (SQLException e) {
                Log.getStackTraceString(e);
                Toast.makeText(MainActivity.this,"SQLException", Toast.LENGTH_SHORT).show();
            }
            return c;
        }

        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this,"Start execute Pi", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Connection cnn) {
            Toast.makeText(MainActivity.this,"End execute Pi",Toast.LENGTH_SHORT).show();
            try {
                st=cnn.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT * FROM Student ");
            } catch (SQLException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

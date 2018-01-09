package edu.pwste.simsim;

import android.media.session.PlaybackState;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import edu.pwste.simsim.Adapter.ChatAdapter;
import edu.pwste.simsim.Helper.HttpDataHelper;
import edu.pwste.simsim.Models.ChatModel;
import edu.pwste.simsim.Models.SimsimModel;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    List<ChatModel> chatModels= new ArrayList<>();
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_of_message);
        editText = (EditText) findViewById(R.id.user_message);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.click);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text= editText.getText().toString();
                ChatModel model= new ChatModel(text,true);
                chatModels.add(model);
                new SimsimAPI().execute(chatModels);
                editText.setText("");
            }
        });
    }
    private class SimsimAPI extends AsyncTask<List<ChatModel>,Void,String>{
        String stream = null;
        List<ChatModel> model;
        String text= editText.getText().toString();
        @Override
        protected String doInBackground(List<ChatModel>[] lists) {
           String url =String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=pl&ft=1.0&text=%s",getString(R.string.simsims_api),text);
           model= lists[0];
            HttpDataHelper httpDataHelper= new HttpDataHelper();
            stream= httpDataHelper.getHttpData(url);
            Log.d("A",stream);
            return  stream;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            SimsimModel response= gson.fromJson(s,SimsimModel.class);
            ChatModel chatModel = new ChatModel(response.getResponse(),false);
            model.add(chatModel);
            ChatAdapter chatAdapter = new ChatAdapter(model,getApplicationContext());
            listView.setAdapter(chatAdapter);
        }
    }
}

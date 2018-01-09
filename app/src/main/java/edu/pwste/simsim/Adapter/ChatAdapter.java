package edu.pwste.simsim.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

import edu.pwste.simsim.Models.ChatModel;
import edu.pwste.simsim.R;

/**
 * Created by Admin on 07.01.2018.
 */

public class ChatAdapter extends BaseAdapter {
    private List<ChatModel> modelList;
    private Context context;
    private LayoutInflater layoutInflater;

    public ChatAdapter(List<ChatModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
        layoutInflater = (LayoutInflater )(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vw= view;
        if(vw==null){
            if(modelList.get(i).isSend()){
                vw=layoutInflater.inflate(R.layout.list_items_message_send,null);
            }
            else {
                vw=layoutInflater.inflate(R.layout.list_items_message_resp,null);
            }
            BubbleTextView bubbleTextView= (BubbleTextView) vw.findViewById(R.id.text_message);
            bubbleTextView.setText(modelList.get(i).getMessage());
        }
        return vw;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}

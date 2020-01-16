package chanht.niu.edu.tw.projectv4;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class twofragment extends Fragment {
    private ListView mlistview;
    String[] title = new String[]{"101店","飛動天母店","飛動公館店","民生店","公館店","站前店","民權西店","大直店","長春店","民權東店","南京店","麗水店","大安店","統領店","光復店",
                                    "台北西門店"};
    String[] text = new String[]{"台北市信義區市府路45號6F",
            "臺北市士林區中山北路七段73號",
            "臺北市大安區羅斯福路三段281號1F",
            "台北市松山區民生東路三段156號B1",
            "台北市中正區羅斯福路四段68號2F",
            "台北市中正區忠孝西路一段50號6F",
            "臺北市大同區民權西路136號1F&B1",
            "台北市中山區堤頂大道二段588號",
            "臺北市中山區長春路90號",
            "臺北市中山區民權東路三段86號1F",
            "台北市松山區南京東路五段196號",
            "臺北市大安區麗水街18號1F",
            "台北市大安區信義路四段6號3F",
            "台北市大安區忠孝東路四段201號3F",
            "臺北市大安區忠孝東路四段330號B1",
            "台北市萬華區西寧南路36號B1"};

    MediaPlayer mediaPlayer;



    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_two,container,false);

        mediaPlayer = MediaPlayer.create(getActivity(),R.raw.light);
        mediaPlayer.setLooping(true);



        mlistview = view.findViewById(R.id.listview);
        List<HashMap<String,String>> list = new ArrayList<>();
        for(int i = 0 ; i < title.length ; i++){
            HashMap<String , String> hashMap = new HashMap<>();
            hashMap.put("title" , title[i]);
            hashMap.put("text" , text[i]);
            //把title , text存入HashMap之中
            list.add(hashMap);
            //把HashMap存入list之中
        }
        ListAdapter listAdapter = new SimpleAdapter(getActivity(),list, android.R.layout.simple_list_item_2,new String[]{"title","text"},new int[]{android.R.id.text1,android.R.id.text2});
        mlistview.setAdapter(listAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        try{
            if(mediaPlayer!=null){
                mediaPlayer.stop();
            }
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (IOException c){
            c.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

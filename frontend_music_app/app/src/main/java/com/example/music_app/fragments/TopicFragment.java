package com.example.music_app.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.music_app.AllAlbum;
import com.example.music_app.AllTopic;
import com.example.music_app.Category;
import com.example.music_app.R;
import com.example.music_app.model.Topic;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicFragment extends Fragment {

    private View view;
    private HorizontalScrollView horizontalScrollView;
    private TextView viewMore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_topic, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollViewTopic);
        viewMore = view.findViewById(R.id.textViewTopicMore);
        GetData();
        try {
            viewMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), AllTopic.class);
                    startActivity(intent);
                }
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Topic>> call = dataService.getAllTopic();
        call.enqueue(new Callback<List<Topic>>() {
            @Override
            public void onResponse(Call<List<Topic>> call, Response<List<Topic>> response) {
                if(response.isSuccessful()) {
                    List<Topic> topics = response.body();

                    LinearLayout linearLayout = new LinearLayout(getActivity());
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                    LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(620, 300);
                    layout.setMargins(10, 20, 20, 30);
                    for(Topic topic : topics) {
                        CardView cardView = new CardView(getActivity());
                        cardView.setRadius(10);
                        ImageView imageView = new ImageView(getContext());
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        if(topic.getImage() != null) {
                            Picasso.with(getActivity()).load(topic.getImage()).into(imageView);
                        }
                        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        TextView textView = new TextView(getContext());
                        textView.setText(topic.getName());
                        textView.setGravity(Gravity.CENTER);
                        textView.setTypeface(null, Typeface.BOLD);
                        textView.setTextColor(Color.WHITE);
                        textView.setTextSize(30);
                        cardView.setLayoutParams(layout);
                        cardView.addView(imageView);
                        cardView.addView(textView);
                        cardView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), Category.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("topic", topic.getName());
                                bundle.putLong("topicid", topic.getTopicid());
                                intent.putExtra("topic", bundle);
                                startActivity(intent);
                            }
                        });
                        linearLayout.addView(cardView);
                    }
                    horizontalScrollView.addView(linearLayout);
                }
            }

            @Override
            public void onFailure(Call<List<Topic>> call, Throwable t) {
                Log.e("API_ERROR", "Can't call api");
            }
        });
    }
}
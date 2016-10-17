package com.example.aleksei.cloudtariff;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    protected PageInfo[] pages;
    private HorizontalAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.toolbar_color_text));
        toolbar.setTitle("Сloud Storage");
        this.setSupportActionBar(toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        pages = new PageInfo[]{ getFirstPage(), getSecondPage(), getThirdPage()};
        mAdapter = new HorizontalAdapter(pages);

        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(horizontalLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        PageInfo[] pages;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public ImageView image;
            public TextView title;
            public TextView message;
            public ScrollView scrollView;

            public MyViewHolder(View view) {
                super(view);
                image = (ImageView) view.findViewById(R.id.image);
                //title = (TextView) view.findViewById(R.id.textTitle);
                //message = (TextView) view.findViewById(R.id.textMessage);
                //scrollView = (ScrollView) view.findViewById(R.id.scrollView);
            }
        }

        public HorizontalAdapter(PageInfo[] pages) {
            this.pages = pages;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_view, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            PageInfo pageInfo = pages[position];
            if (holder.image != null) {
                holder.image.setImageResource(pageInfo.image);
            }
            //holder.title.setText(pageInfo.title);
            //holder.message.setText(pageInfo.message);
//            holder.scrollView.post(new Runnable() {
//                @Override
//                public void run() {
//                    holder.scrollView.fullScroll(ScrollView.FOCUS_DOWN);
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return pages.length;
        }
    }

    protected PageInfo getFirstPage() {
        return new PageInfo(R.drawable.image_tutorial3,
                R.string.tutorial_page1_title,
                R.string.tutorial_page1_message);
    }

    protected PageInfo getSecondPage() {
        return new PageInfo(R.drawable.image_tutorial1,
                R.string.tutorial_page2_title,
                R.string.tutorial_page2_message);
    }

    protected PageInfo getThirdPage() {
        return new PageInfo(R.drawable.image_tutorial2,
                R.string.tutorial_page3_title,
                R.string.tutorial_page3_message);
    }
}

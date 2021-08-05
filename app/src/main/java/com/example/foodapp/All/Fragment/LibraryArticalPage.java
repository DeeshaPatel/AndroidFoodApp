package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.All.Adapter.LibraryArticleAdapter;
import com.example.foodapp.All.Models.LibraryArticleModel;
import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LibraryArticalPage extends Fragment {

    ImageView imageView;
    TextView des;
    TextView name,body;
    String s_name,s_body,s_image;
    RecyclerView recyclerView;
    ArrayList<LibraryArticleModel> libraryArticleModels;

    public LibraryArticalPage(String name,String body,String image)
    {
        s_body = body;
        s_name = name;
        s_image = image;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library_artical_page, container, false);

        imageView = (ImageView)view.findViewById(R.id.img_library_article);
        des = (TextView)view.findViewById(R.id.library_article_description);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_library_article_ingredients);

        name = view.findViewById(R.id.library_artical_page_description_name);
        body = view.findViewById(R.id.library_artical_page_description_body);
        Picasso.get().load(s_image).into(imageView);

        name.setText(s_name);
        body.setText(s_body);


        imageView.setImageResource(R.drawable.splash3);

        des.setText("Description Description Description Description Description Description Description Description Description Description Description Description");

        libraryArticleModels = new ArrayList<>();
        libraryArticleModels.add(new LibraryArticleModel("1/2 cup fresh orange juice"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 cup fresh lemon juice"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 packed brown sugar"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 teaspoon grated orange zest"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 teaspoon grated lemon zest"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 cup fresh orange juice"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 teaspoon grated orange zest"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 cup fresh lemon juice"));
        libraryArticleModels.add(new LibraryArticleModel("1/2 cup fresh otange juice"));

        //LibraryArticleAdapter foodDiaryMealaAdapter = new LibraryArticleAdapter(getContext(),libraryArticleModels);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(foodDiaryMealaAdapter);

        return view;
    }
}
package com.jms.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jms.infogram.R;
import com.jms.infogram.adapter.CardViewAdapter;
import com.jms.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar

        showToolBar(getString(R.string.title_home_fragment),false,view);

        //recycLerview
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);

        //Layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(),R.layout.cardview_image,getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }

    public void showToolBar(String titulo,boolean botonSubir, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //cramos lista  de imagenes

    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://images.milenio.com/peZp0Ivh3qE5xE1wc4qRnIKg0XU=/618x0/uploads/media/2025/06/24/bananero-presuntamente-victima-abuso-sexual.jfif","Sibajad Mamad","2 dias","111 me gusta"));
        images.add(new Image("https://www.lacuarta.com/resizer/v2/7QV7CGYHZRDILFVEGTXOUNQPLY.jpg?auth=a4c482a077b6bec470d620239de3efc5741ba1ded48fac9d2d4f204cabcadaa1&smart=true&width=990&height=520&quality=70","Stefy Herrote","3 dias","8 me gusta"));
        images.add(new Image("https://www.nacion.com/resizer/v2/J4ORIEO24JB5ZJJCDMTIZJRAS4.jpg?smart=true&auth=f47daa877b63b20badd5b95140d4e74491edf3dfee084209ea0c0e44caa9e573&width=1440&height=1440","Debora Cabezas","9 dias","16 me gusta"));
        images.add(new Image("https://www.vice.com/wp-content/uploads/sites/2/2017/04/1492816139781-_DEI8187.jpeg","Adame Guadarama","5 dias","13me gusta"));
        images.add(new Image("https://pbs.twimg.com/amplify_video_thumb/1816254571947163648/img/7FMLpscsDOtxzX9J.jpg:large","Carlos Cabeza Parada","2 dias","6me gusta"));
        images.add(new Image("https://robertoramasso.com/wp-content/uploads/3-47.png","Mia Malkova","9 dias","12 me gusta"));
        images.add(new Image("https://diariocorreo.pe/resizer/Cd_17o9EkLUDhifICow51rdKSz8=/1200x675/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/XTC6JIK4YRB7HILHDSINRGHLW4.jpg","Bryan Robapartes","7 dias","19 me gusta"));
        images.add(new Image("https://f.rpp-noticias.io/2014/09/25/1445403.jpg?imgdimension=n_xlarge","Snoop Dog","4 dias","14 me gusta"));
        images.add(new Image("https://f.rpp-noticias.io/2021/04/15/230623_1083167.jpg?imgdimension=n_xlarge","Marcus Lecler","6 dias","10 me gusta"));
        images.add(new Image("https://imgs.elpais.com.uy/dims4/default/4543278/2147483647/strip/true/crop/607x417+0+29/resize/2880x1980!/format/webp/quality/90/?url=https%3A%2F%2Fel-pais-uruguay-production-web.s3.us-east-1.amazonaws.com%2Fbrightspot%2Ff9%2Fae%2F447bcd6a4585b9c99bebfe53259c%2Fcaptura-de-pantalla-2025-02-13-154954.png","Carlos Valdivia","1 dias","1 me gusta"));

        return images;
    }
}
package com.example.sohail.macha;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DressAdapter extends ArrayAdapter<Dress> {

    Context context;
    int resource;
    List<Dress> dressList;

    public DressAdapter(Context context, int resource,List<Dress> dressList) {
        super(context, resource,dressList);
        this.context = context;
        this.dressList = dressList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null);
        TextView name = view.findViewById(R.id.XmlName);
        TextView price = view.findViewById(R.id.XmlPrice);
        TextView catogiry = view.findViewById(R.id.XmlCatogiry);
        ImageView imageView = view.findViewById(R.id.XmlDressImage);

        Dress dress = dressList.get(position);
        price.setText(dress.getPrice());
        catogiry.setText(dress.getCatogiry());
        name.setText(dress.getName());
        imageView.setImageDrawable(context.getResources().getDrawable(dress.getImage(),null));

        return view;
    }
}

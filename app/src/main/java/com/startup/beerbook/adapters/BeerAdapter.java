package com.startup.beerbook.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.startup.beerbook.databinding.CellBeerBinding;
import com.startup.domain.models.Beer;

import java.util.ArrayList;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.ViewHolder> {

    private final ArrayList<Beer> beerArrayList = new ArrayList<>();

    public void setData(ArrayList<Beer> data){
        this.beerArrayList.clear();
        this.beerArrayList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BeerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CellBeerBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(beerArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return beerArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CellBeerBinding binding;

        public ViewHolder(@NonNull CellBeerBinding cellBeerBinding) {
            super(cellBeerBinding.getRoot());
            this.binding = cellBeerBinding;
        }

        public void bind(Beer beer){
            binding.cellBeerId.setText(String.valueOf(beer.getId()));
            Picasso.get()
                    .load(beer.getImageUrl())
                    .into(binding.cellBeerImage);
            binding.cellBeerName.setText(beer.getName());
            binding.cellBeerDescription.setText(beer.getDescription());
        }
    }


}

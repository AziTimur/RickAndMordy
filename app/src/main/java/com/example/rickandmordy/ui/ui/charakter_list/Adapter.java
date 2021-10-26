package com.example.rickandmordy.ui.ui.charakter_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rickandmordy.R;
import com.example.rickandmordy.databinding.ItemRvBinding;
import com.example.rickandmordy.ui.data.models.Charakter;
import com.example.rickandmordy.ui.data.models.MainResponse;

import java.util.ArrayList;

class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    ArrayList<Charakter> list = new ArrayList<>();
    private ItemRvBinding binding;
    private AdapterClickListener clickListener;

    public void setClickListener(AdapterClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setList(ArrayList<Charakter> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
//        return new ViewHolder(view);
        binding = ItemRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull ItemRvBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
//            textName = itemView.findViewById(R.id.nameTV);
//            textStatus = itemView.findViewById(R.id.stsTV);
//            imageView = itemView.findViewById(R.id.img_it);


        }

        public void onBind(Charakter charakter) {
            Glide
                    .with(binding.getRoot())
                    .load(charakter.getImage())
                    .centerCrop()
                    .into(binding.imgIt);
            binding.nameTV.setText(charakter.getName());
            binding.stsTV.setText(charakter.getStatus());

            itemView.setOnClickListener(v -> {
                clickListener.onClick(charakter);
            });

        }
    }

    public interface AdapterClickListener {
        void onClick(Charakter charakter);
    }
}

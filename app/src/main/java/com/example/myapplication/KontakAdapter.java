package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.KontakViewHolder> {

    private ArrayList<Kontak> dataList;

    public KontakAdapter(ArrayList<Kontak> dataList) {
        this.dataList = dataList;
    }

    @Override
    public KontakAdapter.KontakViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_kontak, parent, false);
        return new KontakAdapter.KontakViewHolder(view);
    }
    @Override
    public void onBindViewHolder(KontakAdapter.KontakViewHolder holder, int position) {
        holder.txtId.setText(dataList.get(position).getId());
        holder.txtName.setText(dataList.get(position).getName());
        holder.txtEmail.setText(dataList.get(position).getEmail());
        holder.txtAlamat.setText(dataList.get(position).getAlamat());
        holder.txtNohp.setText(dataList.get(position).getNohp());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class KontakViewHolder extends RecyclerView.ViewHolder{
        private TextView txtId, txtName,txtEmail, txtAlamat,txtNohp;


        public KontakViewHolder(View itemView) {
            super(itemView);
            txtId = (TextView) itemView.findViewById(R.id.textId);
            txtName = (TextView) itemView.findViewById(R.id.textName);
            txtEmail = (TextView) itemView.findViewById(R.id.textEmail);
            txtAlamat = (TextView)itemView.findViewById(R.id.textAlamat);
            txtNohp = (TextView)itemView.findViewById(R.id.textNohp);


        }


    }





}

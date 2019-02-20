package com.example.sherdonbrown.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sherdonbrown.myapplication.Model.Example;
import com.example.sherdonbrown.myapplication.R;

public class AdapterHolder extends RecyclerView.Adapter<AdapterHolder.ContactsAdapterHolder>{

    private Context mcontext;
    private Example exam;

    public AdapterHolder(Context mcontext, Example exam){
        this.mcontext = mcontext;
        this.exam = exam;
    }

    class ContactsAdapterHolder extends RecyclerView.ViewHolder{
        TextView add, name, email;
        public ContactsAdapterHolder(@NonNull View item){
            super(item);

            add = item.findViewById(R.id.tv_add);
            name = item.findViewById(R.id.tv_name);
            email = item.findViewById(R.id.tv_email);
        }

    }

    @NonNull
    @Override
    public ContactsAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.layout_card, viewGroup, false);
        return new ContactsAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapterHolder contactsAdapterHolder, int i) {
        contactsAdapterHolder.name.setText(exam.getContacts().get(i).getName());
        contactsAdapterHolder.add.setText(exam.getContacts().get(i).getAddress());
        contactsAdapterHolder.email.setText(exam.getContacts().get(i).getEmail());
        contactsAdapterHolder.email.setText(exam.getContacts().get(i).getPhone().getMobile());
    }

    @Override
    public int getItemCount() {
        return exam.getContacts().size();
    }



  /*  private Context mcontext;
    private Example Exam;

    public AdapterHolder(Context mcontext, Example Exam) {
        this.mcontext = mcontext;
        this.Exam = Exam;
    }

    class ContactsAdapterHolder extends RecyclerView.ViewHolder{
        TextView name, email, add;
      //  Image

        public ContactsAdapterHolder(@NonNull View item){
            super(item);

            name = item.findViewById(R.id.tv_name);
            email = item.findViewById(R.id.tv_email);
            add = item.findViewById(R.id.tv_add);
        }
    }


    @NonNull
    @Override
    public ContactsAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.layout_card, viewGroup, false);
                return new ContactsAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapterHolder contactsAdapterHolder, int i) {
        contactsAdapterHolder.name.setText(Exam.getContacts().get(i).getName());
        contactsAdapterHolder.add.setText(Exam.getContacts().get(i).getAddress());
        contactsAdapterHolder.email.setText(Exam.getContacts().get(i).getEmail());
        contactsAdapterHolder.email.setText(Exam.getContacts().get(i).getPhone().getMobile());


    }


    @Override
    public int getItemCount() {
        return Exam.getContacts().size();
    }*/
}

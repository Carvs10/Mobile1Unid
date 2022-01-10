package com.example.trabalho1unidade.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.trabalho1unidade.R;

public class InfoDigalogFragment extends DialogFragment implements DialogInterface.OnClickListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Desenvolvido por:");
        builder.setMessage("João Victtor Carvalho de Luna\nMariana Medeiros Pires\nMatheus de Andrade Silva\nPedro Henrique Alves Cardoso");

        builder.setPositiveButton("Ver site", this);
        builder.setNegativeButton("Voltar", this);

        return builder.create();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        Activity activity = getActivity();

        if(which == -1){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Carvs10/Mobile1Unid"));
            startActivity(browserIntent);
        }

        if(activity instanceof OnClickOnInfo){
            OnClickOnInfo listener = (OnClickOnInfo) activity;
            listener.onClick(which);
        }
    }

    public interface OnClickOnInfo{
        public void onClick(int button);
    }
}
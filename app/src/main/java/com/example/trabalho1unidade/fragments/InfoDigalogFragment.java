package com.example.trabalho1unidade.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabalho1unidade.R;

public class InfoDigalogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Desenvolvido por:");
        builder.setMessage("João Victtor Carvalho de Luna\nMariana\nMatheus de Andrade Silva\nPedro Henrique Alves Cardoso");

        return builder.create();
    }


}
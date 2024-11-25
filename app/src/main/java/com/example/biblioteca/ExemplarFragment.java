package com.example.biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/*
 *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
 */
public class ExemplarFragment extends Fragment {


    private EditText etExemplarID, etEdicao;

    private TextView tvListarE;

    private RadioGroup rgExemplar;

    private RadioButton rbLivro, rbRevista;

    private View view;

    public ExemplarFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exemplar, container, false);

        etExemplarID = view.findViewById(R.id.etExemplarID);
        etEdicao = view.findViewById(R.id.etEdicao);

        rgExemplar = view.findViewById(R.id.rgExemplar);
        rbLivro = view.findViewById(R.id.rbLivro);
        rbRevista = view.findViewById(R.id.rbRevista);

        rbLivro.setChecked(true);

        rgExemplar.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbLivro) {
                etExemplarID.setHint(R.string.et_isbn);
                etEdicao.setVisibility(View.VISIBLE);
            } else {
                etExemplarID.setHint(R.string.et_issn);
                etEdicao.setVisibility(View.GONE);
            }
        });

        tvListarE = view.findViewById(R.id.tvListarE);
        tvListarE.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}
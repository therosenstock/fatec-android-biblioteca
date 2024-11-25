package com.example.biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.biblioteca.model.Aluno;
import com.example.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;

/*
 *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
 */
public class AluguelFragment extends Fragment {


    private Spinner spExemplar, spAluno;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_aluguel, container, false);

        spExemplar = view.findViewById(R.id.spExemplar);
        spAluno = view.findViewById(R.id.spAluno);

        preencheSpinnerExemplar();
        preencheSpinnerAluno();

        return view;
    }

    private void preencheSpinnerExemplar(){

        Livro livro = new Livro();

        livro.setIsbn("0");
        livro.setNome("Selecione um Exemplar");

        List<Livro> livros = new ArrayList<>();

        livros.add(0, livro);

        ArrayAdapter ad = new ArrayAdapter<>(view.getContext(),
                android.R.layout.simple_spinner_item,
                livros);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spExemplar.setAdapter(ad);

    }

    private void preencheSpinnerAluno(){

        Aluno aluno = new Aluno();

        aluno.setRa(0);
        aluno.setNome("Selecione um Aluno");

        List<Aluno> alunos = new ArrayList<>();

        alunos.add(0, aluno);

        ArrayAdapter ad = new ArrayAdapter<>(view.getContext(),
                android.R.layout.simple_spinner_item,
                alunos);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAluno.setAdapter(ad);
    }
}
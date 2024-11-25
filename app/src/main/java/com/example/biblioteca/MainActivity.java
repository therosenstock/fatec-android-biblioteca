package com.example.biblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();
        Fragment fragment = this.getFragment(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    private Fragment getFragment(Bundle bundle) {
        if (bundle == null) return new InicioFragment();
        String tipo = bundle.getString("tipo");

        System.out.println(tipo);
        if (tipo == null) return new InicioFragment();
        switch (tipo) {
            case "inicio":
                return new InicioFragment();
            case "aluno":
                return new AlunoFragment();
            case "aluguel":
                return new AluguelFragment();
            case "exemplar":
                return new ExemplarFragment();
            default:
                return new InicioFragment();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);

        if (id == R.id.item_aluno)
            bundle.putString("tipo", "aluno");
        else if (id == R.id.item_aluguel)
            bundle.putString("tipo", "aluguel");
        else if (id == R.id.item_exemplar)
            bundle.putString("tipo", "exemplar");
        else
            return super.onOptionsItemSelected(item);

        intent.putExtras(bundle);
        this.startActivity(intent);
        this.finish();
        return true;
    }
}
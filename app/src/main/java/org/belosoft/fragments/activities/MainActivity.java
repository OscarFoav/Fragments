package org.belosoft.fragments.activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.belosoft.fragments.R;
import org.belosoft.fragments.fragments.DataFragment;
import org.belosoft.fragments.fragments.DetailsFragment;

import static org.belosoft.fragments.R.id.detailsFragment;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener{

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();

    }

    @Override
    public void sendData(String text) {
        // llamar al metodo renderizar texto de el DetailFragment
        // pasandole el texto que recibimos por parametro en este mismo metodo

        if (isMultiPanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }

    }

    private void setMultiPanel() {
        isMultiPanel = (getSupportFragmentManager().findFragmentById(detailsFragment)) != null;
    }
}

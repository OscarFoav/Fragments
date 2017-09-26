package org.belosoft.fragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.belosoft.fragments.R;


public class DataFragment extends Fragment {

    private EditText textData;
    private Button btnSend;
    private DataListener callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data, container, false);

        // logica para capturar los elementos de la UI
        textData = (EditText) view.findViewById(R.id.editTextData);
        btnSend = (Button) view.findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSend = textData.getText().toString();
                callback.sendData(textToSend);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public interface DataListener {
        void sendData(String text);
    }
}

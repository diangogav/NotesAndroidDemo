package com.example.notesapplication;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

public class NoteFragmentAdd extends DialogFragment {

    private NoteFragmentAddViewModel mViewModel;
    private View view;

    private EditText editTextTitle;
    private EditText editTextContent;
    private RadioGroup radioGroupColor;
    private Switch switchFavorite;

    public static NoteFragmentAdd newInstance() {
        return new NoteFragmentAdd();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.note_fragment_add_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NoteFragmentAddViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Message")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String title = editTextTitle.getText().toString();
                        String content = editTextContent.getText().toString();
                        String color = "Blue";

                        switch (radioGroupColor.getCheckedRadioButtonId()) {
                            case R.id.radioButtonColorBlue:
                                color = "Blue";
                                break;
                            case R.id.radioButtonColorGreen:
                                color = "Green";
                                break;
                            case R.id.radioButtonColorRed:
                                color = "Red";
                                break;
                        }

                        boolean isFavorite = switchFavorite.isChecked();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();

        editTextTitle = view.findViewById(R.id.editTextNoteAddTitle);
        editTextContent = view.findViewById(R.id.editTextNoteAddContent);
        radioGroupColor = view.findViewById(R.id.radioGroupNoteAddColor);
        switchFavorite = view.findViewById(R.id.imageViewNoteFavorite);

        view = inflater.inflate(R.layout.note_fragment_add_fragment, null);
        builder.setView(view);

        // Create the AlertDialog object and return it
        return builder.create();
    }

}

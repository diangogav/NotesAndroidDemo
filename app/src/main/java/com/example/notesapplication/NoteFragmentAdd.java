package com.example.notesapplication;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
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

    public static NoteFragmentAdd newInstance() {
        return new NoteFragmentAdd();
    }

    private View view;
    private EditText editTextTitle;
    private EditText editTextContent;
    private RadioGroup radioGroupColor;
    private Switch switchFavorite;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.note_fragment_add_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Message")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
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

                        // TODO: Buscar la manera correcta de utilizar el ViewModelProvider
                        NoteFragmentAddViewModel viewModelAddNote = ViewModelProviders.of(getActivity()).get(NoteFragmentAddViewModel.class);
                        viewModelAddNote.addNote(new NoteEntity(title, content, isFavorite, color));
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.note_fragment_add_fragment, null);

        editTextTitle = view.findViewById(R.id.editTextNoteAddTitle);
        editTextContent = view.findViewById(R.id.editTextNoteAddContent);
        radioGroupColor = view.findViewById(R.id.radioGroupNoteAddColor);
        switchFavorite = view.findViewById(R.id.switchNoteFavorite);

        builder.setView(view);

        // Create the AlertDialog object and return it
        return builder.create();
    }

}

// Generated by view binder compiler. Do not edit!
package com.androidsquad.myportfolio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.androidsquad.myportfolio.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SkillsdialogBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageButton cancel;

  @NonNull
  public final Button save;

  @NonNull
  public final EditText skillName;

  private SkillsdialogBinding(@NonNull RelativeLayout rootView, @NonNull ImageButton cancel,
      @NonNull Button save, @NonNull EditText skillName) {
    this.rootView = rootView;
    this.cancel = cancel;
    this.save = save;
    this.skillName = skillName;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SkillsdialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SkillsdialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.skillsdialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SkillsdialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cancel;
      ImageButton cancel = ViewBindings.findChildViewById(rootView, id);
      if (cancel == null) {
        break missingId;
      }

      id = R.id.save;
      Button save = ViewBindings.findChildViewById(rootView, id);
      if (save == null) {
        break missingId;
      }

      id = R.id.skillName;
      EditText skillName = ViewBindings.findChildViewById(rootView, id);
      if (skillName == null) {
        break missingId;
      }

      return new SkillsdialogBinding((RelativeLayout) rootView, cancel, save, skillName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
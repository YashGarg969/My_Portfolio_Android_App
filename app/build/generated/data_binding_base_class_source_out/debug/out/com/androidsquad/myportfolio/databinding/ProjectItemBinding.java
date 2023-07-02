// Generated by view binder compiler. Do not edit!
package com.androidsquad.myportfolio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.androidsquad.myportfolio.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProjectItemBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView demo;

  @NonNull
  public final TextView desc;

  @NonNull
  public final TextView pTitle;

  @NonNull
  public final TextView txt1;

  @NonNull
  public final TextView txt2;

  @NonNull
  public final TextView txt3;

  private ProjectItemBinding(@NonNull RelativeLayout rootView, @NonNull TextView demo,
      @NonNull TextView desc, @NonNull TextView pTitle, @NonNull TextView txt1,
      @NonNull TextView txt2, @NonNull TextView txt3) {
    this.rootView = rootView;
    this.demo = demo;
    this.desc = desc;
    this.pTitle = pTitle;
    this.txt1 = txt1;
    this.txt2 = txt2;
    this.txt3 = txt3;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProjectItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.project_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProjectItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.demo;
      TextView demo = ViewBindings.findChildViewById(rootView, id);
      if (demo == null) {
        break missingId;
      }

      id = R.id.desc;
      TextView desc = ViewBindings.findChildViewById(rootView, id);
      if (desc == null) {
        break missingId;
      }

      id = R.id.pTitle;
      TextView pTitle = ViewBindings.findChildViewById(rootView, id);
      if (pTitle == null) {
        break missingId;
      }

      id = R.id.txt1;
      TextView txt1 = ViewBindings.findChildViewById(rootView, id);
      if (txt1 == null) {
        break missingId;
      }

      id = R.id.txt2;
      TextView txt2 = ViewBindings.findChildViewById(rootView, id);
      if (txt2 == null) {
        break missingId;
      }

      id = R.id.txt3;
      TextView txt3 = ViewBindings.findChildViewById(rootView, id);
      if (txt3 == null) {
        break missingId;
      }

      return new ProjectItemBinding((RelativeLayout) rootView, demo, desc, pTitle, txt1, txt2,
          txt3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
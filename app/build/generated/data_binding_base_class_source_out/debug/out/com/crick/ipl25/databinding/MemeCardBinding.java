// Generated by data binding compiler. Do not edit!
package com.crick.ipl25.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.cric.ipl25.Meme_data;
import com.crick.ipl25.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class MemeCardBinding extends ViewDataBinding {
  @NonNull
  public final TextView LikeCount;

  @NonNull
  public final TextView Likes;

  @NonNull
  public final CardView cardView4;

  @NonNull
  public final ImageButton likeMeme;

  @NonNull
  public final ImageView postimage;

  @NonNull
  public final ImageView reportBtn;

  @NonNull
  public final ImageButton shareMeme;

  @NonNull
  public final TextView teamName;

  @Bindable
  protected Meme_data mMemeCard;

  protected MemeCardBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView LikeCount, TextView Likes, CardView cardView4, ImageButton likeMeme,
      ImageView postimage, ImageView reportBtn, ImageButton shareMeme, TextView teamName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.LikeCount = LikeCount;
    this.Likes = Likes;
    this.cardView4 = cardView4;
    this.likeMeme = likeMeme;
    this.postimage = postimage;
    this.reportBtn = reportBtn;
    this.shareMeme = shareMeme;
    this.teamName = teamName;
  }

  public abstract void setMemeCard(@Nullable Meme_data memeCard);

  @Nullable
  public Meme_data getMemeCard() {
    return mMemeCard;
  }

  @NonNull
  public static MemeCardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.meme_card, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static MemeCardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<MemeCardBinding>inflateInternal(inflater, R.layout.meme_card, root, attachToRoot, component);
  }

  @NonNull
  public static MemeCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.meme_card, null, false, component)
   */
  @NonNull
  @Deprecated
  public static MemeCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<MemeCardBinding>inflateInternal(inflater, R.layout.meme_card, null, false, component);
  }

  public static MemeCardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static MemeCardBinding bind(@NonNull View view, @Nullable Object component) {
    return (MemeCardBinding)bind(component, view, R.layout.meme_card);
  }
}

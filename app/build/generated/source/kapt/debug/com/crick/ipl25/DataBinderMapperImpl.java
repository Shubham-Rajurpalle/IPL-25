package com.crick.ipl25;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.crick.ipl25.databinding.ActivityMemeAddBindingImpl;
import com.crick.ipl25.databinding.ActivityMemeBindingImpl;
import com.crick.ipl25.databinding.FragmentBindingImpl;
import com.crick.ipl25.databinding.FragmentQuizBindingImpl;
import com.crick.ipl25.databinding.FragmentReportBindingImpl;
import com.crick.ipl25.databinding.FragmentReportChatBindingImpl;
import com.crick.ipl25.databinding.FragmentTeamSelectionFragementBindingImpl;
import com.crick.ipl25.databinding.MemeCardBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMEME = 1;

  private static final int LAYOUT_ACTIVITYMEMEADD = 2;

  private static final int LAYOUT_FRAGMENT = 3;

  private static final int LAYOUT_FRAGMENTQUIZ = 4;

  private static final int LAYOUT_FRAGMENTREPORT = 5;

  private static final int LAYOUT_FRAGMENTREPORTCHAT = 6;

  private static final int LAYOUT_FRAGMENTTEAMSELECTIONFRAGEMENT = 7;

  private static final int LAYOUT_MEMECARD = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.activity_meme, LAYOUT_ACTIVITYMEME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.activity_meme_add, LAYOUT_ACTIVITYMEMEADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.fragment, LAYOUT_FRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.fragment_quiz, LAYOUT_FRAGMENTQUIZ);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.fragment_report, LAYOUT_FRAGMENTREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.fragment_report_chat, LAYOUT_FRAGMENTREPORTCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.fragment_team_selection_fragement, LAYOUT_FRAGMENTTEAMSELECTIONFRAGEMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.crick.ipl25.R.layout.meme_card, LAYOUT_MEMECARD);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMEME: {
          if ("layout/activity_meme_0".equals(tag)) {
            return new ActivityMemeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_meme is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMEMEADD: {
          if ("layout/activity_meme_add_0".equals(tag)) {
            return new ActivityMemeAddBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_meme_add is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENT: {
          if ("layout/fragment_0".equals(tag)) {
            return new FragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTQUIZ: {
          if ("layout/fragment_quiz_0".equals(tag)) {
            return new FragmentQuizBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_quiz is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREPORT: {
          if ("layout/fragment_report_0".equals(tag)) {
            return new FragmentReportBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_report is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREPORTCHAT: {
          if ("layout/fragment_report_chat_0".equals(tag)) {
            return new FragmentReportChatBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_report_chat is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTEAMSELECTIONFRAGEMENT: {
          if ("layout/fragment_team_selection_fragement_0".equals(tag)) {
            return new FragmentTeamSelectionFragementBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_team_selection_fragement is invalid. Received: " + tag);
        }
        case  LAYOUT_MEMECARD: {
          if ("layout/meme_card_0".equals(tag)) {
            return new MemeCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for meme_card is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "memeCard");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/activity_meme_0", com.crick.ipl25.R.layout.activity_meme);
      sKeys.put("layout/activity_meme_add_0", com.crick.ipl25.R.layout.activity_meme_add);
      sKeys.put("layout/fragment_0", com.crick.ipl25.R.layout.fragment);
      sKeys.put("layout/fragment_quiz_0", com.crick.ipl25.R.layout.fragment_quiz);
      sKeys.put("layout/fragment_report_0", com.crick.ipl25.R.layout.fragment_report);
      sKeys.put("layout/fragment_report_chat_0", com.crick.ipl25.R.layout.fragment_report_chat);
      sKeys.put("layout/fragment_team_selection_fragement_0", com.crick.ipl25.R.layout.fragment_team_selection_fragement);
      sKeys.put("layout/meme_card_0", com.crick.ipl25.R.layout.meme_card);
    }
  }
}

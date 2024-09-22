package com.crick.ipl25.databinding;
import com.cric.ipl25.meme.Meme_data;
import com.crick.ipl25.R;
import com.crick.ipl25.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MemeCardBindingImpl extends MemeCardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardView4, 3);
        sViewsWithIds.put(R.id.postimage, 4);
        sViewsWithIds.put(R.id.reportBtn, 5);
        sViewsWithIds.put(R.id.likeMeme, 6);
        sViewsWithIds.put(R.id.shareMeme, 7);
        sViewsWithIds.put(R.id.LikeCount, 8);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MemeCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private MemeCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.ImageButton) bindings[6]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.TextView) bindings[1]
            );
        this.Likes.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.teamName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.memeCard == variableId) {
            setMemeCard((Meme_data) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMemeCard(@Nullable Meme_data MemeCard) {
        this.mMemeCard = MemeCard;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.memeCard);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String memeCardYourTeam = null;
        int memeCardLikes = 0;
        Meme_data memeCard = mMemeCard;
        java.lang.String stringValueOfMemeCardLikes = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (memeCard != null) {
                    // read memeCard.yourTeam
                    memeCardYourTeam = memeCard.getYourTeam();
                    // read memeCard.likes
                    memeCardLikes = memeCard.getLikes();
                }


                // read String.valueOf(memeCard.likes)
                stringValueOfMemeCardLikes = java.lang.String.valueOf(memeCardLikes);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.Likes, stringValueOfMemeCardLikes);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.teamName, memeCardYourTeam);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): memeCard
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
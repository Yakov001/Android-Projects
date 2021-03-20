package android.bignerdranch.com;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\b\u0007\u00a8\u0006\u0017"}, d2 = {"Landroid/bignerdranch/com/BeatBoxFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mBeatBox", "Landroid/bignerdranch/com/BeatBox;", "mSpeed", "", "mSpeed$1", "getSpeed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "Companion", "SoundAdapter", "SoundHolder", "app_debug"})
public final class BeatBoxFragment extends androidx.fragment.app.Fragment {
    private android.bignerdranch.com.BeatBox mBeatBox;
    private float mSpeed$1 = 1.0F;
    private static float mSpeed = 1.0F;
    @org.jetbrains.annotations.NotNull()
    public static final android.bignerdranch.com.BeatBoxFragment.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public final float getSpeed() {
        return 0.0F;
    }
    
    public BeatBoxFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Landroid/bignerdranch/com/BeatBoxFragment$SoundHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroid/bignerdranch/com/databinding/ListItemSoundBinding;", "(Landroid/bignerdranch/com/BeatBoxFragment;Landroid/bignerdranch/com/databinding/ListItemSoundBinding;)V", "mBinding", "bind", "", "sound", "Landroid/bignerdranch/com/Sound;", "app_debug"})
    final class SoundHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.bignerdranch.com.databinding.ListItemSoundBinding mBinding;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        android.bignerdranch.com.Sound sound) {
        }
        
        public SoundHolder(@org.jetbrains.annotations.NotNull()
        android.bignerdranch.com.databinding.ListItemSoundBinding binding) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Landroid/bignerdranch/com/BeatBoxFragment$SoundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/bignerdranch/com/BeatBoxFragment$SoundHolder;", "Landroid/bignerdranch/com/BeatBoxFragment;", "sounds", "", "Landroid/bignerdranch/com/Sound;", "(Landroid/bignerdranch/com/BeatBoxFragment;Ljava/util/List;)V", "mSounds", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
    final class SoundAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<android.bignerdranch.com.BeatBoxFragment.SoundHolder> {
        private java.util.List<android.bignerdranch.com.Sound> mSounds;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.bignerdranch.com.BeatBoxFragment.SoundHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        android.bignerdranch.com.BeatBoxFragment.SoundHolder holder, int position) {
        }
        
        public SoundAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<android.bignerdranch.com.Sound> sounds) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Landroid/bignerdranch/com/BeatBoxFragment$Companion;", "", "()V", "mSpeed", "", "getMSpeed", "()F", "setMSpeed", "(F)V", "getSpeed", "getSpeedForBar", "", "newInstance", "Landroid/bignerdranch/com/BeatBoxFragment;", "app_debug"})
    public static final class Companion {
        
        public final float getMSpeed() {
            return 0.0F;
        }
        
        public final void setMSpeed(float p0) {
        }
        
        public final float getSpeed() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSpeedForBar() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.bignerdranch.com.BeatBoxFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}